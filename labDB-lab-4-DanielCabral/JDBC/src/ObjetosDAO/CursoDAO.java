/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDAO;

import ObjetosDTO.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuário
 */
public class CursoDAO {
    private static final String tableName = "curso";
    private static final String sqlInsert = "INSERT INTO " + tableName + " (turno, num_periodos, nome_coordenador, nome) VALUES (?, ?, ?, ?)";
    private static final String sqlSelectMax = "select max(id_curso) from " + tableName;
 //   private static Connection conn = null;
    
    
    public CursoDAO(){}
    
    public boolean inserir(Curso curso){
	Connection conn = ConnectionManager.connect();
	try {
		PreparedStatement pstm = conn.prepareStatement(sqlInsert);
		pstm.setString(1, curso.getTurno());
                pstm.setString(2, String.valueOf(curso.getNumPeriodos()));
                pstm.setString(3, curso.getNomeCoordenador());
                pstm.setString(4, curso.getNome());
		return (pstm.executeUpdate() > 1);
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
