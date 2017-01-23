package buscas;

import interfaces.Estado;

import java.util.PriorityQueue;
import java.util.Queue;

//Algoritmo de busca em largura
public class BuscaLargura extends Busca {
	
    //busca sem mostrar status
    public BuscaLargura() {
    }
    
    //busca mostrando status
    public BuscaLargura(MostraStatusConsole ms) {
        super(ms);
    }

    
    public Nodo busca(Estado inicial) {
        status.inicia();
        initFechados();
       
        Queue<Nodo> abertos = new PriorityQueue<Nodo>();
        
        abertos.add(new Nodo(inicial, null));
        while (!parar && abertos.size() > 0) {
        	
        	Nodo n = abertos.remove();
        		
            status.explorando(n, abertos.size());
            if (n.estado.ehMeta()) {
                status.termina(true);
                return n;
            }
                        
            abertos.addAll( sucessores(n) );
            if(abertos.isEmpty()){
        		System.out.println("vazia");
        		status.explorando(n, abertos.size());
        		status.termina(true);
        		return n;
        	}
        }
        
        status.termina(false);
        return null;
    }

    public String toString() {
    	return "Busca em Largura";
    }
}
