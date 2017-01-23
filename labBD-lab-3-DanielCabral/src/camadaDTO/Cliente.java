package camadaDTO;

public class Cliente {
	
	private String ID;
	private String Nome;
	private String Endereco;
	private String Telefone;
	
	public Cliente (){}
	
	public Cliente (String ID, String Nome, String Endereco, String Telefone){
		this.ID = ID;
		this.Nome = Nome;
		this.Endereco = Endereco;
		this.Telefone = Telefone;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
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
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	
}
