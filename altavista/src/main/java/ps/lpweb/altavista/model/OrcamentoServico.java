package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORCAMENTO_SERVICO")
@NamedQuery(name="OrcamentoServico.findAll", query="SELECT o FROM OrcamentoServico o")
public class OrcamentoServico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ORCAMENTO")
	private short idOrcamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ORCAMENTO")
	private Date dataOrcamento;

	@Lob
	@Column(name="OBS")
	private String obs;

	@Column(name="VALOR")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name="ID_SERVICO")
	private Servico servico;

	@ManyToOne
	@JoinColumn(name="ID_FORNECEDOR")
	private Fornecedor fornecedor;

	@OneToMany(mappedBy="orcamentoServico")
	private List<Servico> servicos;

	public OrcamentoServico() {
	}

	public short getIdOrcamento() {
		return this.idOrcamento;
	}

	public void setIdOrcamento(short idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public Date getDataOrcamento() {
		return this.dataOrcamento;
	}

	public void setDataOrcamento(Date dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Servico> getServicos() {
		return this.servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico addServico(Servico servico) {
		getServicos().add(servico);
		servico.setOrcamentoServico(this);

		return servico;
	}

	public Servico removeServico(Servico servico) {
		getServicos().remove(servico);
		servico.setOrcamentoServico(null);

		return servico;
	}
}