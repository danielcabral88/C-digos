#include <stdlib.h>
#include <stdio.h>
#include "fila.h"

void imprimirFila(Fila f)
{
    No aux;

    if (filaVazia(f))
        return;
    if (f != NULL)
    {
        aux = f->primeiro;
        while (aux != NULL)
        {
            printf("%d ", aux->info);
            aux = aux->prox;
        }
    }
}

Fila criarFila()
{
    Fila f = (Fila) malloc (sizeof(fila));

    if (f == NULL)
        return NULL;

    f->primeiro = NULL;
    f->ultimo = NULL;
    f->quantidade = 0;

    return f;
}

int enqueue(Fila f, int conteudo)
{
    No no;
    if (f == NULL)
        return FALSE;

    no = (No) malloc (sizeof(no));

    if (no != NULL)
    {
        no->info = conteudo;
        no->prox = NULL;

        if (f->primeiro == NULL)
            f->primeiro = no;
        else
            f->ultimo->prox = no;
        f->ultimo = no;
        f->quantidade++;
    }
    return TRUE;
}

int dequeue(Fila f)
{
    No aux;

    if (f == NULL)
        return FALSE;
    if (filaVazia(f))
        return FALSE;

    aux = f->primeiro;
    f->primeiro = f->primeiro->prox;
    f->quantidade--;

    free(aux);

    return TRUE;

}

int buscarNaFila(Fila f, int conteudo)
{
    No no = f->primeiro;

    if (f == NULL)
        return FALSE;

    while (no != NULL)
    {
        if (no->info == conteudo)
        {
            return TRUE;
        }
        no = no->prox;
    }

    return FALSE;

}

int filaVazia(Fila f)
{
    if (f == NULL)
        return -1;
    if (f->quantidade == 0)
        return TRUE;
    return FALSE;
}


int liberarFila(Fila f)
{
    No aux;

    if (f == NULL)
        return FALSE;

    aux = f->primeiro;

    while (aux != NULL)
    {
        No q = aux->prox;
        free(aux);
        aux = q;
    }

    free(f);
    return TRUE;
}

void * primeiroDaFila(Fila f)
{
    if (filaVazia(f))
        return NULL;
    return f->primeiro;
}

void * ultimoDaFila(Fila f)
{
    if (filaVazia(f))
        return NULL;
    return f->ultimo;
}
