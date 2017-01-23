package universidade.edu;

@Entity
public class Endereco {
	@Id
	@GeneratedValue
	@Column(name="endereco_id")
	private long id;
	
	@Column(length=254, nullable=false)
	private String logradouro;
	
	@Column(length=100, nulable=false)
	private String cidade;
	
	@Column(length=8, nullable=false)
	private String cep;
}
