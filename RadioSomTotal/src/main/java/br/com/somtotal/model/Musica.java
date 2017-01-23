package br.com.somtotal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "musica")
public class Musica {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "artista")
	private String artista;

	@ManyToOne
	@JoinColumn(name = "estilo_id")
	private Estilo estilo;

	@ManyToMany(mappedBy = "musicas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Top10> top10 = new ArrayList<Top10>();

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

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public List<Top10> getTop10() {
		return top10;
	}

	public void setTop10(List<Top10> top10) {
		this.top10 = top10;
	}

}
