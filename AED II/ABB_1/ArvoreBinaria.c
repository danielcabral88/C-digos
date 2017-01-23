#include <stdlib.h>
#include <stdio.h>
#include "ArvoreBinaria.h"

struct no
{
    int info;
    struct no *esq, *dir;
};

struct arvBinariaDeBusca
{
    No * raiz;
};

void visita(int conteudo)
{
    printf("%d ", conteudo);
}

ABB * criar()
{
    ABB * a = (ABB*) malloc (sizeof(ABB));

    if (a == NULL)
        return NULL;

    a->raiz = NULL;

    return a;
}

No * criarNo(int conteudo)
{
    No * no = (No*) malloc (sizeof(No));

    if (no == NULL)
        return NULL;

    no->info = conteudo;
    no->dir = NULL;
    no->esq = NULL;

    return no;
}

No * inserirNo(No * raiz, int conteudo)
{
    if (conteudo == raiz->info)
        return NULL;

    if (conteudo > raiz->info)
    {
        if (raiz->dir == NULL)
        {
            raiz->dir = criarNo(conteudo);
            return raiz->dir;
        }
        else
        {
            return inserirNo(raiz->dir, conteudo);
        }
    }
    else
    {
        if (raiz->esq == NULL)
        {
            raiz->esq = criarNo(conteudo);
            return raiz->esq;
        }
        else
        {
            return inserirNo(raiz->esq, conteudo);
        }
    }
    return raiz;
}

int inserir(ABB * arv, int conteudo)
{
    if (arv == NULL)
        return -1;

    if (arv->raiz == NULL)
        arv->raiz = criarNo(conteudo);
    else
        inserirNo(arv->raiz, conteudo);

    return 0;
}

/*int inserir(ABB* arv, int conteudo)
{
    No * no = (No*) malloc (sizeof(No));
    No * aux, *t;

    no->dir = NULL;
    no->esq = NULL;
    no->info = conteudo;

    aux = arv->raiz;
    t = NULL;

    if (arv == NULL)
        return -1;

    while (aux != NULL)
    {
        t = aux;

        if (conteudo > aux->info)
            aux = aux->dir;
        else
            aux = aux->esq;
    }

    if (arv->raiz == NULL)
    {
        arv->raiz = no;
    }
    else
        if (conteudo > t->info)
            t->dir = no;
        else
            t->esq = no;
    return 0;
}*/

int infoRaiz(ABB* arv)
{
    return (arv->raiz)->info;
}

void noOrdem(No * no, f_visitar * visita)
{
    if (no != NULL)
    {
        noOrdem(no->esq, visita);
        visita(no->info);
        noOrdem(no->dir, visita);
    }
    else
        return;
}

void noPreOrdem(No * no, f_visitar * visita)
{
    if (no != NULL)
    {
        visita(no->info);
        noPreOrdem(no->esq, visita);
        noPreOrdem(no->dir, visita);
    }
}

void noPosOrdem(No * no, f_visitar * visita)
{
    if (no != NULL)
    {
        noPosOrdem(no->esq, visita);
        noPosOrdem(no->dir, visita);
        visita(no->info);
    }
}

void emOrdem(ABB * arv)
{
    if (arv != NULL)
    {
        noOrdem(arv->raiz, visita);
    }
    return;
}

void preOrdem(ABB * arv)
{
    if (arv != NULL)
    {
        noPreOrdem(arv->raiz, visita);
    }
    return;
}

void posOrdem(ABB * arv)
{
    if (arv != NULL)
    {
        noPosOrdem(arv->raiz, visita);
    }
    return;
}

No * noMenor(No * no)
{
    if (no->esq == NULL)
        return no;
    return noMenor(no->esq);
}

int minimo(ABB * arv)
{
    No * no = noMenor(arv->raiz);

    if (no != NULL)
        return no->info;
    return -2;
}

No * noMaior(No * no)
{
    if (no->dir == NULL)
        return no;
    return noMaior(no->dir);
}

int maximo(ABB * arv)
{
    No * no = noMaior(arv->raiz);

    if (no != NULL)
        return no->info;
    return -2;
}

No * buscar(No * no, int conteudo)
{
    if (no != NULL)
    {
        if (conteudo == no->info)
            return no;
        if (conteudo > no->info)
            return buscar(no->dir, conteudo);
        else
            return buscar(no->esq, conteudo);
    }
    else
        return NULL;
    return no;
}

No * pai(No * raiz, No * no)
{
    if (raiz == NULL)
        return NULL;
    if ((raiz->esq == no) || (raiz->dir == no))
        return raiz;
    if (no->info > raiz->info)
        return pai(raiz->dir, no);
    return pai(raiz->esq, no);
}

int removerNo(ABB * arv, No * no, int conteudo)
{
    No * del;

    if (no == NULL)
        return -1;

    if (conteudo > no->info)
        removerNo(arv, no->dir, conteudo);
    else
        if (conteudo < no->info)
            removerNo(arv, no->esq, conteudo);
        else
        {
            if (no->dir != NULL && no->esq != NULL)
            {
                del = noMaior(no->esq);
                //del = noMenor(no->dir);
                no->info = del->info;
                removerNo(arv, no->esq, no->info);
            }
            else
            {
                del = pai(arv->raiz, no);
                if (no->info > del->info)
                {
                    if (no->dir == NULL)
                        del->dir = no->esq;
                    else
                        del->dir = no->dir;
                }
                else
                {
                    if (no->dir == NULL)
                        del->esq = no->esq;
                    else
                        del->esq = no->dir;
                }
            }
        }
    return 0;
}

int remover(ABB * arv, int conteudo)
{
    if (arv == NULL)
        return -1;

    return removerNo(arv, arv->raiz, conteudo);
}

void liberarNo(No * no)
{
    if (no != NULL)
    {
        liberarNo(no->esq);
        liberarNo(no->dir);
        free(no);
    }
    return;
}


void liberarArvore(ABB * arv)
{
    if (arv != NULL)
        liberarNo(arv->raiz);
    free(arv);
}
