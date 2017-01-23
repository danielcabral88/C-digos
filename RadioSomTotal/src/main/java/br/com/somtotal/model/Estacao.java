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

@Entity(name = "estacao")
public class Estacao {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "nome")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "regiao_id")
	private Regiao regiao;

	@OneToMany(mappedBy = "estacao", targetEntity = Top10.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Top10> top10;

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

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public List<Top10> getTop10() {
		return top10;
	}

	public void setTops10(List<Top10> top10) {
		this.top10 = top10;
	}

}
