package camadaDTO;

public class Funcionario {
	
	private char ID;
	private String Nome;
	private String Endereco;
	private float Salario;
	private int agenciaNumero;
	
	public Funcionario(){};
	
	public Funcionario (char ID, String Nome, String Endereco, float Salario, int agenciaNumero){
		this.ID = ID;
		this.Nome = Nome;
		this.Endereco = Endereco;
		this.Salario = Salario;
		this.agenciaNumero = agenciaNumero;
	}
	
	public char getID() {
		return ID;
	}
	public void setID(char iD) {
		ID = iD;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public float getSalario() {
		return Salario;
	}
	public void setSalario(float salario) {
		Salario = salario;
	}
	public int getAgenciaNumero() {
		return agenciaNumero;
	}
	public void setAgenciaNumero(int agenciaNumero) {
		this.agenciaNumero = agenciaNumero;
	}
	
	

}
