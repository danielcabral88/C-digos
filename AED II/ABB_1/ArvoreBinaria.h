
#ifndef _ABB_H
#define _ABB_H

//-----------------------------------------------------------------------------
// TIPOS
//-----------------------------------------------------------------------------

// tipo base

typedef struct no No;

typedef struct arvBinariaDeBusca ABB;

// tipos para operacoes auxiliares
typedef void f_visitar(int elemento); // implementado pelo TAD do item a ser utilizado na árvore


//----------------------------------------------------------------------------
//  OPERACOES
//-----------------------------------------------------------------------------

	ABB * criar();

	int inserir(ABB* arv, int conteudo);

	int contem(ABB* arv, int conteudo);

	int infoRaiz(ABB* arv);

	int maximo (ABB *a);

	int minimo (ABB *a);

	int remover (ABB * arv , int conteudo);

	int comparaArvores(ABB* arv1, ABB* arv2);

	void emOrdem(ABB* arv);

	void posOrdem(ABB* arv);

	void preOrdem(ABB* arv);

	void liberarArvore(ABB* arv);

#endif
