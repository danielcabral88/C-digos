package universidade.edu;

@Entity
public class Exame {
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Professor professor;
	
	@Column(length=1, nullable=false)
	private String nota;
}
