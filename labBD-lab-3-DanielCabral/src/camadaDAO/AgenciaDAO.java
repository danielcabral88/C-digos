package camadaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import camadaDTO.*;

public class AgenciaDAO {
	private static final String tableName = "Agencia";
	private static final String sqlInsert = "INSERT INTO " + tableName + " (NUMERO, NOME, ENDERECO, TELEFONE) VALUES (?, ?, ?, ?)";
	private static final String sqlUpdate = "";
	private static final String sqlDelete = "";
	private static final String sqlSelect = "SELECT * FROM Agencia";
	private static final String sqlSelectByID = "SELECT NUMERO, NOME FROM "+ tableName + " WHERE NUMERO = ?";

	private Connection conn = null;

	public AgenciaDAO() throws SQLException, ClassNotFoundException {
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
	}

	public boolean Inserir(Agencia objAgencia) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sqlInsert);
		// pstm.setString(1, String.valueOf(objCliente.getID())); // Seto os
		// valores aos parâmetros do comando sql
		pstm.setObject(1, objAgencia.getNumero(), java.sql.Types.INTEGER);
		pstm.setString(2, objAgencia.getNome());
		pstm.setString(3, objAgencia.getEndereco());
		// pstm.setString(4, String.valueOf(objCliente.getTelefone()));
		pstm.setObject(4, objAgencia.getTelefone(), java.sql.Types.CHAR);
		return (pstm.executeUpdate() > 0);
	}

	public boolean Atualizar(Agencia objAgencia) {
		return false;
	}

	public boolean Deletar(Agencia objAgencia) {
		return false;
	}

	public List<Agencia> Consultar() throws SQLException {
		List<Agencia> objAgencias = new ArrayList<Agencia>();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sqlSelect);

		while (rs.next()) {
			Agencia objAgencia = new Agencia(rs.getInt("NUMERO"),
					rs.getString("NOME"), rs.getString("ENDERECO"),
					(rs.getString("TELEFONE")).charAt(0));
			objAgencias.add(objAgencia);
		}
		return objAgencias;
	}

	public Agencia consultaPorID(int NUMERO) throws SQLException {
		Agencia objAgencia = new Agencia();
		PreparedStatement pstm = conn.prepareStatement(sqlSelectByID);
		pstm.setString(0, String.valueOf(NUMERO));
		ResultSet rs = pstm.getResultSet();

		if (rs.first()) {
			objAgencia = new Agencia(rs.getInt("NUMERO"), rs.getString("NOME"),
					rs.getString("ENDERECO"),
					(rs.getString("TELEFONE")).charAt(0));
		}

		return objAgencia;

	}

}
