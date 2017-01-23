/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDAO;

import ObjetosDTO.DisciplinaAluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuário
 */
public class DisciplinaAlunoDAO {
    private static final String tableName = "disciplina_has_aluno";
    private static final String sqlInsert = "INSERT INTO " + tableName + " (disciplina_id_disciplina, aluno_matricula) VALUES (?, ?)";
   //private static Connection conn = null;
	
    public DisciplinaAlunoDAO(){}

    public boolean Inserir(DisciplinaAluno objDisciplinaAluno){
        try{
            Connection conn = ConnectionManager.connect();
            PreparedStatement pstm = conn.prepareStatement(sqlInsert); // O preparedStatement cria o caminho para o comando sql
            pstm.setString(1, String.valueOf(objDisciplinaAluno.getidDisciplina()));
            pstm.setString(2, String.valueOf(objDisciplinaAluno.getidAluno()));
            return (pstm.executeUpdate() > 0); // Como o retorno é booleano eu uso o metodo update do pstm*/
            
        }catch (SQLException ex){
            ex.printStackTrace();
        }
	return true;
    }
}
