#include <stdio.h>
#include <stdlib.h>

void countSort(int lista[], int tam) {

    int i;
    int * aux;
    aux = (int*) malloc(tam * sizeof(int)); // aloca memória para o vetor

    for (i = 0 ; i < tam; i ++){ // inicia com zero
        aux[i] = 0;
    }

    for (i = 0; i < tam; i++){ // conta as ocorrencias
        ++aux[lista[i]];
    }

    int sum = 0;
    for (i = 1; i < tam; i++){ // ordena os indices do vetor auxiliar
        int dum = aux[i];
        aux[i] = sum;
        sum += dum;
    }

    int * order;
    order = (int*) malloc(tam * sizeof(int));

    for (i = 0; i < tam; i++){
        order[aux[lista[i]]] = lista[i];
        aux[lista[i]]++;
    }

    for (i = 0; i < tam; i++){ // retorna o valores ordenados para o vetor lista
        lista[i] = order[i];
    }



}
