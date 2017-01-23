package ps.lpweb.altavista.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ps.lpweb.altavista.model.Unidade;
import ps.lpweb.altavista.repository.Unidades;

@FacesConverter(forClass = Unidade.class)
public class UnidadeConverter implements Converter {
	
	private Unidades unidades;
	
	public UnidadeConverter() {
		
		//unidades = CDIServiceLocator.getBean(Unidades.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Unidade u = null;
		
		if (value != null) {
			
			Integer id = new Integer(value);
			
			u = unidades.getById(id);
		}
		
		return u;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return null;
	}
}