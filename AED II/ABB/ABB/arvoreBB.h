#ifndef ARVOREBB_H
#define ARVOREBB_H

typedef struct no_ {
    int info;
    struct no_ * esq, *dir, *pai;
} no;

typedef no* No;

typedef struct {
    No raiz;
}arvore;

typedef arvore* Arvore;

Arvore criaArvore();

void destroiArvore(Arvore);

void insereArvore(Arvore, int);

void emOrdem (Arvore);


#endif // ARVOREBB_H
