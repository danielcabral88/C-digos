#include <iostream>
#include <stdio.h>
#include "Graphs.h"

using namespace std;

int main()
{
    int ret;
    //printf("ok");
    Graph g = cria(14);


    ret = inserir(g,0,1,4); //ab
    ret = inserir(g,1,2,8); //bc
    ret = inserir(g,2,3,7); //cd
    ret = inserir(g,3,4,9); //de
    ret = inserir(g,4,5,10); //ef
    ret = inserir(g,5,6,2); // fg
    ret = inserir(g,6,7,1); // gh
    ret = inserir(g,7,8,7); // hi
    ret = inserir(g,0,7,8); // ah
    ret = inserir(g,1,7,11); // ch
    ret = inserir(g,8,6,6); // ig
    ret = inserir(g,8,2,2); // ic
    ret = inserir(g,2,5,4); // cf
    ret = inserir(g,3,5,14); // df

    busca_em_largura(g,0);
    busca_em_profundidade(g);

}
