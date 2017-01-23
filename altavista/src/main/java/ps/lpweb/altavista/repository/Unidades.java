package ps.lpweb.altavista.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import ps.lpweb.altavista.model.Unidade;
import ps.lpweb.altavista.service.GenericService;

public class Unidades extends GenericService<Unidade> implements Serializable {

	private static final long serialVersionUID = 9020632563245914614L;
	
	@Inject
	private EntityManager manager;
	
	public Unidades() {
		
		super(Unidade.class);
	}
	
	protected EntityManager getEntityManager() {
	
		return manager;
	}
}