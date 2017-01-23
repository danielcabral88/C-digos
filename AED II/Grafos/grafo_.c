#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "grafo.h"

#define NUM_TRACOS 3

int tempo = 0;

PQ criaPQ()
{
    PQ f = (PQ) malloc (sizeof(filaP));

    if (f == NULL)
        return NULL;

    f->primeiro = NULL;
    f->ultimo = NULL;
    f->qtd = 0;

    return f;
}

int inserirArestaPeso(PQ f, Aresta a)
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

Grafo criarGrafo(int vertices, int arestas, int direcao)
{
    int i, j;

    Grafo g = (Grafo) malloc (sizeof(grafo));

    if (g == NULL)
        return NULL;

    g->matriz = (int**) malloc (sizeof(int*) * (vertices + 1));
    g->arestas = (Aresta*) malloc (sizeof(Aresta) * (arestas + 1));
    g->vertices = (Vertice*) malloc (sizeof(Vertice) * (vertices + 1));

    for (i = 0; i <= vertices; i++)
    {
        g->matriz[i] = (int*) malloc (sizeof(int*) * (vertices + 1));
        g->vertices[i] = (Vertice) malloc (sizeof(vertice));
    }

    for (i = 1; i <= arestas; i++)
    {
        g->arestas[i] = (Aresta) malloc (sizeof(aresta));
    }

    for (i = 1; i <= vertices; i++)
    {
        for (j = 1; j <= vertices; j++)
        {
            g->matriz[i][j] = 0;
        }
    }

    g->num_arestas = arestas;
    g->qtd_arestas = 0;
    g->num_vertices = vertices;
    g->direcao = direcao;

    return g;
}

Vertice criarVertice(char chave, int valor)
{
    Vertice v = (Vertice) malloc (sizeof(vertice));

    if (v == NULL)
        return NULL;

    v->chave = chave;
    v->valor = valor;

    return v;
}

Aresta criarAresta(Vertice *vertices, int origem, int destino, int peso)
{
    Aresta a = (Aresta) malloc (sizeof(aresta));

    if (a == NULL)
        return NULL;

    a->origem = vertices[origem];
    a->destino = vertices[destino];
    a->peso = peso;

    return a;
}

int toInt(Grafo g, char c)
{
    int i;

    for (i = 1; i <= g->num_vertices; i++)
    {
        if (c == g->vertices[i]->chave)
            return g->vertices[i]->valor;
    }
    return FALSE;
}

