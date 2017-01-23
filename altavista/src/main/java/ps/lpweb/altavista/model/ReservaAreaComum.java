package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name="RESERVA_AREA_COMUM")
@NamedQuery(name="ReservaAreaComum.findAll", query="SELECT r FROM ReservaAreaComum r")
public class ReservaAreaComum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_RESERVA")
	private short idReserva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_RESERVA")
	private Date dataReserva;

	@Column(name="FIM")
	private Time fim;

	@Column(name="INICIO")
	private Time inicio;

	@Column(name="NOME_EVENTO")
	private String nomeEvento;

	@Column(name="QTD_PESSOAS")
	private byte qtdPessoas;

	@ManyToOne
	@JoinColumn(name="ID_LOCAL")
	private AreaComum areaComum;

	@ManyToOne
	@JoinColumn(name="ID_UNIDADE")
	private Unidade unidade;

	public ReservaAreaComum() {
	}

	public short getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(short idReserva) {
		this.idReserva = idReserva;
	}

	public Date getDataReserva() {
		return this.dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Time getFim() {
		return this.fim;
	}

	public void setFim(Time fim) {
		this.fim = fim;
	}

	public Time getInicio() {
		return this.inicio;
	}

	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}

	public String getNomeEvento() {
		return this.nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public byte getQtdPessoas() {
		return this.qtdPessoas;
	}

	public void setQtdPessoas(byte qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public AreaComum getAreaComum() {
		return this.areaComum;
	}

	public void setAreaComum(AreaComum areaComum) {
		this.areaComum = areaComum;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
}