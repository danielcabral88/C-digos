/** Especificacao da interface do TAD Fila
 *  Prof. Josenildo Silva, 2012
 *  AED I - IFMA, Monte Castelo.
 */
#ifndef _FILA_H_INCLUDED
#define _FILA_H_INCLUDED

// Constantes
#define SUCESSO 1
#define FILACHEIA -1
#define FILAVAZIA -2
#define FILANAOEXISTE -3
#define PARAMETROERRADO -4
#define ERRODEMEMORIA -5

// Estrutura
typedef struct fila Fila;

// Operacoes
/**
 * Cria um nova fila com a capacidade maxima indicada.
 * @param capacidade indica a quantidade maxima que a fila pode armazenar.
 * @return um ponteiro para a fila criada.
 */
Fila * criarFila(int capacidade);

/** Insere um novo elemento na fila. */
int enfileirar(Fila* f, void* e);

/** Remove um elmento da fila. */
int desenfileirar(Fila* f);

/** Informa se a fila está vazia. */
int filaVazia(Fila* f);

/** Informa se a fila já atingiu a capacidade máxima. */
int filaCheia(Fila* f);

/** Desaloca memoria previamente alocada para a fila. */
int liberarFila(Fila *f);

/** Retorna um ponteiro para o primeiro elemento da fila. */
void * primeiroDaFila(Fila * f);

/** Retorna um ponteiro para o ultimo elelemento da fila. */
void * ultimoDaFila(Fila * f);
#endif // _FILA_H_INCLUDED
