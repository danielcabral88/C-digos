package camadaNegocios;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import camadaDAO.ContaDAO;
import camadaDTO.Agencia;
import camadaDTO.Conta;

public class NGConta {
	
	public boolean Inserir(Conta objConta) throws SQLException{
		// Inserir validações
		ContaDAO objDados = new ContaDAO();
		return objDados.Inserir(objConta);
	}

	public boolean inserirBath (List<Conta> objListConta){
		ContaDAO objDados = new ContaDAO();
		return objDados.inserirBath(objListConta);
	}
	
	public boolean Atualizar(Agencia objAgencia) {
		return false;
	}

	public boolean Deletar(Agencia objAgencia) {
		return false;
	}

	public List<Conta> Consultar() throws SQLException{
		// Inserir validações
		ContaDAO objDados = new ContaDAO();
		return objDados.Consultar();
	}

	public Conta consultaPorID(String NUMERO){
		// Inserir validações
		ContaDAO objDados = new ContaDAO();
		return objDados.consultaPorID(NUMERO);

	}
	
	public boolean atualizarSaldo (boolean op, float valor, String conta){
		return false;
	}

}
