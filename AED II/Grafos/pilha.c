#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

Pilha criarPilha()
{
    Pilha p = (Pilha) malloc (sizeof(pilha));

    if (p == NULL)
        return NULL;

    p->topo = NULL;
    p->quantidade = 0;

    return p;
}

int push(Pilha p, int conteudo)
{
    No no;

    if (p == NULL)
        return FALSE;

    no = (No) malloc (sizeof(no));

    no->info = conteudo;
    no->prox = p->topo;
    p->topo = no;
    p->quantidade += 1;

    return TRUE;
}

int pop(Pilha p)
{
    No no;

    if (p == NULL || pilhaVazia(p))
        return FALSE;

    no = p->topo;
    p->topo = p->topo->prox;
    p->quantidade -= 1;
    free(no);

    return TRUE;
}

int pilhaVazia(Pilha p)
{
    return p->quantidade == 0;
}

void * top(Pilha p)
{
    if (p != NULL && p->topo != NULL)
        return p->topo;
    return NULL;
}

void imprimirPilha(Pilha p)
{
    No no = p->topo;

    while (no != NULL)
    {
        printf("%d ", no->info);
        no = no->prox;
    }
}

void destruirPilha(Pilha p)
{
    No temp, no = p->topo;

    if (p != NULL)
    {
        while (no != NULL)
        {
            temp = no;
            no = no->prox;
            free(temp);
        }
    }
    free(p);
}
