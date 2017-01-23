#include <stdio.h>
#include <stdlib.h>

void insertionSort(int lista[], int tam) { // escolho o ultimo elemento da lista e comparo com todos os outros elementos até achar a posião em que ele deve estar

   int a, s, chave;

   for (a = 1; a < tam; a++){
      chave = lista[a]; // acho o ultimo valor da lista
      s = a - 1; // salvo a posição anterior
      while ((s>=0) && (chave < lista[s])) { // enquanto a posição anterior for maior que 0 e minha chave for menor que o valor da posição s na lista
         lista[s+1] = lista[s]; // jogo o elemento para frente
         s--; // e decremento s
      } // repito essa operação até encontrar o local correto para minha chave
      lista[s+1] = chave; // insiro a chave na posição correta
   }
}
