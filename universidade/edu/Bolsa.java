package universidade.edu;

@Entity
public class Bolsa {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private double valor;
	
	@ManyToOne
	private Professor orientador;
}
