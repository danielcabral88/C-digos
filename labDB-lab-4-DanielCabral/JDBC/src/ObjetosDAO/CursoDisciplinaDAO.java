/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDAO;

import ObjetosDTO.CursoDisciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuário
 */
public class CursoDisciplinaDAO {
    private static final String tableName = "curso_has_disciplina";
    private static final String sqlInsert = "INSERT INTO " + tableName + " (curso_id_curso, disciplina_id_disciplina) VALUES (?, ?)";
    //private static Connection conn = null;
	
    public CursoDisciplinaDAO(){}

    public boolean Inserir(CursoDisciplina objCursoDisciplina){
        try{
            Connection conn = ConnectionManager.connect();
            PreparedStatement pstm = conn.prepareStatement(sqlInsert); // O preparedStatement cria o caminho para o comando sql
            pstm.setString(1, String.valueOf(objCursoDisciplina.getidCurso()));
            pstm.setString(2, String.valueOf(objCursoDisciplina.getidDisciplina()));
            return (pstm.executeUpdate() > 0); // Como o retorno é booleano eu uso o metodo update do pstm*/
            
        }catch (SQLException ex){
            ex.printStackTrace();
        }
	return true;	
    }
    
    
}
