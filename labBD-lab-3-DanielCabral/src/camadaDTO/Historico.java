package camadaDTO;

public class Historico {
	
	private int Codigo;
	private boolean Operacao;
	private float Valor;
	private String clienteID;
	private String contaNumero;
	
	public Historico (){}
	
	public Historico (int Codigo, boolean Operacao, float Valor, String clienteID, String contaNumero){
		this.Codigo = Codigo;
		this.Operacao = Operacao;
		this.Valor = Valor;
		this.clienteID = clienteID;
		this.contaNumero = contaNumero;
	}
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public boolean isOperacao() {
		return Operacao;
	}
	public void setOperacao(boolean operacao) {
		Operacao = operacao;
	}
	public float getValor() {
		return Valor;
	}
	public void setValor(float valor) {
		Valor = valor;
	}
	public String getClienteID() {
		return clienteID;
	}
	public void setClienteID(String clienteID) {
		this.clienteID = clienteID;
	}
	public String getContaNumero() {
		return contaNumero;
	}
	public void setContaNumero(String contaNumero) {
		this.contaNumero = contaNumero;
	}

}
