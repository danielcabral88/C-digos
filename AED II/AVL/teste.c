#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "avl.h"

#define MAX_ELE 100

int main()
{
    srand(time(NULL));

    AVL * a = criarArvore();

    int i, n;

    for (i = 0; i < MAX_ELE; i++)
    {
        n = rand()%MAX_ELE+1;
        inserir(a, n);
    }

//    inserir(a, 13);
//    inserir(a, 6);
//    inserir(a, 8);
//    inserir(a, 4);
//    inserir(a, 3);
//    inserir(a, 9);
//    inserir(a, 7);
//    inserir(a, 3);
//    inserir(a, 8);
//    inserir(a, 2);
//
//    remover(a, 8);
//
//    inserir(a, 16);
//    inserir(a, 11);
//    inserir(a, 15);
//    inserir(a, 17);
//    inserir(a, 18);
//    inserir(a, 9);
//    inserir(a, 15);
//    inserir(a, 7);
//    inserir(a, 16);
//    inserir(a, 14);
//    inserir(a, 1);
//
//    inserir(a, 7);
//    inserir(a, 13);
//    inserir(a, 22);
//
//    inserir(a, 3);
//    inserir(a, 42);
//    inserir(a, 45);
//    inserir(a, 23);
//    inserir(a, 69);
//    inserir(a, 66);
//    remover(a, 13);
//
//    printf("Em Ordem: ");
//    emOrdem(a);
//    printf("\n\n");
//
//    printf("Pre Ordem: ");
//    preOrdem(a);
//    printf("\n\n");
//
//    printf("Pos Ordem: ");
//    posOrdem(a);
//    printf("\n\n");

    printf("\nAltura: %d", altura(a));

    return 0;
}
