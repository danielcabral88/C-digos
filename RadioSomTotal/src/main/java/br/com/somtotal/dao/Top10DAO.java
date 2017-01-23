package br.com.somtotal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.somtotal.model.Top10;

@Component
public class Top10DAO {

	private final Session session;

	public Top10DAO(Session session) {
		this.session = session;
	}

	public List<Top10> recuperar() {
		return session.createCriteria(Top10.class).list();
	}

	public void salvar(Top10 top10) {
		Transaction tx = session.beginTransaction();
		this.session.save(top10);
		tx.commit();
	}

	public void atualizar(Top10 top10) {
		Transaction tx = session.beginTransaction();
		this.session.update(top10);
		tx.commit();
	}

	public Top10 recuperar(int id) {
		return (Top10) this.session.get(Top10.class, id);
	}

	public void excluir(Top10 top10) {
		Transaction tx = session.beginTransaction();
		this.session.delete(top10);
		tx.commit();
	}

}
