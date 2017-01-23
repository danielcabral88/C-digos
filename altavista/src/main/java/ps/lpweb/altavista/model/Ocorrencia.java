package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="OCORRENCIAS")
@NamedQuery(name="Ocorrencia.findAll", query="SELECT o FROM Ocorrencia o")
public class Ocorrencia implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_OCORRENCIA")
	private short idOcorrencia;

	@Lob
	@Column(name="ACAO_TOMADA")
	private String acaoTomada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_OCORRENCIA")
	private Date dataOcorrencia;

	@Lob
	@Column(name="DESCRICAO")
	private String descricao;

	@Column(name="NOME_OCORRENCIA")
	private String nomeOcorrencia;

	@Lob
	@Column(name="OBS")
	private String obs;

	@ManyToOne
	@JoinColumn(name="ID_UNIDADE")
	private Unidade unidade;

	public Ocorrencia() {
	}

	public short getIdOcorrencia() {
		return this.idOcorrencia;
	}

	public void setIdOcorrencia(short idOcorrencia) {
		this.idOcorrencia = idOcorrencia;
	}

	public String getAcaoTomada() {
		return this.acaoTomada;
	}

	public void setAcaoTomada(String acaoTomada) {
		this.acaoTomada = acaoTomada;
	}

	public Date getDataOcorrencia() {
		return this.dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeOcorrencia() {
		return this.nomeOcorrencia;
	}

	public void setNomeOcorrencia(String nomeOcorrencia) {
		this.nomeOcorrencia = nomeOcorrencia;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
}