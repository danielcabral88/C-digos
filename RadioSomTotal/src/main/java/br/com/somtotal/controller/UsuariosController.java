package br.com.somtotal.controller;

import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.somtotal.dao.UsuarioDAO;
import br.com.somtotal.model.Usuario;

@Resource
public class UsuariosController {

	private final UsuarioDAO dao;
	private final Result result;

	
	public UsuariosController(UsuarioDAO dao, Result result){
		this.dao = dao;
		this.result = result;
	}
	
	@Post("/usuarios")
	public void salvar(Usuario usuario){
		dao.salvar(usuario);
		result.redirectTo(this).recuperar();
	}
	
	@Get("/usuarios")
	public List<Usuario> recuperar(){
		return dao.recuperar();
	}
	
	@Get("/usuarios/novo")
	public void formulario() {
		//result.include("perfilList", perfildao.recuperar());
	}
	
	@Get("/usuarios/{id}")
	public Usuario editar(int id) {
		//result.include("perfilList", perfildao.recuperar());
		return dao.recuperar(id);
	}
	
	@Put("/usuarios/{usuario.id}")
	public void atualizar(final Usuario usuario) {
		// validator.validate(produto);
		//validar(produto);
		//validator.onErrorUsePageOf(this).edita(produto.getId());
		//usuario.setCriadoEm(new Date());
		dao.atualizar(usuario);
		result.redirectTo(this).recuperar();
	}
	
	@Delete("/usuarios/{id}")
	public void excluir(int id) {
		Usuario usuario = dao.recuperar(id);
		dao.excluir(usuario);
		result.redirectTo(this).recuperar();
	}
}
