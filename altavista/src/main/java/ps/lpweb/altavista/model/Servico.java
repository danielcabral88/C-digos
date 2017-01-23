package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="SERVICOS")
@NamedQuery(name="Servico.findAll", query="SELECT s FROM Servico s")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_SERVICO")
	private short idServico;

	@Column(name="DADOS_COMPROVANTE")
	private String dadosComprovante;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_SERVICO")
	private Date dataServico;

	@Column(name="NOME_SERVICO")
	private String nomeServico;

	@Lob
	@Column(name="OBS")
	private String obs;

	@Column(name="RESPONSAVEL")
	private String responsavel;

	@OneToMany(mappedBy="servico")
	private List<OrcamentoServico> orcamentoServicos;

	@ManyToOne
	@JoinColumn(name="ID_ORCAMENTO")
	private OrcamentoServico orcamentoServico;

	@ManyToOne
	@JoinColumn(name="ID_LOCAL")
	private AreaComum areaComum;

	@ManyToOne
	@JoinColumn(name="ID_PRAZO")
	private Prazo prazo;

	@ManyToOne
	@JoinColumn(name="ID_GESTAO")
	private Gestao gestao;

	public Servico() {
	}

	public short getIdServico() {
		return this.idServico;
	}

	public void setIdServico(short idServico) {
		this.idServico = idServico;
	}

	public String getDadosComprovante() {
		return this.dadosComprovante;
	}

	public void setDadosComprovante(String dadosComprovante) {
		this.dadosComprovante = dadosComprovante;
	}

	public Date getDataServico() {
		return this.dataServico;
	}

	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}

	public String getNomeServico() {
		return this.nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public List<OrcamentoServico> getOrcamentoServicos() {
		return this.orcamentoServicos;
	}

	public void setOrcamentoServicos(List<OrcamentoServico> orcamentoServicos) {
		this.orcamentoServicos = orcamentoServicos;
	}

	public OrcamentoServico addOrcamentoServico(OrcamentoServico orcamentoServico) {
		getOrcamentoServicos().add(orcamentoServico);
		orcamentoServico.setServico(this);

		return orcamentoServico;
	}

	public OrcamentoServico removeOrcamentoServico(OrcamentoServico orcamentoServico) {
		getOrcamentoServicos().remove(orcamentoServico);
		orcamentoServico.setServico(null);

		return orcamentoServico;
	}

	public OrcamentoServico getOrcamentoServico() {
		return this.orcamentoServico;
	}

	public void setOrcamentoServico(OrcamentoServico orcamentoServico) {
		this.orcamentoServico = orcamentoServico;
	}

	public AreaComum getAreaComum() {
		return this.areaComum;
	}

	public void setAreaComum(AreaComum areaComum) {
		this.areaComum = areaComum;
	}

	public Prazo getPrazo() {
		return this.prazo;
	}

	public void setPrazo(Prazo prazo) {
		this.prazo = prazo;
	}

	public Gestao getGestao() {
		return this.gestao;
	}

	public void setGestao(Gestao gestao) {
		this.gestao = gestao;
	}
}