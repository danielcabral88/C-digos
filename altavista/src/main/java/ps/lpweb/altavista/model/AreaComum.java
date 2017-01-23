package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the AREA_COMUM database table.
 * 
 */
@Entity
@Table(name="AREA_COMUM")
@NamedQuery(name="AreaComum.findAll", query="SELECT a FROM AreaComum a")
public class AreaComum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_LOCAL")
	private byte idLocal;

	@Column(name="HORA_FIM")
	private Time horaFim;

	@Column(name="HORA_INICIO")
	private Time horaInicio;

	@Column(name="NOME")
	private String nome;

	@Lob
	@Column(name="REGRAS")
	private String regras;

	//bi-directional many-to-one association to ReservaAreaComum
	@OneToMany(mappedBy="areaComum")
	private List<ReservaAreaComum> reservaAreaComum;

	public AreaComum() {
	}

	public byte getIdLocal() {
		return this.idLocal;
	}

	public void setIdLocal(byte idLocal) {
		this.idLocal = idLocal;
	}

	public Time getHoraFim() {
		return this.horaFim;
	}

	public void setHoraFim(Time horaFim) {
		this.horaFim = horaFim;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegras() {
		return this.regras;
	}

	public void setRegras(String regras) {
		this.regras = regras;
	}

	public List<ReservaAreaComum> getReservaAreaComum() {
		return this.reservaAreaComum;
	}

	public void setReservaAreaComum(List<ReservaAreaComum> reservaAreaComum) {
		this.reservaAreaComum = reservaAreaComum;
	}

	public ReservaAreaComum addReservaAreaComum(ReservaAreaComum reservaAreaComum) {
		getReservaAreaComum().add(reservaAreaComum);
		reservaAreaComum.setAreaComum(this);

		return reservaAreaComum;
	}

	public ReservaAreaComum removeReservaAreaComum(ReservaAreaComum reservaAreaComum) {
		getReservaAreaComum().remove(reservaAreaComum);
		reservaAreaComum.setAreaComum(null);

		return reservaAreaComum;
	}

}