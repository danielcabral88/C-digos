#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "grafo.h"
#include "fila.h"

#define VERTICES 5
#define ARESTAS 7
#define CONT 10
#define LIMPAR system("cls"); main();

#define MAX 5

int extractMin();

int main()
{
    int i, j;

    Grafo g = criarGrafo(MAX, 8, 1);

    char c;
    char a, b;

    printf("Escolha os vertices: \n");
    for (i = 1; i <= MAX; i++)
    {
        fflush(stdin);
        scanf("%c", &c);
        g->vertices[i] = criarVertice(c, i);
    }

    printf("\nEscolhas as arestas: \n");

    for (i = 1; i <= MAX; i++)
        printf("%c ", g->vertices[i]->chave);

    printf("\n");

    for (i = 1; i <= MAX+5; i++)
    {
        fflush(stdin);
        scanf("%c %c %d", &a, &b, &j);
        inserirAresta(g, a, b, j);
    }

//    inserirAresta(g, 1, 4, 4)
//    inserirAresta(g, 2, 2, 7);
//    inserirAresta(g, 2, 4, 1);
//    inserirAresta(g, 1, 2, 6);
//    inserirAresta(g, 4, 4, 4);
//    inserirAresta(g, 3, 4, 2);
//    inserirAresta(g, 3, 1, 8);

//    imprimirGrafo(g);
//
//    bfs(g, 1);
//
//    printf("\n");
//
//    i = pesoAresta(g, 1, 2);
//
//    printf("Peso: %d\n", i);
//
//    i = pesoAresta(g, 2, 3);
//
//    printf("Peso: %d\n", i);
//
//    dfs(g, 1);
//
//    printf("\nTopological Sort\n");
//
//    topologicalSort(g, 1);
//
//    printf("\n");
    //bellmanFord(g, 1);
    //kruskal(g, 1);
    //dijkstra(g, 1);

    //bellmanFord(g, 1);
    prim(g, 1);

    destroiGrafo(g);

    return 0;
}

int extractMin()
{
    return TRUE;
}
