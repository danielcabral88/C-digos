/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDTO;

/**
 *
 * @author Usuário
 */
public class DisciplinaAluno {
    private Integer idDisciplina;
    private Integer idAluno;
    
    public DisciplinaAluno(){}
    
    public DisciplinaAluno (int idDisciplina, int idAluno){
        this.idAluno = idAluno;
        this.idDisciplina = idDisciplina;
    }
    
    public Integer getidDisciplina (){
        return this.idDisciplina;
    }
    
    public void setidDisciplina (int idDisciplina){
        this.idDisciplina = idDisciplina;
    }
    
    public Integer getidAluno (){
        return this.idAluno;
    }
    
    public void setidAluno (int idAluno){
        this.idAluno = idAluno;
    }
}
