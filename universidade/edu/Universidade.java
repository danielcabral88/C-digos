package universidade.edu;

@Entity
@Table(name="tbl_universidade")
public class Universidade {
	
	@Id
	@GeneratedValue
	@Column(name="universidade_id")
	private long id;
	
	@Column(length=100, nullable=false, unique=true)
	private String nome;
	
	@Column(length=254)
	private String endereco;
	
	@Column(length=11)
	private String telefone;
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory =
				Persistence . createEntityManagerFactory ( " Universidade " ) ;
				factory . close () ;
	}

}
