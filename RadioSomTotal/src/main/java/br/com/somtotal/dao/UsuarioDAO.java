package br.com.somtotal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.somtotal.model.Usuario;

@Component
public class UsuarioDAO {


	private final Session session;
	
	public UsuarioDAO(Session session){
		this.session = session;
	}
	 
	public List<Usuario> recuperar() {
		return session.createCriteria(Usuario.class).list();
	}

	public void salvar(Usuario usuario){
		Transaction tx = session.beginTransaction();
		this.session.save(usuario);
		
		tx.commit();
	}

	public void atualizar(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		this.session.update(usuario);
		tx.commit();
	}
	
	public Usuario recuperar(int id) {
		return (Usuario) this.session.get(Usuario.class, id);
	}

	public void excluir(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		this.session.delete(usuario);
		tx.commit();
	}

}
