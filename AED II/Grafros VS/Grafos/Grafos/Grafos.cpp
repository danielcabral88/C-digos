// Grafos.cpp : Defines the entry point for the console application.
//

#include <stdio.h>
#include <iostream>
#include <stdio.h>
#include "Grafos.h"
#include "stdafx.h"


int _tmain(int argc, _TCHAR* argv[])
{
	int ret;
    //printf("ok");
    Graph g = cria (14);


    ret = inserir(g,1,2,4); //ab
    ret = inserir(g,2,3,8); //bc
    ret = inserir(g,3,4,7); //cd
    ret = inserir(g,4,5,9); //de
    ret = inserir(g,5,6,10); //ef
    ret = inserir(g,6,7,2); // fg
    ret = inserir(g,7,8,1); // gh
    ret = inserir(g,8,9,7); // hi
    ret = inserir(g,1,8,8); // ah
    ret = inserir(g,2,8,11); // ch
    ret = inserir(g,9,7,6); // ig
    ret = inserir(g,9,3,2); // ic
    ret = inserir(g,3,6,4); // cf
    ret = inserir(g,4,6,14); // df

	int i , j;
	for (i = 0 ; i < g->qtd_vertex ; i++){
		for (j = 0 ; j < g->qtd_vertex ; j++) printf("%d ", g->matriz_adj[i][j]);
		printf("\n");
	}

	busca_em_largura(g,1);
    busca_em_profundidade(g);
	system("pause");
    
}

