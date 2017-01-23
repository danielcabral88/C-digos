#include <stdio.h>
#include <stdlib.h>
#include "avl.h"

struct no
{
    int info;
    struct no * esq;
    struct no *dir;
    struct no *pai;
    int fb;
};

struct arvore
{
    No * raiz;
};

void visita(int conteudo, int fator)
{
    printf("%d (%d) ", conteudo, fator);
}

AVL * criarArvore()
{
    AVL * a = (AVL*) malloc (sizeof(AVL));

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
    no->pai = NULL;
    no->fb = 0;

    return no;
}

No * pai(No *raiz, No *no)
{
    if (raiz == NULL)
        return NULL;
    if ((raiz->esq == no) || (raiz->dir == no))
        return raiz;
    if (no->info > raiz->info)
        return pai(raiz->dir, no);
    return pai(raiz->esq, no);
}

No * rotacaoDireita(AVL *arv, No *no)
{
    No *aux;

    aux = no->esq;
    no->esq = aux->dir;
    aux->dir = no;
    aux->pai = no->pai;

    if (no->pai == NULL)
        arv->raiz = aux;
    no->pai = aux;

    return aux;
}

No * rotacaoEsquerda(AVL *arv, No *no)
{
    No *aux;

    aux = no->dir;
    no->dir = aux->esq;
    aux->esq = no;
    aux->pai = no->pai;

    if (no->pai == NULL)
        arv->raiz = aux;
    no->pai = aux;

    return aux;
}

No * duplaEsquerda(AVL *arv, No *no)
{
    no->esq = rotacaoEsquerda(arv, no->esq);
    return rotacaoDireita(arv, no);
}

No * duplaDireita(AVL *arv, No *no)
{
    no->dir = rotacaoDireita(arv, no->dir);
    return rotacaoEsquerda(arv, no);
}

int alturaNo(No *no)
{
    int ae, ad;

    if (no == NULL)
        return -1;

    if (no != NULL)
    {
        ae = alturaNo(no->esq);
        ad = alturaNo(no->dir);

        if (ae > ad)
            return 1 + ae;
        else
            return 1 + ad;
    }
    return 0;
}

int fatorBalanco(No *no)
{
    if (no == NULL)
        return 0;
    return (alturaNo(no->dir) - alturaNo(no->esq));
}

int altura(AVL *arv)
{
    return alturaNo(arv->raiz);
}

No * fixAVL(AVL *arv, No *raiz)
{
    if (fatorBalanco(raiz) == 2)
    {
        if (fatorBalanco(raiz->dir) == -1)
            raiz->dir = rotacaoDireita(arv, raiz->dir);
        raiz = rotacaoEsquerda(arv, raiz);
    }
    else if (fatorBalanco(raiz) == -2)
    {
        if (fatorBalanco(raiz->esq) == 1)
            raiz->esq = rotacaoEsquerda(arv, raiz->esq);
        raiz = rotacaoDireita(arv, raiz);
    }
    return raiz;
}

No * inserirNo(AVL *arv, No *raiz, int conteudo)
{
    if (raiz == NULL)
    {
        raiz = criarNo(conteudo);
    }
    else
    {
        if (conteudo > raiz->info)
        {
            raiz->dir = inserirNo(arv, raiz->dir, conteudo);
            raiz->dir->pai = raiz;
            raiz->dir->fb = fatorBalanco(raiz->dir);
        }
        else if (conteudo < raiz->info)
        {
            raiz->esq = inserirNo(arv, raiz->esq, conteudo);
            raiz->esq->pai = raiz;
            raiz->esq->fb = fatorBalanco(raiz->esq);
        }
        raiz = fixAVL(arv, raiz);
    }

    return raiz;
}

int inserir(AVL *arv, int conteudo)
{
    if (arv == NULL)
        return -1;

    if (arv->raiz == NULL)
        arv->raiz = criarNo(conteudo);
    else
        inserirNo(arv, arv->raiz, conteudo);
    return 0;
}

No * noMaior(No * no)
{
    if (no->dir == NULL)
        return no;
    return noMaior(no->dir);
}

No * noMenor(No * no)
{
    if (no->esq == NULL)
        return no;
    return noMenor(no->esq);
}

No * buscarNo(No *no, int conteudo)
{
    if (no != NULL)
    {
        if (conteudo == no->info)
            return no;
        if (conteudo > no->info)
            return buscarNo(no->dir, conteudo);
        else
            return buscarNo(no->esq, conteudo);
    }
    else
        return NULL;
    return no;
}

int removerNo(AVL *arv, No *no, int conteudo)
{
    No * del;

    if (no == NULL)
        return -1;

    if (arv->raiz == no && no->dir == NULL && no->esq == NULL)
    {
        arv->raiz = NULL;
        free(no);
        return 0;
    }

    if (conteudo > no->info)
        removerNo(arv, no->dir, conteudo);
    else
    {
        if (conteudo < no->info)
            removerNo(arv, no->esq, conteudo);
        else
        {
            if (no->dir != NULL && no->esq != NULL)
            {
                del = noMaior(no->esq);
                no->info = del->info;
                removerNo(arv, no->esq, no->info);
            }
            else
            {
                del = no->pai;
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
        no = fixAVL(arv, no);
    }
    return 0;
}

int remover(AVL *arv, int conteudo)
{
    if (arv == NULL)
        return -1;

    return removerNo(arv, arv->raiz, conteudo);
}

void noOrdem(No *no, f_visitar *visita)
{
    if (no != NULL)
    {
        noOrdem(no->esq, visita);
        visita(no->info, no->fb);
        noOrdem(no->dir, visita);
    }
    else
        return;
}

void emOrdem(AVL *arv)
{
    if (arv != NULL)
    {
        noOrdem(arv->raiz, visita);
    }
}

void noPreOrdem(No *no, f_visitar *visita)
{
    if (no != NULL)
    {
        visita(no->info, no->fb);
        noPreOrdem(no->esq, visita);
        noPreOrdem(no->dir, visita);
    }
    else
        return;
}

void preOrdem(AVL *arv)
{
    if (arv != NULL)
    {
        noPreOrdem(arv->raiz, visita);
    }
}

void noPosOrdem(No *no, f_visitar *visita)
{
    if (no != NULL)
    {
        noPosOrdem(no->esq, visita);
        noPosOrdem(no->dir, visita);
        visita(no->info, no->fb);
    }
    else
        return;
}

void posOrdem(AVL *arv)
{
    if (arv != NULL)
    {
        noPosOrdem(arv->raiz, visita);
    }
}
