package camadaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import camadaDTO.*;

public class ClienteDAO {

	// Variáveis de uso geral com comandos Sql

	private static final String tableName = "cliente";
	private static final String sqlInsert = "INSERT INTO " + tableName + " (ID, NOME, ENDERECO, TELEFONE) VALUES (?, ?, ?, ?)";
	private static final String sqlUpdate = "";
	private static final String sqlDelete = "";
	private static final String sqlSelect = "SELECT DISTINCT * FROM " + tableName;
	private static final String sqlSelectNome = "SELECT * FROM " + tableName + " WHERE NOME LIKE ?";
	private static final String sqlSelectID = "SELECT * FROM " + tableName + " WHERE ID = ?";
	private static Connection conn = null;
	
	public ClienteDAO(){}

	public boolean Inserir(Cliente objCliente){
		/*PreparedStatement pstm = conn.prepareStatement(sqlInsert); // O preparedStatement cria o caminho para o comando sql
		// pstm.setString(1, String.valueOf(objCliente.getID())); // Seto os valores aos parâmetros do comando sql
		pstm.setObject(1, objCliente.getID(), java.sql.Types.CHAR);
		pstm.setString(2, objCliente.getNome());
		pstm.setString(3, objCliente.getEndereco());
		// pstm.setString(4, String.valueOf(objCliente.getTelefone()));
		pstm.setObject(4, objCliente.getTelefone(), java.sql.Types.CHAR);
		return (pstm.executeUpdate() > 0); // Como o retorno é booleano eu uso o metodo update do pstm*/
		return false;
	}
	
	public boolean inserirBath (List<Cliente> objListCliente){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		try {
			PreparedStatement pstm = conn.prepareStatement(sqlInsert);
			for (Cliente c : objListCliente){
				pstm.setString(1, c.getID());
				pstm.setString(2, c.getNome());
				pstm.setString(3, c.getEndereco());
				pstm.setString(4, c.getTelefone());
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

	public boolean Atualizar(Cliente objCliente) {
		return false;
	}

	public boolean Deletar(Cliente objCliente) {
		return false;
	}

	public List<Cliente> Consultar() {
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		List<Cliente> objClientes = new ArrayList<Cliente>(); // Cria-se um Array de Clientes
		try{
			Statement stm = conn.createStatement(); // Retorna ao objeto do tipo Statement o caminho para execução do comando sql
			ResultSet rs = stm.executeQuery(sqlSelect); // O resultSet recebe o resultado da consulta

			while (rs.next()) {
				Cliente objCliente = new Cliente(rs.getString("ID"), rs.getString("NOME"), rs.getString("ENDERECO"), rs.getString("TELEFONE")); // erro na hora de converter String para char
				objClientes.add(objCliente);
			}
		}	
		catch (SQLException ex){
			ex.printStackTrace(System.err);
		}
		return objClientes;
	}

	public Cliente consultaPorNome(String nome){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		Cliente objCliente = new Cliente();
		
		try {
			
			PreparedStatement pstm = conn.prepareStatement(sqlSelectNome);
			pstm.setString(1, ("%"+ nome + "%"));
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				objCliente = new Cliente(rs.getString("ID"), rs.getString("NOME"), rs.getString("ENDERECO"),rs.getString("TELEFONE"));
			}
			
		}catch (SQLException ex){
			ex.printStackTrace(System.err);
			return null;
		}
		
		return objCliente;
	}
	
	public Cliente consultaPorID(String ID){
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
		Cliente objCliente = new Cliente();
		try {
			
			PreparedStatement pstm = conn.prepareStatement(sqlSelectID);
			pstm.setString(1, ID);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				objCliente = new Cliente(rs.getString("ID"), rs.getString("NOME"), rs.getString("ENDERECO"),rs.getString("TELEFONE"));
			}
			
		}catch (SQLException ex){
			ex.printStackTrace(System.err);
			return null;
		}
		
		return objCliente;
	}

}
