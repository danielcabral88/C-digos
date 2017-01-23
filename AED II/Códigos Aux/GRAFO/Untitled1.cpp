#include <stdio.h>
#include <stdlib.h>
#include "Grafo.h"

#include <queue>

using namespace std;

typedef struct {

int peso;
int ini;
int fim;
}vet;




Grafo criar(int nv){

Grafo g1 = (Grafo)malloc (sizeof(grafo));
int i,j;
g1->num = nv;
nv++;
 g1->cor = (int*)malloc (sizeof(int)*(nv+1));
g1->m = (int**) malloc(sizeof(int*)*(nv));
g1->com = (int*)malloc (sizeof(int)*(nv+1));
g1->fim = (int*)malloc (sizeof(int)*(nv+1));
    for(i=0;i<nv;i++)
            g1->m[i] = (int*) malloc (sizeof(int)*(nv));

    for(i=0;i<nv;i++){
            for(j=0;j<nv;j++){
                    g1->m[i][j] = 0;}
                        }
return g1;
}

void destroi(Grafo g){

int i;
        for(i=0;i<(g->num+1);i++)
            free(g->m[i]);

       free(g->m);

       free(g);

}


int inserir(Grafo g, int origem,int destino, int peso){

if(origem< 1 || destino <1 )
    return -1;

        if(origem<=g->num  && destino<=g->num){
        g->m[origem][destino] = peso;
        g->m[destino][origem] = peso;
        return 1;}
        else
            return -1;

}

Grafo colorir(Grafo F){
int i;
for(i=0;i<F->num;i++){
    printf("oi");
    F->cor[i] = WHITE;}
return F;
}



int *BuscaEmLargura(Grafo G, int raiz)
{
    int i;
        int b = G->num;
    int *vM = (int*)malloc(b * sizeof(int));//vetor de vertices marcados
    int *lista = (int*)malloc(b * sizeof(int));//vetor de vertices marcados

    int tVM= 0;
    int V;

    G = colorir(G);

    vM[0] = raiz;//marca raiz
    tVM++;
    int sussa;

    G->cor[raiz] = GRAY;

    queue<int> fl;
    fl.push(raiz);
     //poe raiz na fila
    while(fl.size()>0)//enquanto a fila nao esta vazia
    {
        printf("\nbuh aki");
        sussa = 0;
        V = fl.front();//vertice que esta no inicio da fila
         for(i=0;i<G->num;i++)
         {
             if(G->m[V][i] == 1)
             {
                 printf("tah bonito\n");
               lista[sussa] = i;
                 sussa++;
             }

         }
         i=0;
         printf("buh 2");
        while(sussa > i)//enquanto a lista de adjacencia do vertice1 nao acaba
        {
           printf("%d", lista[i]);
            if(G->cor[lista[i]] == WHITE)//busca p->vertice no vetor verticesMarcados
            {
                printf("bosta");
                vM[tVM++] = lista[i];
                fl.push(lista[i]);//poe p->vertice na fila
                G->cor[lista[i]] = GRAY;
                //arestas que compoem arvore geradora mínima, aresta (vertice1, p->vertice)
            }
            i++;
        }
        G->cor[V] = BLACK;

        fl.pop();
    }
    return vM;
}


int dfs2(Grafo G, int i, int c)
{
    int vetor;
    G->com[i] = c++;
    int w;
   for (w = 1; w < G->num; w++)
   {
      if (G->m[i][w] != 0 && G->cor[w] == WHITE){
         G->cor[i] = GRAY;
         c = dfs2( G, w,c);}
   }
   G->cor[i] = BLACK;
   G->fim[i] = c++;
   return c;
}

void DFS(Grafo G){
int i;
int conta = 0;
   G = colorir(G);
   for (i = 1; i < G->num; i++)
  {
   if (G->cor[i] == WHITE){
        G->cor[i] = GRAY;
       conta = dfs2(G,i,conta);
  }
  printf("loucura\n");
  }
}



int Extract(int *vetor, int *pesos,int n){
int i,y=10000,h;
    for(i=0;i<n;i++){
        if(vetor[i] !=-1){
        if(pesos[i]<y){
                y = pesos[i];
                h =i;

        }
    }
    }

    vetor[h] = -1;
return h;
}


int *Prim(Grafo G,int r){
int tam;
int V = G->num+1;
int *vetor = (int*)malloc(sizeof(int)*V);
int *pai = (int*)malloc(sizeof(int)*V);
int *pesos = (int*)malloc(sizeof(int)*V);
int b, i;

for(i=0;i<G->num+1;i++){
    pesos[i] = 10000;
    vetor[i] = i+1;
    pai[i] = i+10;
    tam++;
}
vetor[0] = -1;
pai[r] = 0;
pesos[r] = 0;

while(tam>1){
    printf("lol");
   b = Extract(vetor,pesos,V);

   tam--;
        for(i=0;i<G->num;i++)
         {
             if(G->m[b][i] > 0)
             {
                 if(G->m[b][i] < pesos[i]){
                        if(pai[b] != i){
                 printf("krukru\n");
               pesos[i] = G->m[b][i];
                pai[i] = b;}
                }
             }

         }

for(i=0;i<G->num;i++)
   printf("%d\n", pesos[i]);

}
return pai;
}


void insertionSort(topological V[], int tam)
{
        int i;
        topological aux;

        for(i = 2; i < tam; i++){
                while((i != 0) && (V[i].posi > V[i - 1].posi)) {

                        aux = V[i];
                        V[i] = V[i - 1];
                        V[i - 1] = aux;
                        i--;
                }
        }
}


topological *topologicalsort(Grafo G){

topological *T= (topological*) malloc(sizeof(topological)*G->num);

DFS(G);
int i;

for(i=1;i<G->num;i++){

    T[i].vert = i;
    T[i].posi = G->fim[i];

}

 T[0].vert=  T[i].posi = 0;

insertionSort(T, G->num);

return T;

}
void relax(int *p,int u,int v,int w,int *ant){

if (p[v] > p[u]+w){
    p[v] = p[u]+w;
    ant[u] = v;

}

}

int* Dijkstra(Grafo G){

int tam;
int V = G->num+1;
int *vetor = (int*)malloc(sizeof(int)*V);
int *pai = (int*)malloc(sizeof(int)*V);
int *pesos = (int*)malloc(sizeof(int)*V);
int b, i;

for(i=0;i<G->num+1;i++){
    pesos[i] = 10000;
    vetor[i] = i+1;
    pai[i] = i+10;
    tam++;
}
vetor[0] = -1;
pai[r] = 0;
pesos[r] = 0;

while(tam>1){

   b = Extract(vetor,pesos,V);

   tam--;
        for(i=0;i<G->num;i++)
         {
             if(G->m[b][i] > 0)
             {
                  if(pai[b] != i){
                 relax(pesos,i,b,m[b][i],pai)

                }
             }

         }

for(i=0;i<G->num;i++)
   printf("%d\n", pesos[i]);

}
return pai;
}
