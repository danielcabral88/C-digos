package br.com.somtotal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "regiao")
public class Regiao {

	@Id @GeneratedValue
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "regiao", targetEntity = Estacao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Estacao> estacoes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estacao> getEstacoes() {
		return estacoes;
	}

	public void setEstacoes(List<Estacao> estacoes) {
		this.estacoes = estacoes;
	}
	
	
}
