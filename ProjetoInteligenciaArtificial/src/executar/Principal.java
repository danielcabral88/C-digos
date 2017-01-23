package executar;

import java.util.Scanner;

import interfaces.Estado;
import problemas.Estado8Puzzle;
import problemas.EstadoMissionariosCanibais;
import problemas.EstadoRainhas;
import buscas.BuscaHeuristica;
import buscas.BuscaHillClimbing;
import buscas.BuscaLargura;
import buscas.MostraStatusConsole;
import buscas.Nodo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		Nodo n = null;
		
		System.out.println("-------------------------------");
		System.out.println("Escolha problema:");
		System.out.println("1 - Missionarios e Canibais");
		System.out.println("2 - 8Puzzle");
		System.out.println("3 - NQueens");
		System.out.println("0 - Sair");
		System.out.println("-------------------------------");
	    int opcao = scan.nextInt();
	    System.out.println("-------------------------------");
	    switch (opcao) {
		case 1:
				EstadoMissionariosCanibais inicial = new EstadoMissionariosCanibais(3,3,'d',"");
		        //Resolucao finau = new Resolucao(0,0,'e',"");
		        
		        System.out.println("Busca em Largura");
		        n = new BuscaLargura(new MostraStatusConsole()).busca(inicial);
		        if (n != null) 
		        	System.out.println("Passos para travessia:\n"+n.montaCaminho().replace(';','-')+"\n");
		        
			break;
		case 2:
				//Estado8Puzzle e8 = Estado8Puzzle.getEstadoDificil();
				//Estado8Puzzle e8 = Estado8Puzzle.getEstadoFacil();
		        Estado8Puzzle e8 = Estado8Puzzle.getEstadoMuitoDificil();
		        //System.out.println("estado inicial (h="+((Heuristica)e8).h()+") ="+e8);
		        //System.out.println("estado meta (h="+((Heuristica)estadoMeta).h()+") ="+estadoMeta);
	        
		        Nodo s = new BuscaHeuristica(new MostraStatusConsole()).busca(e8);
		        //Nodo s = new BuscaLargura(new MostraStatusConsole()).busca(e8);
		        if (s != null) {
		            System.out.println("solucao ("+s.getProfundidade()+")= "+s.montaCaminho());
		        }
		        
			break;
		case 3:
				// Tamanho do tabuleiro
		        EstadoRainhas.setTamanho(8);
		        Estado inicialQueens = new EstadoRainhas(); // um estado aleatório
		        System.out.println("Estado inicial:"+inicialQueens+"\n");
		        
		        // os quatro métodos seguintes não conseguem
		        // resolver o problema das rainhas
		        //n = Busca.buscaLargura(inicial, null);
		        //n = Busca.buscaProfRec(inicial, null, 10);
		        //n = Busca.buscaProfIterativo(inicial, null);
		        //n = new BuscaProfundidade(new MostraStatusConsole()).busca(inicial);
		                /*
		                if (n == null) {
		                System.out.println("sem solução!");
		                } else {
		                System.out.println("solução:\n" + n.montaCaminho() + "\n\n");
		                }
		                */
		        
		        // a subida da montanha consegue resolver
		        n = new BuscaHillClimbing(new MostraStatusConsole()).busca(inicialQueens);
		        System.out.println("solução:\n" + n.getEstado() + "\n\n");
			
			break;
		case 0:
			
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	    
		
		

	}

}

