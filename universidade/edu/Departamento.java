package universidade.edu;


@Entity
@Table(name="tbl_departamento")
public class Departamento {
	@Id
	@GeneratedValue
	@Column(name="departamento_id")
	private long id;
	
	@Column(length=254, nullable=false, unique=true)
	private String nome;
	
	@Column(length=11, nullable=false)
	private String telefone;
	
	@OneToMany
	private Collection<Curso> curso;
	
}
