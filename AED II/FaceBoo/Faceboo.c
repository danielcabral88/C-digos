#include "Grafo.h"
#include "Fila.h"

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <tchar.h>
#include <math.h>


FP criaFP()
{
    FP f = (FP) malloc (sizeof(filaP));

    if (f == NULL)
        return NULL;

    f->primeiro = NULL;
    f->ultimo = NULL;
    f->qtd = 0;

    return f;
}

int inserirArestaPeso(FP f, Aresta a)
{
    Nodo nodo = (Nodo) malloc (sizeof(nodo));

    Nodo temp, t = NULL;

    nodo->a = a;
    nodo->prox = NULL;

    if (f == NULL)
        return FALSE;

    if (f->primeiro == NULL)
    {
        f->primeiro = nodo;
        f->ultimo = nodo;
    }
    else
    {
        temp = f->primeiro;

        while (temp != NULL && temp->a->peso <= nodo->a->peso)
        {
            t = temp;
            temp = temp->prox;
        }

        if (temp == f->ultimo)
        {
            nodo->prox = temp;
            f->primeiro = nodo;
            f->ultimo = nodo;
        }
        else
        {
            nodo->prox = t->prox;
            t->prox = nodo;
        }
    }

    f->qtd += 1;

    return TRUE;
}

Grafo criarGrafo(int vertex, int arestas, int direcao)
{
    int i, j;

    Grafo g = (Grafo) malloc (sizeof(grafo));

    if (g == NULL)
        return NULL;

    g->matriz = (int**) malloc (sizeof(int*) * (vertex + 1));
    g->arestas = (Aresta*) malloc (sizeof(Aresta) * (arestas + 1));
    g->vertices = (Vertice*) malloc (sizeof(Vertice) * (vertex + 1));

    for (i = 0; i <= vertex; i++)
    {
        g->matriz[i] = (int*) malloc (sizeof(int*) * (vertex + 1));
        g->vertices[i] = (Vertice) malloc (sizeof(vertex));
    }

    for (i = 1; i <= arestas; i++)
    {
        g->arestas[i] = (Aresta) malloc (sizeof(aresta));
    }

    for (i = 1; i <= vertex; i++)
    {
        for (j = 1; j <= vertex; j++)
        {
            g->matriz[i][j] = 0;
        }
    }

    g->num_arestas = arestas;
    g->qtd_arestas = 0;
    g->num_vertices = vertex;
    g->direcao = direcao;

    return g;
}

Vertice criarVertice(int chave, int valor)
{
    Vertice v = (Vertice) malloc (sizeof(vertice));

    if (v == NULL) return NULL;

    v->chave = chave;
    v->valor = valor;

    return v;
}

Aresta criarAresta(Vertice *vertex, int origem, int destino, int peso)
{
    Aresta a = (Aresta) malloc (sizeof(aresta));

    if (a == NULL)
        return NULL;

    a->origem = vertex[origem];
    a->destino = vertex[destino];
    a->peso = peso;

    return a;
}

int inserirAresta(Grafo g, int origem, int destino, int peso)
{
    int i = g->qtd_arestas;
    int a, b;

    if (g->matriz == NULL) return FALSE;

	a = origem;
	b = destino;

    if ((a >= 1 && a <= g->num_vertices) && (b >= 1 && b <= g->num_vertices))
    {
        if (g->matriz[a][b] == 0)
        {
            g->matriz[a][b] = 1;
            g->arestas[i+1] = criarAresta(g->vertices, a, b, peso);
        }

        if (g->direcao == NAO_DIRECIONADO)
        {
            g->matriz[b][a] = 1;
        }

        g->qtd_arestas += 1;
    }
    return TRUE;
}

int bfsboo(Grafo g, int raiz)
{
    int i, j, aux;

	aux = 0;

    int *cor, *distancia, *pi;

    Fila f = criarFila();

    cor = (int*) malloc (sizeof(int) * (g->num_vertices + 1));
    distancia = (int*) malloc (sizeof(int) * (g->num_vertices + 1));
    pi = (int*) malloc (sizeof(int) * (g->num_vertices + 1));

    for (i = 1; i <= g->num_vertices; i++)
    {
        cor[g->vertices[i]->valor] = BRANCO;
        distancia[g->vertices[i]->valor] = -1;
        pi[g->vertices[i]->valor] = -1;
    }

    cor[g->vertices[raiz]->valor] = CINZA;
    distancia[g->vertices[raiz]->valor] = 0;
    pi[g->vertices[raiz]->valor] = -1;

    enqueue(f, g->vertices[raiz]->valor);

    while(!filaVazia(f))
    {
        i = f->primeiro->info;

        dequeue(f);

        for (j = 1; j <= g->num_vertices; j++)
        {
            if (cor[g->vertices[j]->valor] == BRANCO && g->matriz[i][g->vertices[j]->valor] == 1)
            {
                cor[g->vertices[j]->valor] = CINZA;
                distancia[g->vertices[j]->valor] = distancia[g->vertices[j]->valor] + 1;
                pi[g->vertices[j]->valor] = i;
                enqueue(f, g->vertices[j]->valor);
                aux += 1;
            }
        }
        cor[g->vertices[i]->valor] = PRETO;
    }
    free(pi);
    free(distancia);
    free(cor);

    return aux;
}

