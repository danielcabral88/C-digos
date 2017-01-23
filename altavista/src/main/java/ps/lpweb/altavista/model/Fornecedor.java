package ps.lpweb.altavista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="FORNECEDORES")
@NamedQuery(name="Fornecedor.findAll", query="SELECT f FROM Fornecedor f")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FORNECEDOR")
	private short idFornecedor;

	@Column(name="CNPJ")
	private String cnpj;

	@Column(name="CONTATO")
	private String contato;

	@Column(name="CPF")
	private String cpf;

	@Column(name="EMAIL")
	private String email;

	@Column(name="NOME_FORNECEDOR")
	private String nomeFornecedor;

	@Column(name="SERVICO_PRODUTO")
	private byte servicoProduto;

	@Column(name="TEL_CONTATO")
	private String telContato;

	@OneToMany(mappedBy="fornecedor")
	private List<Contrato> contratos;

	@OneToMany(mappedBy="fornecedor")
	private List<OrcamentoServico> orcamentoServicos;

	public Fornecedor() {
	}

	public short getIdFornecedor() {
		return this.idFornecedor;
	}

	public void setIdFornecedor(short idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public byte getServicoProduto() {
		return this.servicoProduto;
	}

	public void setServicoProduto(byte servicoProduto) {
		this.servicoProduto = servicoProduto;
	}

	public String getTelContato() {
		return this.telContato;
	}

	public void setTelContato(String telContato) {
		this.telContato = telContato;
	}

	public List<Contrato> getContratos() {
		return this.contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato addContrato(Contrato contrato) {
		getContratos().add(contrato);
		contrato.setFornecedor(this);

		return contrato;
	}

	public Contrato removeContrato(Contrato contrato) {
		getContratos().remove(contrato);
		contrato.setFornecedor(null);

		return contrato;
	}

	public List<OrcamentoServico> getOrcamentoServicos() {
		return this.orcamentoServicos;
	}

	public void setOrcamentoServicos(List<OrcamentoServico> orcamentoServicos) {
		this.orcamentoServicos = orcamentoServicos;
	}

	public OrcamentoServico addOrcamentoServico(OrcamentoServico orcamentoServico) {
		getOrcamentoServicos().add(orcamentoServico);
		orcamentoServico.setFornecedor(this);

		return orcamentoServico;
	}

	public OrcamentoServico removeOrcamentoServico(OrcamentoServico orcamentoServico) {
		getOrcamentoServicos().remove(orcamentoServico);
		orcamentoServico.setFornecedor(null);

		return orcamentoServico;
	}

}