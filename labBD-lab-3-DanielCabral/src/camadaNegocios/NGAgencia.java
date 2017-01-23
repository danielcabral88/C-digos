package camadaNegocios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import camadaDAO.AgenciaDAO;
import camadaDAO.ConnectionManager;
import camadaDTO.Agencia;

public class NGAgencia {
	
	public boolean Inserir(Agencia objAgencia) throws SQLException {
		return false;
	}

	public boolean Atualizar(Agencia objAgencia) {
		return false;
	}

	public boolean Deletar(Agencia objAgencia) {
		return false;
	}

	public List<Agencia> Consultar() throws SQLException, ClassNotFoundException {
		// Inserir validações
		AgenciaDAO objDados = new AgenciaDAO();
		return objDados.Consultar();
		
	}

	public Agencia consultaPorID(int NUMERO) throws SQLException, ClassNotFoundException {
		// Inserir validações
		AgenciaDAO objDados = new AgenciaDAO();
		return objDados.consultaPorID(NUMERO);
	}

}
