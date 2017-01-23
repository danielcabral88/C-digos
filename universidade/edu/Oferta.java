package universidade.edu;

@Entity
public class Oferta {
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Professor professor;
	
	@Column(length=50, nullable=false)
	private String semestre;
	
	@Column(nullable=false)
	private int ano;
	
	@ManyToOne
	private Disciplina disciplina;
}
