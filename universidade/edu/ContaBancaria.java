package universidade.edu;

@Entity
public class ContaBancaria {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String agencia;
	
	@Column(nullable=false)
	private String conta;
}
