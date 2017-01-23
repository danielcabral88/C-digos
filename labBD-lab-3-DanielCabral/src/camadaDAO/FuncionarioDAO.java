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

public class FuncionarioDAO {
	private static final String tableName = "Funcionario";
	private static final String sqlInsert = "INSERT INTO " + tableName + " (ID, NOME, ENDERECO, SALARIO, agencia_NUMERO) VALUES (?, ?, ?, ?, ?)";
	private static final String sqlUpdate = "";
	private static final String sqlDelete = "";
	private static final String sqlSelect = "SELECT * FROM Funcionario";
	private static final String sqlSelectByID = "SELECT ID, NOME FROM "	+ tableName + " WHERE ID = ?";

	private Connection conn = null;

	public FuncionarioDAO() throws SQLException, ClassNotFoundException {
		ConnectionManager objConn = new ConnectionManager();
		conn = objConn.connect();
	}

	public boolean Inserir(Funcionario objFuncionario) throws SQLException {
		PreparedStatement pstm = conn.prepareStatement(sqlInsert);
		// pstm.setString(1, String.valueOf(objCliente.getID())); // Seto os
		// valores aos parâmetros do comando sql
		pstm.setObject(1, objFuncionario.getID(), java.sql.Types.CHAR);
		pstm.setString(2, objFuncionario.getNome());
		pstm.setString(3, objFuncionario.getEndereco());
		pstm.setFloat(4, objFuncionario.getSalario());
		// pstm.setString(4, String.valueOf(objCliente.getTelefone()));
		pstm.setObject(5, objFuncionario.getAgenciaNumero(),
				java.sql.Types.INTEGER);
		return (pstm.executeUpdate() > 0);
	}

	public boolean Atualizar(Funcionario objFuncionario) {
		return false;
	}

	public boolean Deletar(Funcionario objFuncionario) {
		return false;
	}

	public List<Funcionario> Consultar() throws SQLException {
		List<Funcionario> objFuncionarios = new ArrayList<Funcionario>();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sqlSelect);

		while (rs.next()) {
			Funcionario objFuncionario = new Funcionario((rs.getString("NUMERO")).charAt(0), rs.getString("NOME"), rs.getString("ENDERECO"), rs.getFloat("SALARIO"), rs.getInt("agencia_NUMERO"));
			objFuncionarios.add(objFuncionario);
		}
		return objFuncionarios;
	}

	public Funcionario consultaPorID(char ID) throws SQLException {
		Funcionario objFuncionario = new Funcionario();
		PreparedStatement pstm = conn.prepareStatement(sqlSelectByID);
		pstm.setString(0, String.valueOf(ID));
		ResultSet rs = pstm.getResultSet();

		if (rs.first()) {
			objFuncionario = new Funcionario((rs.getString("NUMERO")).charAt(0), rs.getString("NOME"), rs.getString("ENDERECO"), rs.getFloat("SALARIO"), rs.getInt("agencia_NUMERO"));
		}

		return objFuncionario;

	}

}
