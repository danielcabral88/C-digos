package camadaNegocios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import camadaDAO.ConnectionManager;
import camadaDAO.ContaDAO;
import camadaDAO.HistoricoDAO;
import camadaDTO.Historico;

public class NGHistorico {
	
	public boolean Inserir(Historico objHistorico) throws SQLException {
		
		// valida��es de campos obrigat�rios
		
		HistoricoDAO objDados = new HistoricoDAO();
		return objDados.Inserir(objHistorico);

	}
	
	public boolean inserirBath (List<Historico> objListHistorico){
		return false;
	}

	public List<Historico> Consultar () throws SQLException {
		return null;
	}

	public List<Historico> consultaPorID (String Cliente_ID){
		// valida��es
		HistoricoDAO objDados = new HistoricoDAO();
		return objDados.consultaPorID(Cliente_ID);
	}
	
	public List<Historico> consultaDistinct (){
		// implementar aqui as valida��es e campos obrigat�rios
		HistoricoDAO objDados = new HistoricoDAO();
		return objDados.consultaDistinct();
	}
	
	public List<String> getNomeMetaDados (){
		HistoricoDAO objDados = new HistoricoDAO();
		return objDados.getNomeMetaDados();
	}
	
	public boolean transfConta (String numConta1, String numConta2, float valor){
		// Fazer valida��es, tipo se a conta � valida... se o campos obrigat�rios est�o preenchidos...
		ContaDAO objDadosConta = new ContaDAO();
		if ((objDadosConta.consultaPorID(numConta1)) == null){
		}
		if ((objDadosConta.consultaPorID(numConta2)) == null){
			
		}
		
		
		HistoricoDAO objDados = new HistoricoDAO();
		return objDados.transfConta(numConta1, numConta2, valor);

	}

}
