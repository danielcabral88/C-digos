package camadaDTO;

public class Agencia {
	
	private int Numero;
	private String Nome;
	private String Endereco;
	private char Telefone;
	
	public Agencia (){}
	
	public Agencia (int Numero, String Nome, String Endereco, char Telefone){
		this.Numero = Numero;
		this.Nome = Nome;
		this.Endereco = Endereco;
		this.Telefone = Telefone;
	}
	
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
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
	public char getTelefone() {
		return Telefone;
	}
	public void setTelefone(char telefone) {
		Telefone = telefone;
	}

}
