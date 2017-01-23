#ifndef _PILHA_H
#define _PILHA_H

#include "fila.h"

// Definição da estrutura

typedef struct pilha_
{
    No topo;
    int quantidade;
}pilha;

typedef pilha * Pilha;

// Protótipos das Funções

/** Cria uma nova pilha
*/
Pilha criarPilha();

/** Insere um novo elemento na pilha */
int push(Pilha p, int conteudo);

/** Remove um elemento da pilha */
int pop(Pilha p);

/** Informa se a pilha está cheia*/
int pilhaCheia(Pilha p);

/** Informa se a pilha está vazia*/
int pilhaVazia(Pilha p);

/** Retorna um ponteiro para o elemento no topo
da pilha */
void * top(Pilha p);

/** Faz a impressão dos elementos da pilha.
*   Esta implementação é dependente de cada tipo
*/
void imprimirPilha(Pilha p);

/** Faz uma copia da pilha para outra pilha*/
Pilha copiarPilha(Pilha p);

/** Libera memoria ocupada pela pilha */
void destruirPilha(Pilha p);

#endif
