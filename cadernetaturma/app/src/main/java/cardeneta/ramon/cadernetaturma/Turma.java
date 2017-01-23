package cardeneta.ramon.cadernetaturma;

/**
 * Created by ramon on 29/05/2015.
 */
public class Turma {

    private int id;
    private String descricao;
    private String turno;
    private int ano;
    private int escola;


    public Turma(){

    }
    public Turma(int id, String descricao, String turno, int ano, int escola) {
        this.id = id;
        this.descricao = descricao;
        this.turno = turno;
        this.ano = ano;
        this.escola = escola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEscola() {
        return escola;
    }

    public void setEscola(int escola) {
        this.escola = escola;
    }
}

