#include <stdlib.h>
#include <stdio.h>
#include "arvoreBB.h"

Arvore criaArvore(){
    Arvore a =(Arvore) malloc (sizeof(arvore));
    a->raiz = NULL;
    return a;
}

void destroiNos(No n){
    if(n == NULL){
        return;
    }
    destroiNos(n->esq);
    destroiNos(n->dir);
    free(n);
}

void destroiArvore(Arvore a){
    destroiNos(a->raiz);
}

void insereArvore(Arvore a, int info){
    No y = NULL;
    No x = a->raiz;
    No z = (No)malloc (sizeof(no));
    z->info = info;

        while (x != NULL)
        {
            y = x;
            if (z->info < x->info){
            x = x->esq;
            }else x = x->dir;
        }

    z->pai = y;

    if (y == NULL){
        a->raiz = z;
    }else{
        if (z->info < y->info){
            y->esq = z;
        }else y->dir = z;
    }
}

void emOrdemNo (No n){
    if (n == NULL){
        return;
    }
    emOrdemNo (n->esq);
    printf("%d ",n->info);
    emOrdemNo(n->dir);
}

void emOrdem (Arvore a){
    emOrdemNo(a->raiz);
}
