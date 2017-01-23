#include <stdio.h>
#include <stdlib.h>
#include "Grafo.h"

using namespace std;
/*
void add(Grafo bh){

int a,x,i,t,r;
printf("digite o numero de vertices");
scanf("%d", &x);
bh = criar(x);

printf("digite a quantidade de arestas que deseja add:");
scanf("%d",&a);

for(i=0;i<a;i++)
 {


printf("da aresta:");
scanf("%d",&t);

printf("par a aresta:");
scanf("%d",&r);

bh->m[t][r] = 1;
}

}

*/

int main(){
    int i;
    Grafo bh = criar(10);
   int b = inserir(bh,2,1,3);
    printf("%d", b);
    inserir(bh,5,9,7);
    inserir(bh,9,1,4);
    inserir(bh,9,6,6);
    inserir(bh,2,3,5);
    inserir(bh,4,1,4);
    inserir(bh,5,7,8);
    inserir(bh,6,8,2);
    inserir(bh,10,4,6);
    inserir(bh,8,7,5);
    inserir(bh,2,4,3);
    inserir(bh,3,5,2);
    inserir(bh,4,5,10);
    printf("buh\n");
int j;
    for(i=0;i<11;i++){
            for(j=0;j<11;j++)
            printf("%d ", bh->m[i][j]);
    printf("\n");
    }
 /*
 system("cls");
 for(i=1;i<10;i++)
    printf("vertice %d: %d - %d\n",i,bh->com[i], bh->fim[i]);
 */
    topological *vet = (topological*) malloc(sizeof(topological)*11);
   vet = topologicalsort(bh);
    printf("\n\n\n");

printf("algoritmo de topological\n\n");
for(i=1;i<10;i++)
        printf("vertice %d - peso %d\n", vet[i].vert, vet[i].posi);


    destroi(bh);
}
