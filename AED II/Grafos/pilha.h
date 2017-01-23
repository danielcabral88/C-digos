#ifndef _PILHA_H
#define _PILHA_H

#include "fila.h"

// Defini��o da estrutura

typedef struct pilha_
{
    No topo;
    int quantidade;
}pilha;

typedef pilha * Pilha;

// Prot�tipos das Fun��es

/** Cria uma nova pilha
*/
Pilha criarPilha();

/** Insere um novo elemento na pilha */
int push(Pilha p, int conteudo);

/** Remove um elemento da pilha */
int pop(Pilha p);

/** Informa se a pilha est� cheia*/
int pilhaCheia(Pilha p);

/** Informa se a pilha est� vazia*/
int pilhaVazia(Pilha p);

/** Retorna um ponteiro para o elemento no topo
da pilha */
void * top(Pilha p);

/** Faz a impress�o dos elementos da pilha.
*   Esta implementa��o � dependente de cada tipo
*/
void imprimirPilha(Pilha p);

/** Faz uma copia da pilha para outra pilha*/
Pilha copiarPilha(Pilha p);

/** Libera memoria ocupada pela pilha */
void destruirPilha(Pilha p);

#endif
