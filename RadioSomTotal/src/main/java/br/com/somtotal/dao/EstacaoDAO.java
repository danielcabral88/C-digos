package br.com.somtotal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.somtotal.model.Estacao;

@Component
public class EstacaoDAO {


	private final Session session;
	
	public EstacaoDAO(Session session){
		this.session = session;
	}
	 
	public List<Estacao> recuperar() {
		return session.createCriteria(Estacao.class).list();
	}

	public void salvar(Estacao estacao){
		Transaction tx = session.beginTransaction();
		this.session.save(estacao);
		
		tx.commit();
	}

	public void atualizar(Estacao estacao) {
		Transaction tx = session.beginTransaction();
		this.session.update(estacao);
		tx.commit();
	}
	
	public Estacao recuperar(int id) {
		return (Estacao) this.session.get(Estacao.class, id);
	}

	public void excluir(Estacao estacao) {
		Transaction tx = session.beginTransaction();
		this.session.delete(estacao);
		tx.commit();
	}

}
