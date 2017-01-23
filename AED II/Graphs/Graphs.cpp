#include <stdio.h>
#include <stdlib.h>
#include "Graphs.h"
#include <queue>
#include <limits.h>

using namespace std;

Graph cria(int qtd_vertex){
    int aux , aux2;

    Graph G =(Graph) malloc (sizeof (grafo)); // aloca memória para o grafo
    G->qtd_vertex = qtd_vertex; // insere a quantidade de vertíces ao grafo

    //qtd_vertex++; // incrementa a quantidade de vertices

    G->matriz_adj = (int**) malloc( sizeof (int*)*(qtd_vertex)); // aloca memória para a matriz de adjacencia
    G->inicio = (int*) malloc(sizeof(int)*(qtd_vertex)); // aloca memória para o ponteiro inicio
    G->fim = (int*) malloc(sizeof(int)*(qtd_vertex)); // aloca memória para o ponteiro fim
    G->cor = (int*) malloc(sizeof(int)*(qtd_vertex)); // aloca memória para o ponteiro cor

    for(aux = 0 ; aux < qtd_vertex ; aux++){ // for utilizado para alocar memória para cada podisção da matriz de adjacencia
        G->matriz_adj[aux] = (int*) malloc(sizeof(int) * (qtd_vertex)); // aloca memória para cada posição da matriz
    }
    for(aux = 0; aux < qtd_vertex ; aux++){ // for utlizado para zerar os valores da matriz de adjacencia
        for(aux2 = 0; aux2 < qtd_vertex ; aux2++) G->matriz_adj[aux][aux2] = 0;
    }
return G;
}

int inserir (Graph G, int ini, int fim, int peso){
    if(ini < 1 || fim  < 1 ) return FALSE; // verificar se o valor do vertice inserido é valido
    if(ini <= G->qtd_vertex  && fim <= G->qtd_vertex){ // verifica se o valor inserido é menor que a quantidade de vertices do grafo
        G->matriz_adj[ini][fim] = peso; // grafo bidirecional, então o peso é o mesmos na matriz de adjacencia tando ini fim , quanto pra fim ini
        G->matriz_adj[fim][ini] = peso;
        return TRUE;
    }else return FALSE;
}

Graph whitining (Graph G){ // Inicializa todas as cores das aresta com branco
    int aux;
    for(aux = 0 ; aux < G->qtd_vertex ; aux++){
        G->cor[aux] = branco;
    } return G;
}

void busca_em_largura(Graph g, int k){
    int aux, aux2, aux3;
    g = whitining(g);
    int qtd_vex = g->qtd_vertex;

    int *d = (int*) malloc(qtd_vex * sizeof(int)); // lista de vertices
    int *pi = (int*) malloc(qtd_vex * sizeof(int)); // lista de adjacentes
    for (aux = 0 ; aux < qtd_vex ; aux++){
        d[aux] = INT_MAX;
        pi[aux] = NULL;
    }
    g->cor[k] = cinza;
    d[k] = 0;
    pi[k] = NULL;

    queue <int> q;
    q.push(k);

    while (q.size() > 0){
        aux = q.front();
        for (aux2 = 0; aux2 > g->qtd_vertex ; aux2++ ){ // for utlizado para populas pi (lista de adjacentes
            if (g->matriz_adj[aux][aux2] == 1){
                pi[aux3] = aux2; // cria-se aqui uma lista de adjacentes com seus indices
                aux3++;
            }
            while (aux3 > aux2) // com a quantidade de adjacentes verifica se já foi visitado
            if (g->cor[pi[aux2]] == branco){ // com a quantidade de adjacentes verifica se já foi visitado
                printf("%d", aux2); // teste de funcionamento
                g->cor[aux2] = cinza;
                d[aux2] = d[aux] + 1;
                pi[aux2] = aux;
                q.push(aux2);
            }
            aux2++;
        }
        g->cor[aux] = preto;
    }
}
void dfs_visit(Graph g, int k){
    int aux;
    g->cor[k] = cinza;
    g->inicio[k] = k + 1; // inicia do elemento posterior ao passado como parâmetro
    for (aux = 0; aux < g->qtd_vertex ; aux++){
        if (g->matriz_adj[k][aux] == branco){
            printf("%d" , k); // teste de funcionamento
            aux = k;
            dfs_visit(g, aux);
        }
    }
    g->cor[k] = preto;
}

void busca_em_profundidade(Graph g){
    int aux;

    g = whitining(g);

    for (aux = 0 ; aux < g->qtd_vertex ; aux ++){
        if(g->cor[aux] == branco){
            dfs_visit(g, aux);
        }
    }
}




