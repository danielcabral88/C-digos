package buscas;



import interfaces.Estado;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Algoritmo de busca com Heuristica A*
public class BuscaHeuristica extends Busca {
	
	int maxF = -1; // max F
    int maxAbertos = -1; // max abertos
	Nodo theBest;
	
    //busca sem mostrar status
    public BuscaHeuristica() {
    }
    
    //busca mostrando status
    public BuscaHeuristica(MostraStatusConsole ms) {
        super(ms);
    }

    
    public Nodo busca(Estado inicial) {
        status.inicia();
        initFechados();
       
        Queue<Nodo> abertos = new PriorityQueue<Nodo>(100, getNodoComparatorF()); // lista ordenada por f()
        Nodo nInicial = new Nodo(inicial, null);
        abertos.add(nInicial);
        theBest = nInicial; // o melhor nodo já gerado
        
		while (!parar && abertos.size() > 0) {
		            
            Nodo melhor = abertos.remove();
            status.explorando(melhor, abertos.size());
            if (melhor.estado.ehMeta()) {
                status.termina(true);
                return melhor;
            }
            
            if (maxF < 0 || melhor.f() < maxF) {
                abertos.addAll( sucessores(melhor) );
            }
            if (maxAbertos > 0 && abertos.size() > maxAbertos) {
                break;
            }
            
            if (melhor.f() < theBest.f()) {
                theBest = melhor;
            }
		            
        }
        
        status.termina(false);
        return null;
    }
    
    Comparator<Nodo> getNodoComparatorF() {
        return new Comparator<Nodo>() {
            public int compare(Nodo no1, Nodo no2) {
                try {
                    
                    int f1 = no1.f();
                    int f2 = no2.f();
                    if (f1 > f2) {
                        return 1;
                    } else if (f1 == f2) {
                        return 0; 
                    } else {
                        return -1;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        };
    }

    
    public String toString() {
    	return "Busca com Heurística";
    }
}

