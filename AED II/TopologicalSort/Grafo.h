#ifndef GRAFO_H_INCLUDED
#define GRAFO_H_INCLUDED

#define DIRECIONADO 1
#define NAO_DIRECIONADO 2

#define BRANCO 0
#define CINZA 1
#define PRETO 2

#define TRUE 1
#define FALSE 0

typedef struct _vertice
{
    char *chave;
    int valor;
    int t_ini;
    int t_fim;

}vertice;

typedef vertice * Vertice;

typedef struct _aresta
{
    Vertice origem;
    Vertice destino;
    int peso;
}aresta;

typedef aresta * Aresta;

typedef struct _grafo
{
    int **matriz;
    int num_vertices;
    int num_arestas;
    int qtd_arestas;
    int direcao;
    Aresta *arestas;
    Vertice *vertices;
}grafo;

typedef grafo * Grafo;

typedef struct _nodo
{
    Aresta a;
    struct _nodo *prox;
}nodo;

typedef nodo * Nodo;

typedef struct _filaP
{
    Nodo primeiro;
    Nodo ultimo;
    int qtd;
}filaP;

typedef filaP * FP;

Grafo criarGrafo(int vertices, int arestas, int direcao);

Vertice criarVertice(char * chave, int valor);

int inserirAresta(Grafo g, int origem, int destino, int peso);

int numVertices(Grafo g);

void dfsVisit(Grafo g, int raiz, int *pi, int *cor);

int numVertices(Grafo g);

void dfs(Grafo g, int raiz);

void permutar (Vertice *vertex, int x, int y);

void quickSort(Vertice *vetor, int inicio, int fim);

void topologicalSort(Grafo g, int raiz);

#endif
