#include <stdio.h>
#include <stdlib.h>
#include "red_black.h"

int main()
{
    RB * a = criarArvore();

    inserir(a, 19);
    inserir(a, 12);
    inserir(a, 20);
    inserir(a, 11);
    inserir(a, 14);
    inserir(a, 13);
    inserir(a, 21);
    inserir(a, 18);
    inserir(a, 10);
    inserir(a, 9);

    printf("Em Ordem: ");
    emOrdem(a);
    printf("\n\n");

    printf("Pos Ordem: ");
    posOrdem(a);
    printf("\n\n");

    printf("Pre Ordem: ");
    preOrdem(a);
    printf("\n\n");

    printf("\nAltura: %d", altura(a));
    return 0;
}
