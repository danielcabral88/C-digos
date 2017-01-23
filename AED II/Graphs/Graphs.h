#ifndef Graphs_H_
#define Graphs_H_
#define TRUE 1
#define FALSE 0
#define preto  2
#define cinza  3
#define branco 4

typedef struct {
    int ** matriz_adj;
    int qtd_vertex;
    int * inicio;
    int * fim;
    int * cor;
} grafo;

typedef grafo * Graph;

Graph cria (int qtd_vertex);
int inserir (Graph G, int ini, int fim, int peso);
void busca_em_largura(Graph g, int k);
void busca_em_profundidade(Graph g);

#endif
