package camadaNegocios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import camadaDAO.ClienteDAO;
import camadaDTO.Cliente;

public class NGCliente {
	
	public boolean Inserir(Cliente objCliente){
		
		// inserir validações
		
		ClienteDAO objDados = new ClienteDAO();
		return objDados.Inserir(objCliente);
		
	}

	public boolean inserirBath (List<Cliente> objListCliente){
		// Validações de campo
		
		ClienteDAO objDados = new ClienteDAO();
		return objDados.inserirBath(objListCliente);
	}

	public boolean Atualizar(Cliente objCliente) {
		return false;
	}

	public boolean Deletar(Cliente objCliente) {
		return false;
	}

	public List<Cliente> Consultar(){
		ClienteDAO objDados = new ClienteDAO();
		return objDados.Consultar();
	}

	public Cliente consultaPorNome(String nome){
		ClienteDAO objDados = new ClienteDAO();
		return objDados.consultaPorNome(nome);
	}
	
	public Cliente consultaPorID(String ID){
		ClienteDAO objDados = new ClienteDAO();
		return objDados.consultaPorID(ID);
	}
}
