package universidade.edu;

@Entity
@Table(name="tbl_disciplina")
public class Disciplina {
	@Id
	@GeneratedValue
	@Column(name="disciplina_id")
	private long id;
	
	@Column(length=100, nullable=false, unique=true)
	private String nome;
	
	@Column(length=254, nullable=false)
	private String descricao;
	
	@Column(nullable=false)
	private int creditos;
	
	@ManyToOne
	private Departamento departamento;
}
