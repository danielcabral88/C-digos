#include "arvoreBB.h"
#include <stdio.h>

void main (){

    Arvore a = criaArvore();
    insereArvore(a,6);
    insereArvore(a,3);
    insereArvore(a,8);
    insereArvore(a,2);
    insereArvore(a,4);
    insereArvore(a,9);

    emOrdem(a);

}
