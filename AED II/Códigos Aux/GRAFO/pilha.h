/**
 * TAD Pilha (c) 2012 by Josenildo Silva.
 */

#ifndef _PILHA_H
#define _PILHA_H

// Codigos de Erro
#define ERRO_PILHA_CHEIA -1
#define ERRO_PILHA_VAZIA -2
#define ERRO_PILHA_INEXISTENTE -3
#define ERRO_PARAMETRO_ERRADO -4
#define ERRO_DE_MEMORIA -5
#define ERRO_PONTEIRO_NULO -6
#define ERRO_PARAMETRO_NULO -7

// TIPOS
/** Tipo repesentando uma estrutura pilha */
typedef struct pilha Pilha;

/** tipo de função de impressão da pilha */
typedef void f_impr(void* p);

// OPERACOES

/** Cria uma nova pilha com uma capacidade maxima definida
*   @param max indica a capacidade maxima
*/
Pilha* criarPilha(int max);

/** Insere um novo elemento na pilha
*/
int empilhar(Pilha *p, void * e);

/** Remove um elemento da pilha e libera a memória alocada para o elemento.
*/
int desempilhar(Pilha *p);

/** Informa se a pilha está cheia
*/
int pilhaCheia(Pilha *p);

/** Informa se a pilha está vazia
*/
int pilhaVazia(Pilha *p);

/** Retorna um ponteiro para o elemento no topo da pilha
*/
void * topoPilha(Pilha *p);


/**  Faz a impressão dos elementos da pilha.
 *   Recebe um ponteiro para uma pilha e um ponteiro para uma
 *   função de impressão implementada para o tipo específico.
 */
int imprimirPilha(Pilha *p,  f_impr * imprimirItem);

/** Faz uma copia da pilha para outra pilha
*/
Pilha * copiarPilha(Pilha *p);

/** Libera memoria ocupada pela pilha
*/
int liberarPilha(Pilha **p);
#endif
