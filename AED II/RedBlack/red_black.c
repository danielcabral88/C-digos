#include <stdio.h>
#include <stdlib.h>
#include "red_black.h"

#define RED 1
#define BLACK 2

struct no
{
    int info;
    int cor;
    struct no *esq;
    struct no *dir;
    struct no *pai;
};

struct arvore
{
    No *raiz;
};

RB * criarArvore()
{
    RB * a = (RB*) malloc (sizeof(RB));
    if (a == NULL)
        return a;

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
    no->pai = NULL;

    return no;
}

No * pai(No *no)
{
    if (no != NULL)
        return no->pai;
    return NULL;
}

No * avo(No *no)
{
    if (no != NULL)
        return pai(no->pai);
    return NULL;
}

No * tio(No *no)
{
    if (no != NULL)
    {
        if (pai(no) == avo(no)->dir)
            return avo(no)->dir;
        else if (pai(no) == avo(no)->esq)
            return avo(no)->esq;
        else
            return NULL;
    }
    return NULL;
}

int corDoNo(No *no)
{
    if (no == NULL)
        return BLACK;
    return no->cor;
}

void rotacaoEsquerda(RB *arv, No *raiz)
{
    No * aux;

    aux = raiz->dir;
    raiz->dir = aux->esq;

    if (aux->esq != NULL)
        aux->esq->pai = raiz;
    aux->pai = raiz->pai;

    if (pai(raiz) == NULL)
        arv->raiz = aux;
    else
        if (raiz == pai(raiz)->esq)
            raiz->pai->esq = aux;
        else
            raiz->pai->dir = aux;
    aux->esq = raiz;
    raiz->pai = aux;
}

void rotacaoDireita(RB *arv, No *raiz)
{
    No *aux;

    aux = raiz->esq;
    raiz->esq = aux->dir;

    if (aux->dir != NULL)
        aux->dir->pai = raiz;
    aux->pai = raiz->pai;

    if (pai(raiz) == NULL)
        arv->raiz = aux;
    else
        if (raiz == pai(raiz)->dir)
            raiz->pai->dir = aux;
        else
            raiz->pai->esq = aux;
    aux->dir = raiz;
    raiz->pai = aux;
}

void fixRB(RB * arv, No *raiz)
{
    No * temp;
    while (corDoNo(pai(raiz)) == RED)
    {
        if (pai(raiz) == avo(raiz)->esq)
        {
            temp = avo(raiz)->dir;

            if (corDoNo(temp) == RED)
            {
                pai(raiz)->cor = BLACK;
                temp->cor = BLACK;
                avo(raiz)->cor = RED;
                raiz = avo(raiz);
            }
            else
            {
                if (raiz == pai(raiz)->dir)
                {
                    raiz = pai(raiz);
                    rotacaoEsquerda(arv, raiz);
                }
                pai(raiz)->cor = BLACK;
                avo(raiz)->cor = RED;
                rotacaoDireita(arv, avo(raiz));
            }
        }
        else
        {
            temp = avo(raiz)->esq;
            if (corDoNo(temp) == RED)
            {
                pai(raiz)->cor = BLACK;
                temp->cor = BLACK;
                avo(raiz)->cor = RED;
                raiz = avo(raiz);
            }
            else
            {
                if (raiz == pai(raiz)->esq)
                {
                    raiz = pai(raiz);
                    rotacaoDireita(arv, raiz);

                }
                pai(raiz)->cor = BLACK;
                avo(raiz)->cor = RED;
                rotacaoEsquerda(arv, avo(raiz));
            }
        }
    }
    arv->raiz->cor = BLACK;
}

//No * inserirNo(RB *arv, No *raiz, int conteudo)
//{
//    if (raiz == NULL)
//    {
//        raiz = criarNo(conteudo);
//    }
//    else
//    {
//        if (conteudo > raiz->info)
//        {
//            raiz->dir = inserirNo(arv, raiz->dir, conteudo);
//            raiz->dir->pai = raiz;
//        }
//        else if (conteudo < raiz->info)
//        {
//            raiz->esq = inserirNo(arv, raiz->esq, conteudo);
//            raiz->esq->pai = raiz;
//        }
//        fixRB(arv, raiz);
//    }
//
//    return raiz;
//}
//
//int inserir(RB *arv, int conteudo)
//{
//    if (arv == NULL)
//        return -1;
//
//    if (arv->raiz == NULL)
//        arv->raiz = criarNo(conteudo);
//    else
//        inserirNo(arv, arv->raiz, conteudo);
//    return 0;
//}

int inserir(RB * arv, int conteudo)
{
    No *no = criarNo(conteudo);
    No *aux, *t;

    aux = arv->raiz;
    t = NULL;

    while (aux != NULL)
    {
        t = aux;

        if (conteudo > aux->info)
            aux = aux->dir;
        else
            aux = aux->esq;
    }

    if (arv->raiz == NULL)
        arv->raiz = no;
    else
    {
        if (conteudo > t->info)
            t->dir = no;
        else
            t->esq = no;
        no->pai = t;
    }
    no->cor = RED;
    fixRB(arv, no);
    return 0;
}

void noOrdem(RB *arv, No *no)
{
    if (no != NULL)
    {
        noOrdem(arv, no->esq);
        printf("%d(%s) ", no->info, (no->cor == RED ? "R":"B"));
        noOrdem(arv, no->dir);
    }
    else
        return;
}

void emOrdem(RB *arv)
{
    noOrdem(arv, arv->raiz);
}

void noPreOrdem(RB *arv, No *no)
{
    if (no != NULL)
    {
        printf("%d(%s) ", no->info, (no->cor == RED ? "R":"B"));
        noPreOrdem(arv, no->esq);
        noPreOrdem(arv, no->dir);
    }
    else
        return;
}

void preOrdem(RB *arv)
{
    noPreOrdem(arv, arv->raiz);
}

void noPosOrdem(RB *arv, No *no)
{
    if (no != NULL)
    {
        noPosOrdem(arv, no->esq);
        noPosOrdem(arv, no->dir);
        printf("%d(%s) ", no->info, (no->cor == RED ? "R":"B"));
    }
    else
        return;
}

void posOrdem(RB *arv)
{
    noPosOrdem(arv, arv->raiz);
}

int alturaNo(No * no)
{
    int ae, ad;

    if (no == NULL)
        return -1;

    ae = alturaNo(no->esq);
    ad = alturaNo(no->dir);

    if (ae > ad)
        return 1 + ae;
    return 1 + ad;
}

int altura(RB * arv)
{
    return alturaNo(arv->raiz);
}
