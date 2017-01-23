/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDAO;

import ObjetosDTO.Disciplina;
import ObjetosDTO.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class ProfessorDAO {
    
    private static final String tableName = "professor";
    private static final String sqlInsert = "INSERT INTO " + tableName + " (nome,salario) VALUES (?, ?)";
    private static final String sqlSelectMax = "select max(matricula) from " + tableName;
   // private static Connection conn = null;
    
    
    public ProfessorDAO(){}
    
    public boolean inserir (Professor prof){
		Connection conn = ConnectionManager.connect();
		try {
			PreparedStatement pstm = conn.prepareStatement(sqlInsert);
			pstm.setString(1, prof.getNome());
			pstm.setString(2,String.valueOf(prof.getSalario()));
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
                return valor = rs.getInt(1);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return valor;
    }
    
}
