package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the REUNIOES database table.
 * 
 */
@Entity
@Table(name="REUNIOES")
@NamedQuery(name="Reuniao.findAll", query="SELECT r FROM Reuniao r")
public class Reuniao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_REUNIAO")
	private byte idReuniao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_REUNIAO")
	private Date dataReuniao;

	@Column(name="LOCAL")
	private String local;

	@Lob
	@Column(name="PAUTA")
	private String pauta;

	@Lob
	@Column(name="RELATORIO")
	private String relatorio;

	@Column(name="URGENTE")
	private byte urgente;

	//bi-directional many-to-one association to PresencaReuniao
	@OneToMany(mappedBy="reuniao")
	private List<PresencaReuniao> presencaReuniao;

	public Reuniao() {
	}

	public byte getIdReuniao() {
		return this.idReuniao;
	}

	public void setIdReuniao(byte idReuniao) {
		this.idReuniao = idReuniao;
	}

	public Date getDataReuniao() {
		return this.dataReuniao;
	}

	public void setDataReuniao(Date dataReuniao) {
		this.dataReuniao = dataReuniao;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPauta() {
		return this.pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public String getRelatorio() {
		return this.relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public byte getUrgente() {
		return this.urgente;
	}

	public void setUrgente(byte urgente) {
		this.urgente = urgente;
	}

	public List<PresencaReuniao> getPresencaReuniao() {
		return this.presencaReuniao;
	}

	public void setPresencaReuniaos(List<PresencaReuniao> presencaReuniao) {
		this.presencaReuniao = presencaReuniao;
	}

	public PresencaReuniao addPresencaReuniao(PresencaReuniao presencaReuniao) {
		getPresencaReuniao().add(presencaReuniao);
		presencaReuniao.setReuniao(this);

		return presencaReuniao;
	}

	public PresencaReuniao removePresencaReuniao(PresencaReuniao presencaReuniao) {
		getPresencaReuniao().remove(presencaReuniao);
		presencaReuniao.setReuniao(null);

		return presencaReuniao;
	}

}