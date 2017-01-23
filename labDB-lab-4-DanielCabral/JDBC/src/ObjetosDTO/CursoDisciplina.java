/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosDTO;

/**
 *
 * @author Usuário
 */
public class CursoDisciplina {
    
    private Integer idCurso;
    private Integer idDisciplina;
    
    public CursoDisciplina(){}
    
    public CursoDisciplina (int idCurso, int idDisciplina){
        this.idCurso = idCurso;
        this.idDisciplina = idDisciplina;
    }
    
    public Integer getidCurso (){
        return this.idCurso;
    }
    
    public void setidCurso (int idCurso){
        this.idCurso = idCurso;
    }
    
    public Integer getidDisciplina (){
        return this.idDisciplina;
    }
    
    public void setidDisciplina (int idDisciplina){
        this.idDisciplina = idDisciplina;
    }
}