int inserirAresta(Grafo g, char origem, char destino, int peso)
{
    int i = g->qtd_arestas;
    int a, b;

    if (g->matriz == NULL)
        return FALSE;

    a = toInt(g, origem);
    b = toInt(g, destino);

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

int removerAresta(Grafo g, int origem, int destino)
{
    if (g->matriz == NULL)
        return FALSE;

    if ((origem > 0 && origem <= g->num_vertices) && (destino >= origem && destino <= g->num_vertices))
    {
        g->matriz[origem][destino] = 0;

        if (g->direcao == NAO_DIRECIONADO)
        {
            g->matriz[destino][origem] = 0;
        }
    }

    g->qtd_arestas -= 1;

    return TRUE;
}

void destroiGrafo(Grafo g)
{
    int i;

    if (g != NULL && g->matriz != NULL)
    {
        for (i = 1; i <= g->qtd_arestas; i++)
        {
            free(g->arestas[i]);
        }

        for (i = 0; i <= g->num_vertices; i++)
        {
            free(g->vertices[i]);
            free(g->matriz[i]);
        }

        free(g->arestas);
        free(g->vertices);
        free(g->matriz);
        free(g);
    }
}

int numVertices(Grafo g)
{
    if (g->matriz == NULL)
        return FALSE;
    return g->num_vertices;
}

int numArestas(Grafo g)
{
    if (g->matriz == NULL)
        return FALSE;
    return g->num_arestas;
}

void percurso(Grafo g)
{
    int i;

    if (g->matriz == NULL)
        return;

    for (i = 1; i <= g->qtd_arestas; i++)
    {
        printf(" [Aresta %d] Origem: %c Destino: %c Peso: %d\n", i, g->arestas[i]->origem->chave, g->arestas[i]->destino->chave, g->arestas[i]->peso);
    }
}

Grafo transpor(Grafo g)
{
    Grafo aux;

    int i, j;

    if (g->matriz == NULL)
        return FALSE;

    aux = criarGrafo(g->num_vertices, g->num_arestas, g->direcao);

    for (i = 1; i <= aux->num_vertices; i++)
    {
        for (j = 1; j <= aux->num_vertices; j++)
        {
            aux->matriz[i][j] = g->matriz[j][i];
        }
    }

    return aux;
}

int grafoNulo(Grafo g)
{
    if (g == NULL || g->matriz == NULL)
        return TRUE;
    return FALSE;
}

void imprimirArestas(Grafo g)
{
    int x, y;

    for (x = 1; x <= g->num_vertices; x++)
    {
       printf("| %c |", g->vertices[x]->chave);
        for (y = 1; y <= g->num_vertices; y++)
        {
            printf(" %d |", g->matriz[x][y]);
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

    printf("| * |");

    for (x = 1; x <= g->num_vertices; x++)
    {
        printf(" %c |", g->vertices[x]->chave);
    }

    printf("\n");

    imprimirTabela(y);

    imprimirArestas(g);

    imprimirTabela(y);
}

void bfs(Grafo g, int raiz)
{
    int i, j;

    int *cor, *distancia, *pi;

    Fila f = criarFila();

    cor = (int*) malloc (sizeof(int) * (g->num_vertices + 1));
    distancia = (int*) malloc (sizeof(int) * (g->num_vertices + 1));
    pi = (int*) malloc (sizeof(int) * (g->num_vertices + 1));

    if (g->matriz == NULL)
        return;

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

    {
    while(!filaVazia(f))
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
            }
        }
        cor[g->vertices[i]->valor] = PRETO;
    }

    for (i = 1; i <= g->num_vertices; i++)
    {
        percorrerCaminho(g, 1, g->vertices[i]->valor, pi);
        printf("\n");
    }

    free(pi);
    free(distancia);
    free(cor);
}

void percorrerCaminho(Grafo g, int a, int b, int * pi)
{\zaz\\
    if (g->matriz == NULL || b > numVertices(g) || b < 1)
    {
        printf(" Requisitos nao atendidos para BFS.");
        return;
    }
    else
    {
        if (a == b)
            printf("  %c", g->vertices[a]->chave);
        else
        {
            if (pi[b] == -1)
            {
                printf(" '%c' e '%c' nao estao conectados. ", g->vertices[a]->chave, g->vertices[b]->chave);
            }
            else
            {
                percorrerCaminho(g, a, pi[b], pi);
                printf(" %c", g->vertices[b]->chave);
            }
        }
    }
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

    printf(" \nResultado DFS: \n");

    for (i = 1; i <= g->num_vertices; i++)
    {
        printf(" %c %d %d\n", g->vertices[i]->chave, g->vertices[i]->t_ini, g->vertices[i]->t_fim);
    }

    free(pi);
    free(cor);
}

void troca (int *x, int *y)
{
    int aux;

    aux = *x;
    *x = *y;
    *y = aux;
}

void quickSort(Vertice *vetor, int inicio, int fim)
{
    int pivo, i, j;

    if (fim > inicio)
    {
        i = inicio;
        j = fim;
        pivo = vetor[(inicio + fim)/2]->t_fim;

        while (i <= j)
        {
            while (vetor[i]->t_fim < pivo)
                i++;
            while (vetor[j]->t_fim > pivo)
                j--;
            if (i <= j)
            {
                troca(&vetor[i]->t_fim, &vetor[j]->t_fim);
                troca(&vetor[i]->t_ini, &vetor[j]->t_ini);
                troca(&vetor[i]->valor, &vetor[j]->valor);
                troca((int*)&vetor[i]->chave, (int*)&vetor[j]->chave);
                i++;
                j--;
            }
        }
        quickSort(vetor, inicio, j);
        quickSort(vetor, i, fim);
    }
}

void topologicalSort(Grafo g, int raiz)
{
    int i;

    Vertice *temp = (Vertice*) malloc (sizeof(Vertice) * (g->num_vertices + 1));

    if (g->matriz == NULL)
        return;

    dfs(g, raiz);

    for (i = 1; i <= g->num_vertices; i++)
    {
        temp[i] = g->vertices[i];
    }

    quickSort(temp, 0, g->num_vertices);

    printf("Ordem Topologica:");

    for (i = g->num_vertices; i >= 1; i--)
    {
        printf(" %c", temp[i]->chave);
    }
}

void initializeSingleSource(Grafo g, int raiz, int *pi)
{
    int i;

    if (g->matriz == NULL)
        return;

    for (i = 1; i <= g->num_vertices; i++)
    {
        g->vertices[i]->t_ini = 999;
        pi[i] = 999;
    }

    g->vertices[raiz]->t_ini = 0;
}

void relax(Grafo g, int i, int j, int *pi)
{
    if (g->matriz == NULL)
        return;

    int peso = pesoAresta(g, g->vertices[i]->valor, g->vertices[j]->valor);

    if (g->vertices[j]->t_ini > (g->vertices[i]->t_ini + peso))
    {
        g->vertices[j]->t_ini = g->vertices[i]->t_ini + peso;
        pi[j] = g->vertices[i]->valor;
    }
}

void bellmanFord(Grafo g, int raiz)
{
    int i, j, peso;
    int *pi;
    Vertice *a, *b;

    if (g->matriz == NULL)
        return;

    pi = (int*) malloc (sizeof(int) * (g->num_vertices + 1));
    a = (Vertice*) malloc (sizeof(vertice) * (g->qtd_arestas + 1));
    b = (Vertice*) malloc (sizeof(vertice) * (g->qtd_arestas + 1));

    for (i = 1; i <= g->qtd_arestas; i++)
    {
        a[i] = g->arestas[i]->origem;
        b[i] = g->arestas[i]->destino;
    }

    initializeSingleSource(g, g->vertices[raiz]->valor, pi);

    for (i = 0; i < g->num_vertices - 1; i++)
    {
        for (j = 1; j <= g->qtd_arestas; j++)
        {
            relax(g, a[j]->valor, b[j]->valor, pi);
        }
    }

    for (i = 1; i <= g->qtd_arestas; i++)
    {
        peso = pesoAresta(g, a[i]->valor, b[i]->valor);
        if (b[i]->t_ini > (a[i]->t_ini + peso))
        {
            printf("\nO grafo encontrou ciclos de peso negativo.");
            return;
        }
    }
    printf("\nPercurso Finalizado.");

    for (i = 1; i <= g->qtd_arestas; i++)
    {
        printf(" %c :: %d - %c :: %d\n", a[i]->chave, a[i]->t_ini, b[i]->chave, b[i]->t_ini);
    }

//    for (i = 1; i <= g->qtd_arestas; i++)
//    {
//        free(a[i]);
//        free(b[i]);
//    }

    free(pi);
    free(a);
    free(b);
}

void dijkstra(Grafo g, int raiz)
{
    int i, j;
    int *pi;

    if (g->matriz == NULL)
        return;

    pi = (int*) malloc (sizeof(int) * (g->num_vertices + 1));

    Fila f = criarFila();

    initializeSingleSource(g, g->vertices[raiz]->valor, pi);

    for (i = 1; i <= g->num_vertices; i++)
    {
        enqueue(f, g->vertices[i]->valor);
    }

    while (!filaVazia(f))
    {
        j = f->primeiro->info;
        dequeue(f);

        printf("%c ", g->vertices[j]->chave);

        for (i = 1; i <= g->num_vertices; i++)
        {
            if (g->matriz[i][j] == 1 && pi[i] != j)
            {
                relax(g, g->vertices[i]->valor, g->vertices[j]->valor, pi);
            }
        }
    }
    free(pi);
}


void stronglyConnectedComponents(Grafo g, int raiz)
{
    Grafo temp = transpor(g);

    dfs(g, raiz);
    dfs(temp, raiz);

}

int removerDaFila(Fila f, int valor)
{
    No temp, no = f->primeiro;

    if (f == NULL)
        return FALSE;

    while (no != NULL)
    {
        temp = no;

        if (no->info == valor)
        {
            if (no == f->primeiro)
            {
                f->primeiro = f->ultimo = NULL;
            }
            else
            {
                temp->prox = no->prox;
            }
        }
        no = no->prox;
    }

    f->quantidade -= 1;
    free(no);

    return TRUE;
}

int pesoAresta(Grafo g, int origem, int destino)
{
    int i;

    if (g->arestas == NULL)
        return FALSE;

    for (i = 1; i <= g->qtd_arestas; i++)
    {
        if (g->arestas[i]->origem->valor == origem && g->arestas[i]->destino->valor == destino)
            return g->arestas[i]->peso;

        if (g->direcao == NAO_DIRECIONADO)
        {
            if (g->arestas[i]->origem->valor == destino && g->arestas[i]->destino->valor == origem)
                return g->arestas[i]->peso;
        }
    }
    return FALSE;
}

int findSet(Aresta a)
{
    return TRUE;
}

void prim(Grafo g, int raiz)
{
    int i, j;

    int *pi, *chave;

    Fila f = criarFila();

    chave = (int*) malloc (sizeof(int) * (g->num_vertices + 1));
    pi = (int*) malloc (sizeof(int) * (g->num_vertices + 1));

    if (g->matriz == NULL)
        return;

    for (i = 1; i <= g->num_vertices; i++)
    {
        chave[i] = 999;
        pi[i] = -1;
    }

    chave[raiz] = 0;
    pi[raiz] = 0;

    for (i = 1; i <= g->num_vertices; i++)
    {
        enqueue(f, i);
    }

    while (!filaVazia(f))
    {
        i = f->primeiro->info;
        dequeue(f);

        for (j = 1; j <= g->num_vertices; j++)
        {
            if (g->matriz[i][j] == 1)
            {
                if (pesoAresta(g, i, j) < chave[j] && (buscarNaFila(f, j) == TRUE))
                {
                    if (pi[j] != i)
                    {
                        pi[j] = i;
                        chave[j] = pesoAresta(g, i, j);
                    }
                }
            }
        }
    }

    for (i = 1; i <= g->num_vertices; i++)
        if (pi[i] != -1 || chave[i] != 999)
            printf(" %d - %d %d\n", pi[i], i, chave[i]);

    free(chave);
    free(pi);
}

void kruskal(Grafo g, int raiz)
{
    int i, j;

    Fila *fila = (Fila*) malloc (sizeof(Fila));
    PQ temp = criaPQ();

    for (i = 1; i <= g->qtd_arestas; i++)
    {
        inserirArestaPeso(temp, g->arestas[i]);
    }

    Nodo n = temp->primeiro;

    while (n != NULL)
    {
        printf("%c %c %d\n", n->a->origem->chave, n->a->destino->chave, n->a->peso);
        n = n->prox;
    }

    for (i = 1; i <= g->num_vertices; i++)
    {
        fila[i] = criarFila();
        enqueue(fila[i], g->vertices[i]->valor);
    }

    for (i = 1; i <= g->num_vertices; i++)
    {
        j = fila[i]->primeiro->info;
    }

//    for (i = 1; i <= g->qtd_arestas; i++)
//    {
//        printf("%c %c %d\n", g->arestas[i]->origem->chave, g->arestas[i]->destino->chave, g->arestas[i]->peso);
//    }
}
