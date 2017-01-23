#include "Grafo.h"

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <tchar.h>
#include <math.h>

int tempo;

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

Vertice criarVertice(char *chave, int valor)
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

void dfsVisit(Grafo g, int raiz, int *pi, int *cor)
{
    int i;
    cor[g->vertices[raiz]->valor] = CINZA;
    tempo += 1;
    g->vertices[raiz]->t_ini = tempo;

    for (i = 1; i <= g->num_vertices; i++)
    {
        if (g->matriz[g->vertices[raiz]->valor][i] == 1)
        {
            if (cor[g->vertices[i]->valor] == BRANCO)
            {
                pi[g->vertices[i]->valor] = g->vertices[raiz]->valor;
				dfsVisit(g, g->vertices[i]->valor, pi, cor);
			}
        }
    }
    cor[g->vertices[raiz]->valor] = PRETO;
    g->vertices[raiz]->t_fim = tempo += 1;
}

int numVertices(Grafo g)
{
    if (g->matriz == NULL) return FALSE;

    return g->num_vertices;
}

void dfs(Grafo g, int raiz)
{
    int i;
    int *pi, *cor;

    pi = (int*) malloc (sizeof(int) * (g->num_vertices + 1));
    cor = (int*) malloc (sizeof(int) * (g->num_vertices + 1));

    if (g->matriz == NULL)
        return;

    for (i = 1; i <= g->num_vertices; i++)
    {
        cor[i] = BRANCO;
        pi[i] = -1;
    }

    tempo = 0;

    for (i = 1; i <= g->num_vertices; i++)
    {
        if (cor[i] == BRANCO)
        {
            dfsVisit(g, i, pi, cor);
        }
    }

    free(pi);
    free(cor);
}

void permutar(Vertice *vertex, int d, int c)
{
    int aux;

    aux = vertex[d]->valor;
    vertex[d]->valor = vertex[c]->valor;
    vertex[c]->valor = aux;
}

int dividir(Vertice *vertex, int inicio, int fim, int pivo)
{
    int pos, j;

    permutar(vertex, pivo, fim);
    pos = inicio;

    for (j = inicio; j < fim; j++)
    {
        if (vertex[j]->valor < vertex[fim]->valor)
        {
            ++pos;
            permutar(vertex, j, pos);
        }
    }
    permutar(vertex, fim, pos);
    return pos;
}

void quickSort(Vertice * vertex, int inicio, int fim)
{
    int i, pivo;

    if (inicio < fim)
    {
        pivo = (inicio + fim) / 2;
        i = dividir(vertex, inicio, fim, pivo);
        quickSort(vertex, inicio, i - 1);
        quickSort(vertex, i + 1, fim);
    }
}
void topologicalSort(Grafo g, int raiz)
{
    int i;

    Vertice *temp = (Vertice*) malloc (sizeof(Vertice) * (g->num_vertices + 1));

    if (g->matriz == NULL) return;

    dfs(g, raiz);

    for (i = 1; i <= g->num_vertices; i++)
    {
        temp[i] = g->vertices[i];
    }

    quickSort(temp, 0, g->num_vertices);

    for (i = g->num_vertices; i >= 1; i--)
    {
        printf(" %s", temp[i]->chave);
    }
}
