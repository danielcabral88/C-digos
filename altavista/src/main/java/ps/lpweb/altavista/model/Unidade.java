package ps.lpweb.altavista.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="UNIDADES")
@NamedQuery(name="Unidade.findAll", query="SELECT u FROM Unidade u")
public class Unidade implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_UNIDADE")
	private Integer idUnidade;

	@Column(name="ALUGADA")
	private Boolean alugada;

	@Column(name="AREA_TOTAL")
	private double areaTotal;

	@Column(name="CPF_RESPONSAVEL")
	private Long cpfResponsavel;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_AQUISICAO")
	private Date dataAquisicao;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FRACAO_IDEAL")
	private double fracaoIdeal;

	@Column(name="NOME_RESPONSAVEL")
	private String nomeResponsavel;

	@Column(name="NR_GARAGEM")
	private Integer nrGaragem;

	@Column(name="NR_UNIDADE")
	private Integer nrUnidade;

	@Column(name="PLACA_VEICULO1")
	private String placaVeiculo1;

	@Column(name="PLACA_VEICULO2")
	private String placaVeiculo2;

	@Column(name="TELEFONE1")
	private String telefone1;

	@Column(name="TELEFONE2")
	private String telefone2;

	@Column(name="TORRE")
	private String torre;

	@OneToMany(mappedBy="unidade1")
	private List<Gestao> gestaos1;

	@OneToMany(mappedBy="unidade2")
	private List<Gestao> gestaos2;

	@OneToMany(mappedBy="unidade")
	private List<Ocorrencia> ocorrencias;

	@OneToMany(mappedBy="unidade")
	private List<PresencaReuniao> presencaReuniao;

	@OneToMany(mappedBy="unidade")
	private List<ReservaAreaComum> reservaAreaComum;

	public Unidade() {
	}

	public Integer getIdUnidade() {
		return this.idUnidade;
	}

	public void setIdUnidade(Integer idUnidade) {
		this.idUnidade = idUnidade;
	}
	
	@NotNull(message = "Estado não pode ser nulo")
	public Boolean getAlugada() {
		return this.alugada;
	}

	public void setAlugada(Boolean alugada) {
		this.alugada = alugada;
	}
	
	@NotNull(message = "Área Total não pode ser nula!")
	public double getAreaTotal() {
		return this.areaTotal;
	}

	public void setAreaTotal(double areaTotal) {
		this.areaTotal = areaTotal;
	}
	
	@NotNull(message = "CPF não pode ser nulo!")
	public Long getCpfResponsavel() {
		return this.cpfResponsavel;
	}

	public void setCpfResponsavel(Long cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}
	
	@NotNull(message = "Data não pode ser nula!")
	public Date getDataAquisicao() {
		return this.dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	
	@NotNull(message = "Email não pode ser nulo!")
	@Email
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotNull(message = "Fração não pode ser nula!")
	@DecimalMin("0.1")
	@DecimalMax("1")
	public double getFracaoIdeal() {
		return this.fracaoIdeal;
	}

	public void setFracaoIdeal(double fracaoIdeal) {
		this.fracaoIdeal = fracaoIdeal;
	}
	
	@NotNull(message = "Nome não pode ser nulo!")
	public String getNomeResponsavel() {
		return this.nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	
	@NotNull(message = "Garagem não pode ser nula!")
	public Integer getNrGaragem() {
		return this.nrGaragem;
	}

	public void setNrGaragem(Integer nrGaragem) {
		this.nrGaragem = nrGaragem;
	}
	
	@NotNull(message = "No. Unidade não pode ser nula!")
	public Integer getNrUnidade() {
		return this.nrUnidade;
	}

	public void setNrUnidade(Integer nrUnidade) {
		this.nrUnidade = nrUnidade;
	}
	
	@NotNull(message = "Placa #1 não pode ser nula!")
	public String getPlacaVeiculo1() {
		return this.placaVeiculo1;
	}

	public void setPlacaVeiculo1(String placaVeiculo1) {
		this.placaVeiculo1 = placaVeiculo1;
	}
	
	@NotNull(message = "Placa #2 não pode ser nula!")
	public String getPlacaVeiculo2() {
		return this.placaVeiculo2;
	}

	public void setPlacaVeiculo2(String placaVeiculo2) {
		this.placaVeiculo2 = placaVeiculo2;
	}
	
	@NotNull(message = "Telefone1 não pode ser nulo!")
	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	
	@NotNull(message = "Telefone2 não pode ser nulo!")
	public String getTelefone2() {
		return this.telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
	@NotNull(message = "Torre não pode ser nula!")
	public String getTorre() {
		return this.torre;
	}

	public void setTorre(String torre) {
		this.torre = torre;
	}

	public List<Gestao> getGestaos1() {
		return this.gestaos1;
	}

	public void setGestaos1(List<Gestao> gestaos1) {
		this.gestaos1 = gestaos1;
	}

	public Gestao addGestaos1(Gestao gestaos1) {
		getGestaos1().add(gestaos1);
		gestaos1.setUnidade1(this);

		return gestaos1;
	}

	public Gestao removeGestaos1(Gestao gestaos1) {
		getGestaos1().remove(gestaos1);
		gestaos1.setUnidade1(null);

		return gestaos1;
	}

	public List<Gestao> getGestaos2() {
		return this.gestaos2;
	}

	public void setGestaos2(List<Gestao> gestaos2) {
		this.gestaos2 = gestaos2;
	}

	public Gestao addGestaos2(Gestao gestaos2) {
		getGestaos2().add(gestaos2);
		gestaos2.setUnidade2(this);

		return gestaos2;
	}

	public Gestao removeGestaos2(Gestao gestaos2) {
		getGestaos2().remove(gestaos2);
		gestaos2.setUnidade2(null);

		return gestaos2;
	}

	public List<Ocorrencia> getOcorrencias() {
		return this.ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public Ocorrencia addOcorrencia(Ocorrencia ocorrencia) {
		getOcorrencias().add(ocorrencia);
		ocorrencia.setUnidade(this);

		return ocorrencia;
	}

	public Ocorrencia removeOcorrencia(Ocorrencia ocorrencia) {
		getOcorrencias().remove(ocorrencia);
		ocorrencia.setUnidade(null);

		return ocorrencia;
	}

	public List<PresencaReuniao> getPresencaReuniao() {
		return this.presencaReuniao;
	}

	public void setPresencaReuniaos(List<PresencaReuniao> presencaReuniao) {
		this.presencaReuniao = presencaReuniao;
	}

	public PresencaReuniao addPresencaReuniao(PresencaReuniao presencaReuniao) {
		getPresencaReuniao().add(presencaReuniao);
		presencaReuniao.setUnidade(this);

		return presencaReuniao;
	}

	public PresencaReuniao removePresencaReuniao(PresencaReuniao presencaReuniao) {
		getPresencaReuniao().remove(presencaReuniao);
		presencaReuniao.setUnidade(null);

		return presencaReuniao;
	}

	public List<ReservaAreaComum> getReservaAreaComum() {
		return this.reservaAreaComum;
	}

	public void setReservaAreaComum(List<ReservaAreaComum> reservaAreaComum) {
		this.reservaAreaComum = reservaAreaComum;
	}

	public ReservaAreaComum addReservaAreaComum(ReservaAreaComum reservaAreaComum) {
		getReservaAreaComum().add(reservaAreaComum);
		reservaAreaComum.setUnidade(this);

		return reservaAreaComum;
	}

	public ReservaAreaComum removeReservaAreaComum(ReservaAreaComum reservaAreaComum) {
		getReservaAreaComum().remove(reservaAreaComum);
		reservaAreaComum.setUnidade(null);

		return reservaAreaComum;
	}
}