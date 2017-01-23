#include <stdlib.h>
#include <stdio.h>
#include "ArvoreBinaria.h"

int main()
{
    ABB * a = criar();

    char *s;

    inserir(a, 20);
    inserir(a, 22);
    inserir(a, 21);
    inserir(a, 2);
    inserir(a, 2);
    inserir(a, 56);
    inserir(a, 12);
    inserir(a, 1);
    inserir(a, 15);
    inserir(a, 13);
    inserir(a, 14);
    inserir(a, 34);
    inserir(a, 0);

    remover(a, 20);

    printf("Pre-Ordem: ");
    preOrdem(a);
    printf("\n\n");
    printf("Em-Ordem: ");
    emOrdem(a);
    printf("\n\n");
    printf("Pos-Ordem: ");
    posOrdem(a);
    printf("\n");

    return 0;
}





