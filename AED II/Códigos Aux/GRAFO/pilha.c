#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"


struct pilha {
       int n;
       int max;
       void **vet;
       };


// OPERACOES

/** Cria uma nova pilha com uma capacidade maxima definida
*   @param max indica a capacidade maxima
*/
Pilha* criarPilha(int max){

        if(max<=0) return NULL;
       Pilha *p = (Pilha*)malloc(sizeof(Pilha));
       p->n= (-1);
        p->vet = (void**) calloc(max, sizeof(void*));
       p->max = max;
       return p;
}
/** Insere um novo elemento na pilha
*/
int empilhar(Pilha *p, void * e){

    if(e==NULL) return (ERRO_PONTEIRO_NULO);
    if(p==NULL) return (ERRO_PILHA_INEXISTENTE);
   if(!pilhaCheia(p)) return (ERRO_PILHA_CHEIA);
    p->n++;
    p->vet[p->n]=e;

    return 0;

}

/** Remove um elemento da pilha e libera a memória alocada para o elemento.
*/
int desempilhar(Pilha *p){
if (pilhaVazia(p)==1) return(ERRO_PILHA_VAZIA);
if(p==NULL) return (ERRO_PILHA_INEXISTENTE);
/* retira elemento do topo */
p->vet[p->n]==NULL;
p->n--;
return 0;
}

int pilhaCheia(Pilha *p){
    if(p==NULL) return (ERRO_PONTEIRO_NULO);
    if (p->n != (p->max - 1)) return (ERRO_PILHA_VAZIA);
    return 0;
}

/** Informa se a pilha está vazia
*/
int pilhaVazia(Pilha *p){
    if (p==NULL) return (ERRO_PONTEIRO_NULO);
    if (p->n >= 0) return (ERRO_PILHA_CHEIA);
    return 1;
}


/** Retorna um ponteiro para o elemento no topo da pilha
*/
void * topoPilha(Pilha *p){
    if(p==NULL) return NULL;//(ERRO_PILHA_INEXISTENTE);
    if(pilhaVazia(p)==0) return NULL;//(ERRO_PILHA_VAZIA);
return (p->vet[p->n]);
}


/**  Faz a impressão dos elementos da pilha.
 *   Recebe um ponteiro para uma pilha e um ponteiro para uma
 *   função de impre ssão implementada para o tipo específico.
 */
int imprimirPilha(Pilha *p,  f_impr * imprimirItem){

if(p==NULL) return (ERRO_PILHA_INEXISTENTE);
    if(pilhaVazia(p)==0) return (ERRO_PILHA_VAZIA);
int i;
for(i=0;i<p->n;i++)
imprimirItem(p->vet[i]);
return 0;

}



/** Faz uma copia da pilha para outra pilha
*/
Pilha * copiarPilha(Pilha *p){

if(p==NULL) return (ERRO_PILHA_INEXISTENTE);

Pilha* v = criarPilha(p->max);
int i;
for(i=0;i<p->n;i++){
v->vet[i]=p->vet[i];
v->n++;
}

return v;
}

/** Libera memoria ocupada pela pilha
*/
int liberarPilha(Pilha **p){

if((*p) == NULL){
    free(*p);
     return (ERRO_PILHA_INEXISTENTE);}

int i;

if(pilhaVazia(*p)){
int t=(*p)->n;
for(i=0;i<t;i++){
free((*p)->vet[i]);
(*p)->vet[i] = NULL;
}
}

free((*p)->vet);
(*p)->vet = NULL;
free(*p);
*p=NULL;

return 0;

}

