#include <stdio.h>
#include <stdlib.h>
#include "RBT.h"

int main()
{

   RB x = NULL;
x = inserir(x, 10);
x = inserir(x,20);
x = inserir(x,5);
x = inserir(x,3);
x = inserir (x,2);
x = inserir (x,1);
printf("\n\n coco  %d", x->info);

   ArvoreEmOrdem(x);

}
