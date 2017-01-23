package br.com.somtotal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "top10")
public class Top10 {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "dia", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date dia;

	@ManyToOne
	@JoinColumn(name = "estacao_id")
	private Estacao estacao;

	@ManyToMany(cascade ={ CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name = "top10_musica", joinColumns = { @JoinColumn(name = "top10_id") }, inverseJoinColumns = { @JoinColumn(name = "musica_id") })
	private List<Musica> musicas = new ArrayList<Musica>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
}
