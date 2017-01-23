#include <stdlib.h>
#include <stdio.h>
#include "fila.h"


 struct fila {
 void **vet;
 int ini, max, fim;
 };

// Operacoes
/**
 * Cria um nova fila com a capacidade maxima indicada.
 * @param capacidade indica a quantidade maxima que a fila pode armazenar.
 * @return um ponteiro para a fila criada.
 */
Fila * criarFila(int capacidade){
Fila *f;

if(capacidade<1) return (PARAMETROERRADO);
f=(Fila*)malloc(sizeof(Fila));

f->vet=(void*)calloc(capacidade,sizeof(void));
f->max=capacidade;
f->ini=0;
f->fim=0;

}

/** Insere um novo elemento na fila. */
int enfileirar(Fila* f, void* e){

if(e==NULL) return(FILANAOEXISTE);
if(filaCheia(f)==1) return(FILACHEIA);
if(f->fim<f->max){
f->vet[f->fim]=e;

}

else{
f->fim=0;
f->vet[f->fim]=e;

}

f->fim++;


}

/** Remove um elmento da fila. */
int desenfileirar(Fila* f){

    if(f==NULL) return (FILANAOEXISTE);
  if(filaVazia(f)) return (FILAVAZIA);
    if(f->vet==NULL) return (FILANAOEXISTE);


    //f->vet[f->ini]=NULL;
    int i;
    for(i=0;i<(f->fim-1);i++)
         f->vet[i] =  f->vet[i+1];


return 0;
}

/** Informa se a fila está vazia. */
int filaVazia(Fila* f){

if(f==NULL) return (FILANAOEXISTE);
    int b = f->fim - f->ini;
    if(b==0)
    return (b);
    else
        return 5;
}

/** Informa se a fila já atingiu a capacidade máxima. */
int filaCheia(Fila* f){

int a= abs(f->fim-f->ini);
a++;
if(a==(f->max))
return (SUCESSO);

return 0;
}

/** Desaloca memoria previamente alocada para a fila. */
int liberarFila(Fila *f){

if(f==NULL) return (FILANAOEXISTE);
free(f->vet);
free(f);

return (SUCESSO);
}

/** Retorna um ponteiro para o primeiro elemento da fila. */
void * primeiroDaFila(Fila * f){

if(filaVazia) return (FILAVAZIA);
return f->vet[f->ini];

}


/** Retorna um ponteiro para o ultimo elelemento da fila. */
void * ultimoDaFila(Fila * f){
return f->vet[f->fim];
}
