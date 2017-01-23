package ps.lpweb.altavista.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import ps.lpweb.altavista.model.Unidade;
import ps.lpweb.altavista.repository.Unidades;

public class UnidadeService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Unidades unidades;
	
	@Transactional
	public void salvar(Unidade unidade) {
		
		unidades.salvar(unidade);
	}
	
	public Unidade alterar(Unidade unidade) {
		
		return unidades.alterar(unidade);
	}
	
	public List<Unidade> listar() {
		
		return unidades.getAll();
	}
	
	public void excluir(Unidade unidade) {
		
		unidades.delete(unidade);
	}
}