package ps.lpweb.altavista.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TestBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<String> items;
	private String item;

	@PostConstruct
	private void init() {
		
		items = new ArrayList<String>();
		items.add("Item 1");
		items.add("Item 2");
		items.add("Item 3");
		items.add("Item 4");
		
		System.out.println("Hello Time");
	}
	
	public void addItem() {
	    if (item != null && !item.isEmpty()) {
	      items.add(item);
	      item = null;
	    }
	  }
	
	public List<String> getItems() {
		return items;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getItem() {
		return item;
	}
}
