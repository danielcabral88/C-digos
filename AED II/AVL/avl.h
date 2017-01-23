#ifndef AVL_H_INCLUDED
#define AVL_H_INCLUDED

typedef struct no No;
typedef struct arvore AVL;

///Ponteiro para fun��o visita = imprimir
typedef void f_visitar(int elemento, int fator);

/**
criarArvore: cria e retorna uma nova �rvore AVL
**/
AVL * criarArvore();

/**
inserir: insere um novo elemento na �rvore
**/
int inserir(AVL *arv, int conteudo);

/**
remover: retira um elemento da �rvore
**/
int remover(AVL *arv, int conteudo);

/**
emOrdem: percorre a �rvore de forma infixa
(sub-�rvore esquerda, centro, sub-�rvore direita)
**/
void emOrdem(AVL *arv);

/**
preOrdem: percorre a �rvore de forma prefixa
(centro, sub-�rvore esquerda, sub-�rvore direita)
**/
void preOrdem(AVL *arv);

/**
posOrdem: percorre a �rvore de forma p�s-fixa
(sub-�rvore esquerda, sub-�rvore direita, centro)
**/
void posOrdem(AVL *arv);

/**
altura: retorna a altura de uma �rvore *arv
**/
int altura(AVL *arv);

#endif // AVL_H_INCLUDED
