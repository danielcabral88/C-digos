/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDAO;

import ObjetosDTO.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuário
 */
public class NotaDAO {
    private static final String tableName = "nota";
    private static final String sqlInsert = "INSERT INTO " + tableName + " (valor, aluno_matricula) VALUES (?, ?)";
    private static final String sqlSelectMax = "select max(nota) from " + tableName;
   // private static Connection conn = null;
    
    
    public NotaDAO(){}
    
    public boolean inserir (Nota nota){
		Connection conn = ConnectionManager.connect();
		try {
			PreparedStatement pstm = conn.prepareStatement(sqlInsert);
			pstm.setString(1,String.valueOf(nota.getValor()));
                        pstm.setString(2,String.valueOf(nota.getAluno().getMatricula()));
                        return (pstm.executeUpdate() > 0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
    public Integer consultaIDLast (){
        int valor = Integer.MIN_VALUE;
        try{
            Connection conn = ConnectionManager.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlSelectMax);
            while (rs.next()){
                valor = rs.getInt(1);
            }
            
        
        
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return valor;
    }
}
