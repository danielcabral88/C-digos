package camadaDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import camadaDTO.*;

public class HistoricoDAO {
	private static final String tableName = "Historico";
	private static final String sqlInsert = "INSERT INTO "+ tableName + " (CODIGO, OPERACAO, VALOR, Cliente_ID, Conta_NUMERO) VALUES (?, ?, ?, ?, ?)";
	private static final String sqlUpdate = "";
	private static final String sqlDelete = "";
	private static final String sqlSelect = "SELECT * FROM " + tableName;
	private static final String sqlSelectDistinct = "SELECT DISTINCT cliente_id, conta_numero FROM " + tableName;
	private static final String sqlSelectByID = "SELECT * FROM " + tableName + " WHERE Cliente_ID = ?";

	private static Connection conn = null;

	public HistoricoDAO(){}

	public boolean Inserir(Historico objHistorico) throws SQLException {
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		boolean bit;
		ContaDAO objContaDados = new ContaDAO();
		PreparedStatement pstm = conn.prepareStatement(sqlInsert); // O preparedStatement cria o caminho para o comando sql
		pstm.setInt(1, objHistorico.getCodigo());
		pstm.setBoolean(2, objHistorico.isOperacao());
		pstm.setFloat(3, objHistorico.getValor());
		pstm.setString(4, objHistorico.getClienteID());
		pstm.setString(5, objHistorico.getContaNumero());
		bit = objContaDados.atualizarSaldo(objHistorico.isOperacao(), objHistorico.getValor(), objHistorico.getContaNumero());	
		if (bit == true){
			return (pstm.executeUpdate() > 0);
		}
		else return false;
	}
	
	public boolean inserirBath (List<Historico> objListHistorico){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		try {
			PreparedStatement pstm = conn.prepareStatement(sqlInsert);
			for (Historico c : objListHistorico){
				pstm.setInt(1, c.getCodigo());
				pstm.setBoolean(2, c.isOperacao());
				pstm.setFloat(3, c.getValor());
				pstm.setString(4, c.getClienteID());
				pstm.setString(5, c.getContaNumero());
				pstm.addBatch();
			}
			int[] contar = pstm.executeBatch();
			for (int i : contar){
				if (i<1){
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean Atualizar(Historico objHistorico) {

		return false;
	}

	public boolean Deletar(Historico objHistorico) {
		return false;
	}

	public List<Historico> Consultar () throws SQLException {
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		ArrayList<Historico> objHistoricoList = new ArrayList<Historico>(); // Cria-se um Array de Clientes
		try{
			
			Statement stm = conn.createStatement(); // Retorna ao objeto do tipo Statement o caminho para execução do comando sql
			ResultSet rs = stm.executeQuery(sqlSelect); // O resultSet recebe o resultado da consulta

			while (rs.next()) {
				Historico objHistorico = new Historico(rs.getInt("CODIGO"), rs.getBoolean("OPERACAO"), rs.getFloat("VALOR"), rs.getString("Cliente_ID"), rs.getString("conta_NUMERO"));
				objHistoricoList.add(objHistorico);

				}
		}catch (SQLException e){
			e.getStackTrace();
		}
		return objHistoricoList;
	}

	public List<Historico> consultaPorID (String Cliente_ID){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		ArrayList<Historico> objHistoricoList = new ArrayList<Historico>(); // Cria-se um Array de Clientes
		try{
			PreparedStatement pstm = conn.prepareStatement(sqlSelectByID);
			// Statement stm = conn.createStatement(); // Retorna ao objeto do tipo
			// Statement o caminho para execução do comando sql
			pstm.setString(1, Cliente_ID);
			// ResultSet rs = stm.executeQuery(sqlSelect); // O resultSet recebe o resultado da consulta
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Historico objHistorico = new Historico(rs.getInt("CODIGO"), rs.getBoolean("OPERACAO"), rs.getFloat("VALOR"), rs.getString("Cliente_ID"), rs.getString("conta_NUMERO"));
				objHistoricoList.add(objHistorico);

				}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return objHistoricoList;
	}
	
	public List<Historico> consultaDistinct (){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		List<Historico> objHistoricoList = new ArrayList<Historico>(); // Cria-se um Array de Clientes
		try{
			
			Statement stm = conn.createStatement(); // Retorna ao objeto do tipo Statement o caminho para execução do comando sql
			ResultSet rs = stm.executeQuery(sqlSelectDistinct); // O resultSet recebe o resultado da consulta

			while (rs.next()) {
				Historico objHistorico = new Historico(1,true,0, rs.getString("Cliente_ID"), rs.getString("conta_NUMERO"));
				objHistoricoList.add(objHistorico);

				}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return objHistoricoList;
	}
	
	public List<String> getNomeMetaDados (){// Método criado no desespero para mandar de volta um arraylist com o nome da tabela
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select distinct cliente.nome, historico.conta_numero, conta.saldo from cliente inner join historico on cliente.id = historico.cliente_id inner join conta on historico.conta_numero = conta.numero");
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			List<String> c = new ArrayList<String>();
			for (int i = 0 ; i<cols ; i++){
				c.add(rsmd.getColumnName(i+1));
			}
			return c;
		}catch (SQLException e){
				e.printStackTrace();
				return null;
			}
		
	}
	
	public boolean transfConta (String numConta1, String numConta2, float valor){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		boolean bit;
		try{
			conn.setAutoCommit(false);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select distinct cliente_id from historico where conta_numero = " + numConta1);
			Historico objHistorico = new Historico(1,false,valor,rs.getString(1),numConta1);
			ResultSet rs2 = stm.executeQuery("select distinct cliente_id from historico where conta_numero = " + numConta2);
			Historico objHistorico2 = new Historico(1,true,valor,rs2.getString(1),numConta2);
			this.Inserir(objHistorico);
			Savepoint sp = conn.setSavepoint();
			bit = this.Inserir(objHistorico2);
			if(bit == false){
				conn.rollback(sp);
			}
			conn.commit();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
}
