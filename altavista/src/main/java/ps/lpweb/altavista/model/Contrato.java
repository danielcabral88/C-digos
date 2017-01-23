package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="CONTRATOS")
@NamedQuery(name="Contrato.findAll", query="SELECT c FROM Contrato c")
public class Contrato implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CONTRATO")
	private short idContrato;

	@Lob
	@Column(name="ARQ_CONTRATO")
	private byte[] arqContrato;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ASSINATURA")
	private Date dataAssinatura;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_VENCIMENTO")
	private Date dataVencimento;

	@Lob
	@Column(name="DETALHES")
	private String detalhes;

	@Column(name="NOME_CONTRATO")
	private String nomeContrato;

	@Column(name="VALOR_MENSAL")
	private BigDecimal valorMensal;

	@ManyToOne
	@JoinColumn(name="ID_FORNECEDOR")
	private Fornecedor fornecedor;

	public Contrato() {
	}

	public short getIdContrato() {
		return this.idContrato;
	}

	public void setIdContrato(short idContrato) {
		this.idContrato = idContrato;
	}

	public byte[] getArqContrato() {
		return this.arqContrato;
	}

	public void setArqContrato(byte[] arqContrato) {
		this.arqContrato = arqContrato;
	}

	public Date getDataAssinatura() {
		return this.dataAssinatura;
	}

	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public Date getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDetalhes() {
		return this.detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getNomeContrato() {
		return this.nomeContrato;
	}

	public void setNomeContrato(String nomeContrato) {
		this.nomeContrato = nomeContrato;
	}

	public BigDecimal getValorMensal() {
		return this.valorMensal;
	}

	public void setValorMensal(BigDecimal valorMensal) {
		this.valorMensal = valorMensal;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}