/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDAO;

import ObjetosDTO.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuário
 */
public class DisciplinaDAO {
    private static final String tableName = "disciplina";
    private static final String sqlInsert = "INSERT INTO " + tableName + " (nome_disciplina, carga_horaria, professor_matricula1) VALUES (?, ?, ?)";
    private static final String sqlSelectMax = "select max(id_disciplina) from " + tableName;
    //private static Connection conn = null;
    
    
    public DisciplinaDAO(){}
    
    public boolean inserir(Disciplina disciplina){
		Connection conn = ConnectionManager.connect();
		try {
			PreparedStatement pstm = conn.prepareStatement(sqlInsert);
			pstm.setString(1, disciplina.getNomeDisciplina());
			pstm.setString(2,String.valueOf(disciplina.getCargaHoraria()));
                        pstm.setString(3, String.valueOf(disciplina.getProfessor().getMatricula()));
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
