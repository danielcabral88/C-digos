package universidade.edu;


@Entity
@Table(name="tbl_professor")
public class Professor{
		@Id
	@GeneratedValue
	@Column(name="professor_id")
	private long id;
	
	@Column(length=254, nullable=false)
	private String nome;
	
	@Column(length=11, nullable=false, unique=true)
	private String cpf;
	
	@Column(length=11)
	private String telefone;
	
	private double salario;
	
	@ManyToOne
	private Departamento departamento;
}
