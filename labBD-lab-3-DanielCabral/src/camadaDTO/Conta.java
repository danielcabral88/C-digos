package camadaDTO;

import java.util.*;

public class Conta {
	
	private String Numero;
	private String dataAbertura;
	private float Saldo;
	private int agenciaNumero;
	
	public Conta (){}
	
	public Conta (String Numero, String dataAbertura, float Saldo, int agenciaNumero){
		this.Numero = Numero;
		this.dataAbertura = dataAbertura;
		this.Saldo = Saldo;
		this.agenciaNumero = agenciaNumero;
	}
	
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public float getSaldo() {
		return Saldo;
	}
	public void setSaldo(float saldo) {
		Saldo = saldo;
	}
	public int getAgenciaNumero() {
		return agenciaNumero;
	}
	public void setAgenciaNumero(int agenciaNumero) {
		this.agenciaNumero = agenciaNumero;
	}

}
