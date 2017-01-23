#ifndef FILA_H_INCLUDED
#define FILA_H_INCLUDED

#define TRUE 1
#define FALSE 0

typedef struct _no
{
    int info;
    struct _no * prox;
}no;

typedef no * No;

typedef struct
{
    No primeiro;
    No ultimo;
    int quantidade;
}fila;

typedef fila * Fila;

Fila criarFila();

int enqueue(Fila f, int conteudo);

int dequeue(Fila f);

int filaVazia(Fila f);

#endif
