package br.com.somtotal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.somtotal.model.Estilo;

@Component
public class EstiloDAO {


	private final Session session;
	
	public EstiloDAO(Session session){
		this.session = session;
	}
	 
	public List<Estilo> recuperar() {
		return session.createCriteria(Estilo.class).list();
	}

	public void salvar(Estilo estilo){
		Transaction tx = session.beginTransaction();
		this.session.save(estilo);
		
		tx.commit();
	}

	public void atualizar(Estilo estilo) {
		Transaction tx = session.beginTransaction();
		this.session.update(estilo);
		tx.commit();
	}
	
	public Estilo recuperar(int id) {
		return (Estilo) this.session.get(Estilo.class, id);
	}

	public void excluir(Estilo estilo) {
		Transaction tx = session.beginTransaction();
		this.session.delete(estilo);
		tx.commit();
	}

}
