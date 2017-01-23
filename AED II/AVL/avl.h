#ifndef AVL_H_INCLUDED
#define AVL_H_INCLUDED

typedef struct no No;
typedef struct arvore AVL;

///Ponteiro para função visita = imprimir
typedef void f_visitar(int elemento, int fator);

/**
criarArvore: cria e retorna uma nova árvore AVL
**/
AVL * criarArvore();

/**
inserir: insere um novo elemento na árvore
**/
int inserir(AVL *arv, int conteudo);

/**
remover: retira um elemento da árvore
**/
int remover(AVL *arv, int conteudo);

/**
emOrdem: percorre a árvore de forma infixa
(sub-árvore esquerda, centro, sub-árvore direita)
**/
void emOrdem(AVL *arv);

/**
preOrdem: percorre a árvore de forma prefixa
(centro, sub-árvore esquerda, sub-árvore direita)
**/
void preOrdem(AVL *arv);

/**
posOrdem: percorre a árvore de forma pós-fixa
(sub-árvore esquerda, sub-árvore direita, centro)
**/
void posOrdem(AVL *arv);

/**
altura: retorna a altura de uma árvore *arv
**/
int altura(AVL *arv);

#endif // AVL_H_INCLUDED
