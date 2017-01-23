#include <stdio.h>
#include <stdlib.h>

void merge(int lista[], int tam ) { // divide a lista em duas partes

  int med;
  int a, s, d;
  int * aux;

  aux = (int*) malloc(tam * sizeof(int)); // aloca memoria para sublista
  if (aux == NULL) { // se não tiver espaço sai da função
    exit(1);
  }

  med = tam / 2; // med recebe a metade da lista

  a = 0;
  s = med;
  d = 0;

  while (a < med && s < tam) { // enquanto a for menor que a metade e a metada for menor que o vetor
    if (lista[a] <= lista[s]) { // comprado se o valor do indice a é menor ou igual o valor do indice s
      aux[d] = lista[a++]; // se for menor minha lista auxiliar no indicie d recebe o valor posterior ao do indice a
    }
    else { // caso contrário
      aux[d] = lista[s++]; // lista auxiliar no indice d recebe o valor posterior ao indice s
    }
    d++; // incremento o valor de d
  }

  if (a == med) { // no momente que a for igual a metade da lista subentende-se que a outra metade da lista esteja ordenada
    while (s < tam) {
      aux[d++] = lista[s++];
    }
  }
  else {
    while (a < med) { // a primeira metade da lista já está ordenada então concatena-se esse valor na lista aux
      aux[d++] = lista[a++];
    }
  }
  for (a = 0; a < tam; ++a) { // aux já está ordenada então é só transcrever os valores de aux em lista
    lista[a] = aux[a];
  }
  free(aux); // libera aux e volta na recursão
}

void mergeSort(int lista[], int tam) {

  int med;
  if (tam > 1) {
    med = tam / 2;
    mergeSort(lista, med); // faz um chamada recursiva até dividir toda a primeira metade da lista
    mergeSort(lista + med, tam - med); // faz uma chamada recursiva até dividir toda a segunda metade da lista
    merge(lista, tam); // junta as listas e ordena
  }
}
