#ifndef GRAFO_H_INCLUDED
#define GRAFO_H_INCLUDED
#define BLACK 2
#define GRAY  3
#define WHITE 4
#define TRUE 1
#define FALSE 0


typedef struct {

int **m;
int num;
int *cor;
int *com;
int *fim;
} grafo;

typedef grafo* Grafo;

typedef struct{

int vert;
int posi;
}topological;

Grafo criar(int nv);
void destroi(Grafo g);
int inserir(Grafo g, int origem,int destino, int peso);
void DFS(Grafo G);
int *BuscaEmLargura(Grafo G, int raiz);
int *Prim(Grafo G,int r);
topological *topologicalsort(Grafo G);

#endif // GRAFO_H_INCLUDED
