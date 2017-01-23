package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="GESTAO")
@NamedQuery(name="Gestao.findAll", query="SELECT g FROM Gestao g")
public class Gestao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_GESTAO")
	private byte idGestao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_FIM")
	private Date dataFim;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INICIO")
	private Date dataInicio;

	@Lob
	@Column(name="ESTATUTO")
	private byte[] estatuto;

	@Lob
	@Column(name="REALIZACOES")
	private String realizacoes;

	@ManyToOne
	@JoinColumn(name="ID_SINDICO")
	private Unidade unidade1;

	@ManyToOne
	@JoinColumn(name="ID_SUBSINDICO")
	private Unidade unidade2;

	@OneToMany(mappedBy="gestao")
	private List<Servico> servicos;

	public Gestao() {
	}

	public byte getIdGestao() {
		return this.idGestao;
	}

	public void setIdGestao(byte idGestao) {
		this.idGestao = idGestao;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public byte[] getEstatuto() {
		return this.estatuto;
	}

	public void setEstatuto(byte[] estatuto) {
		this.estatuto = estatuto;
	}

	public String getRealizacoes() {
		return this.realizacoes;
	}

	public void setRealizacoes(String realizacoes) {
		this.realizacoes = realizacoes;
	}

	public Unidade getUnidade1() {
		return this.unidade1;
	}

	public void setUnidade1(Unidade unidade1) {
		this.unidade1 = unidade1;
	}

	public Unidade getUnidade2() {
		return this.unidade2;
	}

	public void setUnidade2(Unidade unidade2) {
		this.unidade2 = unidade2;
	}

	public List<Servico> getServicos() {
		return this.servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico addServico(Servico servico) {
		getServicos().add(servico);
		servico.setGestao(this);

		return servico;
	}

	public Servico removeServico(Servico servico) {
		getServicos().remove(servico);
		servico.setGestao(null);

		return servico;
	}
}