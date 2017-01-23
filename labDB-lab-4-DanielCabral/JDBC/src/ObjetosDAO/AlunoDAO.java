/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDAO;

import ObjetosDTO.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuário
 */
public class AlunoDAO {
    private static final String tableName = "aluno";
    private static final String sqlInsert = "INSERT INTO " + tableName + " (nome, curso_id_curso) VALUES (?, ?)";
    private static final String sqlSelectMax = "select max(matricula) from " + tableName;
    //private static Connection conn = null;          
    
    
    public AlunoDAO(){}
    
    public boolean inserir (Aluno aluno){
                Connection conn = ConnectionManager.connect();
		try {
			PreparedStatement pstm = conn.prepareStatement(sqlInsert);
			pstm.setString(1, aluno.getNome());
                        pstm.setString(2, String.valueOf(aluno.getCurso().getIdCurso()));
                        pstm.executeUpdate();
                        
			
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
