#ifndef RED_BLACK_H_INCLUDED
#define RED_BLACK_H_INCLUDED

typedef struct no No;

typedef struct arvore RB;

typedef void f_visitar(int conteudo);

RB * criarArvore();

int inserir(RB *arv, int conteudo);

int altura(RB *arv);

int noAvo(RB *arv, int conteudo);

int noTio(RB *arv, int conteudo);

void emOrdem(RB *arv);

void preOrdem(RB *arv);

void posOrdem(RB *arv);

#endif // RED_BLACK_H_INCLUDED
