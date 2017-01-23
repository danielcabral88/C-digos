package br.com.somtotal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.somtotal.model.Regiao;

@Component
public class RegiaoDAO {


	private final Session session;
	
	public RegiaoDAO(Session session){
		this.session = session;
	}
	 
	public List<Regiao> recuperar() {
		return session.createCriteria(Regiao.class).list();
	}

	public void salvar(Regiao regiao){
		Transaction tx = session.beginTransaction();
		this.session.save(regiao);
		
		tx.commit();
	}

	public void atualizar(Regiao regiao) {
		Transaction tx = session.beginTransaction();
		this.session.update(regiao);
		tx.commit();
	}
	
	public Regiao recuperar(int id) {
		return (Regiao) this.session.get(Regiao.class, id);
	}

	public void excluir(Regiao regiao) {
		Transaction tx = session.beginTransaction();
		this.session.delete(regiao);
		tx.commit();
	}

}
