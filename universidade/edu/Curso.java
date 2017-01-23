package universidade.edu;

import java.util.ArrayList;

@Entity
@Table(name="tbl_curso")
public class Curso{
	@Id
	@GeneratedValue
	@Column(name="curso_id")
	private long id;
	
	private String nome;

	@Enumerated(EnumType.STRING)
	private TipoCurso tipo;
	
	private Professor coordenador;
	
	private Professor vice_coordenador;
}
