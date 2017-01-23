#include "Fila.h"

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <tchar.h>

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

int filaVazia(Fila f)
{
    if (f == NULL)
        return -1;
    if (f->quantidade == 0)
        return TRUE;
    return FALSE;
}
