package ps.lpweb.altavista.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="PRESENCA_REUNIAO")
@NamedQuery(name="PresencaReuniao.findAll", query="SELECT p FROM PresencaReuniao p")
@IdClass(PresencaReuniao.class)
public class PresencaReuniao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="NOME_PARTICIPANTE")
	private String nomeParticipante;

	@Lob
	@Column(name="OBS")
	private String obs;

	@Column(name="PROCURACAO")
	private byte procuracao;

	@ManyToOne
	@JoinColumn(name="ID_UNIDADE")
	@Id
	private Unidade unidade;

	@ManyToOne
	@JoinColumn(name="ID_REUNIAO")
	@Id
	private Reuniao reuniao;

	public PresencaReuniao() {
	}

	public String getNomeParticipante() {
		return this.nomeParticipante;
	}

	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public byte getProcuracao() {
		return this.procuracao;
	}

	public void setProcuracao(byte procuracao) {
		this.procuracao = procuracao;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Reuniao getReuniao() {
		return this.reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}
	
	public int hashCode() {
		return super.hashCode();
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}