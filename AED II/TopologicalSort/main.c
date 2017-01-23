#include "Grafo.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int n, m, b1, b2, i;
    char *bebidas;
    char bebida[51];
    Grafo g;

    scanf("%d", &n);

    bebidas = (char*) malloc(n* sizeof(char));

    for (i = 0 ; i < n; i++)
    {
        scanf("%s", bebida);
        bebidas[i] = bebida;
    }

    scanf("%d", &m);

    g = criarGrafo(n, m, 1);

    for (i = 1; i <= n; i++)
    {
        criarVertice(bebidas[i], i);
    }

    for (i = 0; i < m; i++)
    {
        scanf("%d %d", &b1, &b2);
        inserirAresta(g, b1, b2, 1);
    }

    topologicalSort(g, 1);

}
