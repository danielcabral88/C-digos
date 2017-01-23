package cardeneta.ramon.cadernetaturma;

/**
 * Created by ramon on 29/05/2015.
 */
public class Escola {

    private int idEscola;
    private String nome;

    public Escola(){

    }

    public Escola(int id, String nome){

        this.idEscola = id;
        this.nome = nome;
    }

    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}