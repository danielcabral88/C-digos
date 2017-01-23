package ps.lpweb.altavista.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ps.lpweb.altavista.model.Unidade;
import ps.lpweb.altavista.service.UnidadeService;

@Named
@RequestScoped
public class UnidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private UnidadeService service;
	
	private Unidade unidade;
	
	@PostConstruct
	private void init() {
		
		this.unidade = new Unidade();
		System.out.println("Hurry! It Works!");
	}
	
	public void salvar() {
		
		service.salvar(this.unidade);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Nova unidade salva!"));
		init();
	}
	
	public void alterar() {
		
		service.alterar(this.unidade);
	}
	
	public void excluir() {
		
		service.excluir(this.unidade);
	}
	
	public List<Unidade> listar() {
		
		return service.listar();
	}
	
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	public Unidade getUnidade() {	
		return this.unidade;
	}
	
	public boolean isEditando() {
		return this.unidade.getIdUnidade() != null;
	}
}