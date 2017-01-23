#ifndef GRAFO_H_INCLUDED
#define GRAFO_H_INCLUDED

#define DIRECIONADO 1
#define NAO_DIRECIONADO 2

#define BRANCO 0
#define CINZA 1
#define PRETO 2

#include "fila.h"

typedef struct vertice_
{
    char chave;
    int valor;
    int t_ini;
    int t_fim;
}vertice;

///Defini��o do tipo Vertice

typedef vertice * Vertice;

typedef struct aresta_
{
    Vertice origem;
    Vertice destino;
    int peso;
}aresta;

///Defini��o do tipo aresta;

typedef aresta * Aresta;

typedef struct grafo_
{
    int **matriz;
    int num_vertices;
    int num_arestas;
    int qtd_arestas;
    int direcao;
    Aresta *arestas;
    Vertice *vertices;
}grafo;


///Defini��o do tipo Grafo

typedef grafo * Grafo;


typedef struct nodo_
{
    Aresta a;
    struct nodo_ *prox;
}nodo;

typedef nodo * Nodo;


typedef struct filaP_
{
    Nodo primeiro;
    Nodo ultimo;
    int qtd;
}filaP;

typedef filaP * PQ;


/**
Cria e retorna um novo Grafo com n v�rtices utilizados na
constru��o da matriz de adjac�ncias
**/
Grafo criarGrafo(int vertices, int arestas, int direcao);

/**
Insere uma aresta (liga��o) entre dois v�rtices, passados
os v�rtices de origem e destino
**/
int inserirAresta(Grafo g, char origem, char destino, int peso);

/**
Remove uma aresta 'E' entre dois v�rtices, passando-se os valores de
origem e destino
**/
int removerAresta(Grafo g, int origem, int destino);

/**
Verifica se um grafo 'g' encontra-se nulo ou preenchido com arestas
**/
int grafoNulo(Grafo g);

/**
Libera mem�ria alocada para o grafo e matriz de adjac�ncia
**/
void destroiGrafo(Grafo g);

/**
Retorna o peso de uma aresta a partir das informa��es
de origem e destino dos v�rtices
**/
int pesoAresta(Grafo g, int origem, int destino);

/**
Exibe em tela a matriz de adjac�ncias de um grafo G
**/
void imprimirGrafo(Grafo g);

/**
Realiza a transposi��o de um grafo 'g' (invers�o entre linhas e colunas)
(Grafos direcionados)
**/
Grafo transpor(Grafo g);

/**
Retorna o n�mero de v�rtices que comp�e a matriz de adjac�ncias
**/
int numVertices(Grafo g);

/**
Retorna o n�mero de arestas que comp�e a matriz de adjac�ncias
**/
int numArestas(Grafo g);

/**
Exibe na tela as arestas que comp�em um grafo 'g'
**/
void percurso(Grafo g);

/**
Realiza a opera��o de busca em largura
(Breadth-first search)
**/
void bfs(Grafo g, int raiz);

/**
Exibe os v�rtices que comp�em  o percurso mais curto de 'a' at� 'b' em um grafo 'g'
(Print-Path())
**/
void percorrerCaminho(Grafo g, int a, int b, int * pi);

/**
Realiza a opera��o de busca em profundidade
(Depth-first search)
**/
void dfs(Grafo g, int raiz);


/**Ordena��o Topol�gica:
Pr�-requisito: timestamps obtidos a partir da DFS
**/
void topologicalSort(Grafo g, int raiz);

/**Componentes Fortemente Conectados:
Pr�-requisito: timestamps obtidos a partir da DFS
**/
void stronglyConnectedComponents(Grafo g, int raiz);

/**
Algoritmo de Bellman-Ford
**/
void bellmanFord(Grafo g, int raiz);

/**
Algoritmo de Kruskal
**/
void kruskal(Grafo g, int raiz);

/**
Algoritmo de Prim
**/
void prim(Grafo g, int raiz);

/**
Algoritmo de Dijkstra
**/
void dijkstra(Grafo g, int raiz);

#endif // GRAFO_H_INCLUDED
