package universidade.edu;

@Entity
public class DisciplinaCursada {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToMany
	private Aluno aluno;
	
	@OneToMany
	private Oferta disciplina;
	
	@Column(nullable=false)
	private double nota;
}
