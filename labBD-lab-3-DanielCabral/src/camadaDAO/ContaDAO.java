package camadaDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import camadaDTO.*;

public class ContaDAO {
	private static final String tableName = "Conta";
	private static final String sqlInsert = "INSERT INTO " + tableName + "(NUMERO, DATA_ABERTURA, SALDO, agencia_NUMERO) VALUES (?, ?, ?, ?)";
	private static final String sqlUpdate = "UPDATE INTO " +tableName + "  ";
	private static final String sqlDelete = "";
	private static final String sqlSelect = "SELECT * FROM " + tableName;
	private static final String sqlSelectByID = "SELECT * FROM " + tableName + " WHERE NUMERO = ?";

	private Connection conn = null;

	public ContaDAO(){}

	public boolean Inserir(Conta objConta) throws SQLException {
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		PreparedStatement pstm = conn.prepareStatement(sqlInsert);
		// pstm.setString(1, String.valueOf(objCliente.getID())); // Seto os
		// valores aos parâmetros do comando sql
		pstm.setObject(1, objConta.getNumero(), java.sql.Types.CHAR);
		pstm.setString(2, objConta.getDataAbertura());
		pstm.setFloat(3, objConta.getSaldo());
		// pstm.setString(4, String.valueOf(objCliente.getTelefone()));
		pstm.setObject(4, objConta.getAgenciaNumero(), java.sql.Types.INTEGER);
		return (pstm.executeUpdate() > 0);
	}
	
	public boolean inserirBath (List<Conta> objListConta){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		try {
			PreparedStatement pstm = conn.prepareStatement(sqlInsert);
			for (Conta c : objListConta){
				pstm.setString(1, c.getNumero());
				pstm.setString(2, c.getDataAbertura());
				pstm.setFloat(3, c.getSaldo());
				pstm.setInt(4, c.getAgenciaNumero());
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

	public boolean Atualizar(Conta objConta) {
		return false;
	}

	public boolean Deletar(Conta objConta) {
		return false;
	}

	public List<Conta> Consultar() throws SQLException {
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		List<Conta> objContas = new ArrayList<Conta>();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sqlSelect);

		while (rs.next()) {
			Conta objConta = new Conta(rs.getString("NUMERO"), rs.getDate("DATA_ABERTURA"), rs.getFloat("SALDO"), rs.getInt("agencia_NUMERO"));
			objContas.add(objConta);
		}
		return objContas;
	}

	public Conta consultaPorID(String NUMERO){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		Conta objConta = new Conta();
		try{
			PreparedStatement pstm = conn.prepareStatement(sqlSelectByID);
			pstm.setString(1, NUMERO);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				objConta = new Conta(rs.getString("NUMERO"), rs.getDate("DATA_ABERTURA"), rs.getFloat("SALDO"), rs.getInt("agencia_NUMERO"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		

		return objConta;

	}
	
	public boolean atualizarSaldo (boolean op, float valor, String conta){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		float saldo;
		try{
			Statement stm = conn.createStatement();
			if (op == true){
				ResultSet rs = stm.executeQuery("select saldo from conta where numero = " + conta);
				saldo = rs.getFloat(1);
				stm.executeUpdate("update conta set saldo = " + (saldo + valor) + " where numero = " + conta);
				return true;
			}
			else {
				ResultSet rs = stm.executeQuery("select saldo from conta where numero = " + conta);
				saldo = rs.getFloat(1);
				stm.executeUpdate("update conta set saldo = " + (saldo - valor) + " where numero = " + conta);
				return true;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;		
	}

}
