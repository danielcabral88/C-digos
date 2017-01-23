#include <stdio.h>
#include <stdlib.h>
#include "grafo.h"

#define NUM_TRACOS 4

Grafo criarGrafo(int vertices)
{
    int i, j;

    Grafo g = (Grafo) malloc (sizeof(grafo));

    if (g == NULL)
        return NULL;

    g->matriz = (int**) malloc (sizeof(int**) * (vertices + 1));
    g->matriz[0] = NULL;

    for (i = 0; i <= vertices; i++)
    {
        g->matriz[i] = (int*) malloc (sizeof(int*) * (vertices + 1));
    }

    for (i = 0; i <= vertices; i++)
    {
        for (j = 0; j <= vertices; j++)
        {
            g->matriz[i][j] = 0;
        }
    }

    g->num_vertices = vertices;

    return g;
}

int inserirAresta(Grafo g, int origem, int destino)
{
    if (g->matriz == NULL)
        return FALSE;

    if ((origem >= 0 && origem <= g->num_vertices) && (destino >= 0 && destino <= g->num_vertices))
    {
        g->matriz[origem][destino] = 1;
    }

    return TRUE;
}

int removerAresta(Grafo g, int origem, int destino)
{
    if (g->matriz == NULL)
        return FALSE;

    if ((origem >= 0 && origem <= g->num_vertices) && (destino >= origem && destino <= g->num_vertices))
    {
        g->matriz[origem][destino] = 0;
    }

    return TRUE;
}

void destroiGrafo(Grafo g)
{
    int i;

    if (g != NULL && g->matriz != NULL)
    {
        for (i = 0; i < g->num_vertices; i++)
        {
            free(g->matriz[i]);
        }
        free(g->matriz);
        free(g);
    }
}

void imprimirArestas(Grafo g)
{
    int x, y;

    for (x = 1; x <= g->num_vertices; x++)
    {
       printf("| %c |", x);
        for (y = 1; y <= g->num_vertices; y++)
        {
            printf("  %i |", g->matriz[x][y]);
        }
        printf("\n");
    }
}

void imprimirTabela(int qtd_traco)
{
    int x;

    printf("+");

    for (x = 1; x <= qtd_traco; x++)
    {
        printf("-");
        if (x % NUM_TRACOS == 0)
            printf("+");
    }
    printf("\n");
}

void imprimirGrafo(Grafo g)
{
    int x, y;

    y = (NUM_TRACOS * (g->num_vertices + 1));

    printf("\n");

    imprimirTabela(y);

    printf("| NV |");

    for (x = 1; x <= g->num_vertices; x++)
    {
        printf(" %.2d |", x);
    }

    printf("\n");

    imprimirTabela(y);
    imprimirArestas(g);
    imprimirTabela(y);
}


