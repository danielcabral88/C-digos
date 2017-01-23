#ifndef FILA_H_INCLUDED
#define FILA_H_INCLUDED

// Constantes
#define TRUE 1
#define FALSE 0

// Estrutura

typedef struct no_
{
    int info;
    struct no_ * prox;
}no;


///Definição do tipo Nó

typedef no * No;

typedef struct
{
    No primeiro;
    No ultimo;
    int quantidade;
}fila;

///Definição do tipo Fila

typedef fila * Fila;

// Operacoes
/**
 * Cria um nova fila com a capacidade maxima indicada.
 * @param capacidade indica a quantidade maxima que a fila pode armazenar.
 * @return um ponteiro para a fila criada.
 */
Fila criarFila();

/** Insere um novo elemento na fila. */
int enqueue(Fila f, int conteudo);

/** Remove um elmento da fila. */
int dequeue(Fila f);

/** Faz a busca de um elemento na fila 'f' */
int buscarNaFila(Fila f, int conteudo);

/** Informa se a fila está vazia. */
int filaVazia(Fila f);

/** Informa se a fila já atingiu a capacidade máxima. */
int filaCheia(Fila f);

/** Desaloca memoria previamente alocada para a fila. */
int liberarFila(Fila f);

/** Retorna um ponteiro para o primeiro elemento da fila. */
void * primeiroDaFila(Fila f);

/** Retorna um ponteiro para o ultimo elelemento da fila. */
void * ultimoDaFila(Fila f);

/** Exibe na tela os elementos armazenados em uma fila f. */
void imprimirFila(Fila f);

#endif // _FILA_H_INCLUDED


//#endif // FILA_H_INCLUDED
