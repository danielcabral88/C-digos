package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PRAZOS")
@NamedQuery(name="Prazo.findAll", query="SELECT p FROM Prazo p")
public class Prazo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PRAZO")
	private byte idPrazo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULT_OCORRENCIA")
	private Date dataUltOcorrencia;

	@Column(name="NOME_TAREFA")
	private String nomeTarefa;

	@Lob
	@Column(name="OBS")
	private String obs;

	@Column(name="PERIODICIDADE")
	private String periodicidade;

	@Lob
	@Column(name="PROCEDIMENTO")
	private String procedimento;

	@OneToMany(mappedBy="prazo")
	private List<Servico> servicos;

	public Prazo() {
	}

	public byte getIdPrazo() {
		return this.idPrazo;
	}

	public void setIdPrazo(byte idPrazo) {
		this.idPrazo = idPrazo;
	}

	public Date getDataUltOcorrencia() {
		return this.dataUltOcorrencia;
	}

	public void setDataUltOcorrencia(Date dataUltOcorrencia) {
		this.dataUltOcorrencia = dataUltOcorrencia;
	}

	public String getNomeTarefa() {
		return this.nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getPeriodicidade() {
		return this.periodicidade;
	}

	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}

	public String getProcedimento() {
		return this.procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}

	public List<Servico> getServicos() {
		return this.servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico addServico(Servico servico) {
		getServicos().add(servico);
		servico.setPrazo(this);

		return servico;
	}

	public Servico removeServico(Servico servico) {
		getServicos().remove(servico);
		servico.setPrazo(null);

		return servico;
	}
}