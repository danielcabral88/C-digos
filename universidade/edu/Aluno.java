package universidade.edu;

import java.util.Calendar;

@Entity
public class Aluno {
	@Id
	@Column(length=12, nullable=false, unique=true)
	private String matricula;
	
	@Column(length=11, nullable=false, unique=true)
	private String cpf;
	
	@Column(length=254, nullable=false)
	private String nome;
	
	private Endereco endereco;
	
	@ElementCollection
	@CollectionTable(
			name="telefones_dos_alunos",
			joinColumns=@JoinColumn(name="aluno_matricula"))
	@Column(name="telefone")
	private Collection<String> telefones;
	
	@Temporal(TemporalType.DATE)
	private Calendar data_nascto;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@ManyToOne
	private Curso curso;
	
	@OneToOne
	private Bolsa bolsa;
	
	@OneToOne
	private ContaBancaria conta;
	
	@OneToOne
	private Exame exame;
}
