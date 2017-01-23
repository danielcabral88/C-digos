#include <time.h>
#include <stdlib.h>
#include <stdio.h>

#define KK 1000000

void Merge(int *array, unsigned int left, unsigned int mid, unsigned int right)
{

        int tempArray[right-left+1];
        int pos=0,lpos = left,rpos = mid + 1;
        while(lpos <= mid && rpos <= right)
        {
                if(array[lpos] < array[rpos])
                {
                        tempArray[pos++] = array[lpos++];
                }
                else
                {
                        tempArray[pos++] = array[rpos++];
                }
        }
        while(lpos <= mid)  tempArray[pos++] = array[lpos++];
        while(rpos <= right)tempArray[pos++] = array[rpos++];
        int iter;

        for(iter = 0;iter < pos; iter++)
        {
                array[iter+left] = tempArray[iter];
        }
        return;
}

void MergeSort(int *array, unsigned int left, unsigned int right)
{
        int mid = (left+right)/2;
       if(left<right)
        {
                MergeSort(array,left,mid);

                MergeSort(array,mid+1,right);

                Merge(array,left,mid,right);
        }
}
void bubble(int v[], int qtd )
{
  int i;
  int j;
  int aux;
  int k = qtd - 1 ;

  for(i = 0; i < qtd; i++)
  {
     for(j = 0; j < k; j++)
     {
        if(v[j] > v[j+1])
        {
            aux = v[j];
        v[j] = v[j+1];
        v[j+1]=aux;
        }
     }
     k--;
  }

}

void Heap(int H[],int n)
{
    int i,j,k,v,heap;
    for(i=n/2;i>=1;i--)
    {
        k=i;
        v=H[k];
        heap=0;
        while(heap==0 && (2*k)<=n)
        {
            j=2*k;
            if(j<n)
            {
                if(H[j]<H[j+1])
                    j++;
            }
            if(v>=H[j])
                heap=1;
            else
            {
                H[k]=H[j];
                k=j;
            }
        }
        H[k]=v;
    }
}

void HeapSort(int H[],int n)
{
    int t,i;
    for(i=n;i>=1;i--)
    {
        Heap(H,i);
        t=H[1];
        H[1]=H[i];
        H[i]=t;
    }
}


void insertionSort(int V[], int tam)
{
        int i, aux;

        for(i = 1; i < tam; i++){
                while((i != 0) && (V[i] < V[i - 1])) {

                        aux = V[i];
                        V[i] = V[i - 1];
                        V[i - 1] = aux;
                        i--;
                }
        }
}

void csort(int array[], const int end,
      const int max, const int min)
{
  int i;
  const int range = max-min+1;
  int count[range+1],
      scratch[end];

  for(i=0; i<range+1; i++)
    count[i] = 0;

  /* Set the value of count[i] to the number of
   * elements in array with value i+min-1. */
  for(i=0; i<end; i++) {
    int c = array[i]+1-min;
    count[c]++;
  }

  /* Update count[i] to be the number of
   * elements with value less than i+min. */
  for(i=1; i<range; i++)
    count[i] += count[i-1];

  /* Copy the elements of array into scratch in
   * stable sorted order. */
  for(i=(end-1); i>=0; i--) {
    int c = array[i]-min;
    int s = count[c];
    scratch[s] = array[i];
    /* Increment count so that the next element
     * with the same value as the current element
     * is placed into its own position in scratch. */
    count[c]++;
  }

  for(i=0; i<end; i++)
    array[i] = scratch[i];

printf("passou!");
}

void swap(int* a, int* b)
{
    int tmp;
    tmp = *a;
    *a = *b;
    *b = tmp;
}

int partition(int vec[], int left, int right)
{
    int i, j;

    i = left;
    for (j = left + 1; j <= right; ++j)
    {
        if (vec[j] > vec[left])
        {
            ++i;
            swap(&vec[i], &vec[j]);
        }
    }
    swap(&vec[left], &vec[i]);

    return i;
}

void quickSort(int vec[], int left, int right)
{
    int r;

    if (right > left)
    {
        r = partition(vec, left, right);
        quickSort(vec, left, r - 1);
        quickSort(vec, r + 1, right);
    }
}


void vetor(int v[],double qtd){

srand(time(NULL));
unsigned int i;
FILE *pp;

    printf("\n\n Arquivo Criado com Sucesso\n\n");

   pp = fopen("mediocaso.txt", "w");


  for(i=0;i<KK;i++){

  v[i] = 1 + ( rand() % 10000 );
  fprintf(pp,"%d\n",v[i]);
  }


        fclose(pp);

  }


  void ler(unsigned int x, char ch[], int arq[]){

  FILE *fp;
  int i;
  fp = fopen(ch, "r+");

  for(i=0;i<x;i++){
  fscanf(fp,"%d",&arq[i]);


  }


  fclose(fp);

  }

  void liberar(int* x, int* y, int *z){
  free(x);
  x = NULL;

  free(y);
  y = NULL;

  free(z);
  z = NULL;
  }
  void geralquick(){
    int ha = 10;
    int ha1 = 100;
    int ha2 = 1000;
    int ha3 = 10000;
    int ha4 = 100000;
    unsigned int ha5 = 1000000;

 printf("rodando1\n");
    int t1[ha]; // (int*) malloc(ha*sizeof(int));
  ler(ha,"mediocaso.txt",t1);
        quickSort(t1,0,ha);
    int tm1[ha]; // (int*) malloc(ha*sizeof(int));
  ler(ha,"melhorcaso.txt",tm1);
        quickSort(tm1,0,ha);
    int tP1[ha]; // (int*) malloc(ha*sizeof(int));
  ler(ha,"piorcaso.txt",tP1);
        quickSort(tP1,0,ha);
 //liberar(t1,tm1,tP1);

 printf("rodando1\n");
    int t2[ha1]; // (int*) malloc(ha1*sizeof(int));
  ler(ha1,"mediocaso.txt",t2);
        quickSort(t2,0,ha1);
    int tm2[ha1]; // (int*) malloc(ha1*sizeof(int));
  ler(ha1,"melhorcaso.txt",tm2);
        quickSort(tm2,0,ha1);
    int tP2[ha1]; // (int*) malloc(ha1*sizeof(int));
  ler(ha1,"piorcaso.txt",tP2);
        quickSort(tP2,0,ha1);
liberar(t2,tm2,tP2);

 printf("rodando1\n");
    int t3[ha2]; // (int*) malloc(ha2*sizeof(int));
  ler(ha2,"mediocaso.txt",t3);
        quickSort(t3,0,ha2);
    int tm3[ha2]; // (int*) malloc(ha2*sizeof(int));
  ler(ha2,"melhorcaso.txt",tm3);
        quickSort(tm3,0,ha2);
    int tP3[ha2]; // (int*) malloc(ha2*sizeof(int));
  ler(ha2,"piorcaso.txt",tP3);
        quickSort(tP3,0,ha2);
    //liberar(t3,tm3,tP3);

 printf("rodando3\n");


    int t4[ha3]; // (int*) malloc(ha3*sizeof(int));
  ler(ha3,"mediocaso.txt",t4);
        quickSort(t4,0,ha3-1);
        printf("buh");
    int tm4[ha3]; // (int*) malloc(ha3*sizeof(int));
  ler(ha3,"melhorcaso.txt",tm4);
        quickSort(tm4,0,ha3-1);
        printf("buh");
    int tP4[ha3]; // (int*) malloc(ha3*sizeof(int));
  ler(ha3,"piorcaso.txt",tP4);
        quickSort(tP4,0,ha3-1);
   // liberar(t4,tm4,tP4);


 printf("rodando4\n");
    int t5[ha4]; // (int*) malloc(ha4*sizeof(int));
  ler(ha4,"mediocaso.txt",t5);
        quickSort(t5,0,ha4);
    int tm5[ha4]; // (int*) malloc(ha4*sizeof(int));
  ler(ha4,"melhorcaso.txt",tm5);
        quickSort(tm5,0,ha4);
        printf("kka.");
    int tP5[ha4]; // (int*) malloc(ha4*sizeof(int));
 // ler(ha4,"piorcaso.txt",tP5);
   //     quickSort(tP5,0,ha4);
    //    liberar(t5,tm5,tP5);
/*
 printf("rodando5\n");
 int *t6 = (int*) malloc(ha5*sizeof(int));
  ler(ha5,"mediocaso.txt",t6);
        quickSort(t6,0,ha5);
    printf("rodando6\n");
    int *tm6 = (int*) malloc(ha5*sizeof(int));
  ler(ha5,"melhorcaso.txt",tm6);
   printf("rodando6\n");
        quickSort(tm6,0,ha5);
    int *tP6 = (int*) malloc(ha5*sizeof(int));
  ler(ha5,"piorcaso.txt",tP6);
        quickSort(tP6,0,ha5);
 printf("rodando6\n");



    liberar(t6,tm6,tP6);
    printf("rodando1\n");
*/

printf("buh quick");
  }

void geralmerge(){
    int a = 10;
    int a1 = 100;
    int a2 = 1000;
    int a3 = 10000;
    int a4 = 100000;
    unsigned int a5 = 1000000;


    int b1[a]; //(int*) malloc(a*sizeof(int));
  ler(a,"mediocaso.txt",b1);
        MergeSort(b1,0,a-1);
    int bm1[a]; //(int*) malloc(a*sizeof(int));
  ler(a,"melhorcaso.txt",bm1);
        MergeSort(bm1,0,a-1);
    int bP1[a];  //(int*) malloc(a*sizeof(int));
  ler(a,"piorcaso.txt",bP1);
        MergeSort(bP1,0,a-1);
   //liberar(b1,bm1,bP1);

   printf("buh");
    int b2[a1];// (int*) malloc(a1*sizeof(int));
  ler(a1,"mediocaso.txt",b2);
        MergeSort(b2,0,a1-1);
    int bm2[a1]; // (int*) malloc(a1*sizeof(int));
  ler(a1,"melhorcaso.txt",bm2);
        MergeSort(bm2,0,a1-1);
    int bP2[a1]; //(int*) malloc(a1*sizeof(int));
  ler(a1,"piorcaso.txt",bP2);
        MergeSort(bP2,0,a1-1);
//liberar(b2,bm2,bP2);
printf("\nbuh 1");
    int b3[a2]; // (int*) malloc(a2*sizeof(int));
  ler(a2,"mediocaso.txt",b3);
        MergeSort(b3,0,a2-1);
    int bm3[a2]; // (int*) malloc(a2*sizeof(int));
  ler(a2,"melhorcaso.txt",bm3);
        MergeSort(bm3,0,a2-1);
    int bP3[a2]; //(int*) malloc(a2*sizeof(int));
  ler(a2,"piorcaso.txt",bP3);
        MergeSort(bP3,0,a2-1);

   // liberar(b3,bm3,bP3);

printf("\nbuh 2");

    int b4[a3]; //= (int*) malloc(a3*sizeof(int));
  ler(a3,"mediocaso.txt",b4);
        MergeSort(b4,0,a3-1);
    int bm4[a3]; //= (int*) malloc(a3*sizeof(int));
  ler(a3,"melhorcaso.txt",bm4);
        MergeSort(bm4,0,a3-1);
    int bP4[a3]; //= (int*) malloc(a3*sizeof(int));
  ler(a3,"piorcaso.txt",bP4);
        MergeSort(bP4,0,a3-1);
   // liberar(b4,bm4,bP4);

printf("\nbuh 3");
    int b5[a4]; // (int*) malloc(a4*sizeof(int));
  ler(a4,"mediocaso.txt",b5);
        MergeSort(b5,0,a4-1);
    int bm5[a4]; // = (int*) malloc(a4*sizeof(int));
  ler(a4,"melhorcaso.txt",bm5);
        MergeSort(bm5,0,a4-1);
    int bP5[a4]; //(int*) malloc(a4*sizeof(int));
  ler(a4,"piorcaso.txt",bP5);
        MergeSort(bP5,0,a4-1);
    //liberar(b5,bm5,bP5);


printf("\nbuh");
/*       int *b6 = (int*) malloc(a5*sizeof(int));
  ler(a5,"mediocaso.txt",b6);
        MergeSort(b6,0,a5-1);
        printf("buh\n");
    int *bm6 = (int*) malloc(a5*sizeof(int));
  ler(a5,"melhorcaso.txt",bm6);
        MergeSort(bm6,0,a5-1);
        printf("buh\n");
    int *bP6 = (int*) malloc(a5*sizeof(int));
  ler(a5,"piorcaso.txt",bP6);
        MergeSort(bP6,0,a5-1);
        printf("buh\n");
    liberar(b6,bm6,bP6);


*/
printf("\nbuh merge");

  }



void geralbubble(){
    int ra = 10;
    int ra1 = 100;
    int ra2 = 1000;
    int ra3 = 10000;
    int ra4 = 100000;
    unsigned int ra5 = 1000000;


    int c1[ra]; // (int*) malloc(ra*sizeof(int));
  ler(ra,"mediocaso.txt",c1);
        bubble(c1,ra);
    int cm1[ra]; // (int*) malloc(ra*sizeof(int));
  ler(ra,"melhorcaso.txt",cm1);
        bubble(cm1,ra);
    int cP1[ra]; // (int*) malloc(ra*sizeof(int));
  ler(ra,"piorcaso.txt",cP1);
        bubble(cP1,ra);
   //liberar(c1,cm1,cP1);

   printf("buh");
    int c2[ra1]; // (int*) malloc(ra1*sizeof(int));
  ler(ra1,"mediocaso.txt",c2);
        bubble(c2,ra1);
    int cm2[ra1]; // (int*) malloc(ra1*sizeof(int));
  ler(ra1,"melhorcaso.txt",cm2);
         bubble(cm2,ra1);
    int cP2[ra1]; // (int*) malloc(ra1*sizeof(int));
  ler(ra1,"piorcaso.txt",cP2);
         bubble(cP2,ra1);
//liberar(c2,cm2,cP2);
printf("\nbuh");
    int c3[ra2]; // (int*) malloc(ra2*sizeof(int));
  ler(ra2,"mediocaso.txt",c3);
         bubble(c3,ra2);
    int cm3[ra2]; // (int*) malloc(ra2*sizeof(int));
  ler(ra2,"melhorcaso.txt",cm3);
         bubble(cm3,ra2);
    int cP3[ra2]; // (int*) malloc(ra2*sizeof(int));
  ler(ra2,"piorcaso.txt",cP3);
         bubble(cP3,ra2);

    //liberar(c3,cm3,cP3);

printf("\nbuh");

    int c4[ra3]; // (int*) malloc(ra3*sizeof(int));
  ler(ra3,"mediocaso.txt",c4);
         bubble(c4,ra3);
    int cm4[ra3]; // (int*) malloc(ra3*sizeof(int));
  ler(ra3,"melhorcaso.txt",cm4);
         bubble(cm4,ra3);
    int cP4[ra3]; // (int*) malloc(ra3*sizeof(int));
  ler(ra3,"piorcaso.txt",cP4);
         bubble(cP4,ra3);
    //liberar(c4,cm4,cP4);

printf("\nbuh");
    int c5[ra4]; // (int*) malloc(ra4*sizeof(int));
  ler(ra4,"mediocaso.txt",c5);
         bubble(c5,ra4);
    int cm5[ra4]; // (int*) malloc(ra4*sizeof(int));
  ler(ra4,"melhorcaso.txt",cm5);
         bubble(cm5,ra4);
    int cP5[ra4]; // (int*) malloc(ra4*sizeof(int));
  ler(ra4,"piorcaso.txt",cP5);
         bubble(cP5,ra4);
    //liberar(c5,cm5,cP5);

/*
printf("\nbuh");
       int *c6 = (int*) malloc(ra5*sizeof(int));
  ler(ra5,"mediocaso.txt",c6);
         bubble(c6,ra5);
        printf("buh 5\n");
    int *cm6 = (int*) malloc(ra5*sizeof(int));
  ler(ra5,"melhorcaso.txt",cm6);
         bubble(cm6,ra5);
        printf("buh\n");
    int *cP6 = (int*) malloc(ra5*sizeof(int));
  ler(ra5,"piorcaso.txt",cP6);
         bubble(cP6,ra5);
        printf("buh\n");
    liberar(c6,cm6,cP6);
*/


printf("\nbuh buble\n");

  }

void geralInsertion(){
    int rba = 10;
    int rba1 = 100;
    int rba2 = 1000;
    int rba3 = 10000;
    int rba4 = 100000;
    unsigned int rba5 = 1000000;


    int e1[rba]; // (int*) malloc(rba*sizeof(int));
  ler(rba,"mediocaso.txt",e1);
        insertionSort(e1,rba);
    int cem1[rba]; // (int*) malloc(rba*sizeof(int));
  ler(rba,"melhorcaso.txt",cem1);
       insertionSort(cem1,rba);
    int ceP1[rba]; // (int*) malloc(rba*sizeof(int));
  ler(rba,"piorcaso.txt",ceP1);
        insertionSort(ceP1,rba);
   //liberar(e1,cem1,ceP1);

   printf("buh");
    int e2[rba1]; // (int*) malloc(rba1*sizeof(int));
  ler(rba1,"mediocaso.txt",e2);
        insertionSort(e2,rba1);
    int cem2[rba1]; // (int*) malloc(rba1*sizeof(int));
  ler(rba1,"melhorcaso.txt",cem2);
         insertionSort(cem2,rba1);
    int ceP2 [rba1]; // (int*) malloc(rba1*sizeof(int));
  ler(rba1,"piorcaso.txt",ceP2);
         insertionSort(ceP2,rba1);
//liberar(e2,cem2,ceP2);
printf("\nbuh");
    int e3[rba2]; // (int*) malloc(rba2*sizeof(int));
  ler(rba2,"mediocaso.txt",e3);
         insertionSort(e3,rba2);
    int cem3[rba2]; // (int*) malloc(rba2*sizeof(int));
  ler(rba2,"melhorcaso.txt",cem3);
         insertionSort(cem3,rba2);
    int ceP3[rba2]; // (int*) malloc(rba2*sizeof(int));
  ler(rba2,"piorcaso.txt",ceP3);
         insertionSort(ceP3,rba2);

    //liberar(e3,cem3,ceP3);

printf("\nbuh");

    int e4[rba3]; // (int*) malloc(rba3*sizeof(int));
  ler(rba3,"mediocaso.txt",e4);
        insertionSort(e4,rba3);
    int cem4[rba3]; // (int*) malloc(rba3*sizeof(int));
  ler(rba3,"melhorcaso.txt",cem4);
         insertionSort(cem4,rba3);
    int ceP4[rba3]; // (int*) malloc(rba3*sizeof(int));
  ler(rba3,"piorcaso.txt",ceP4);
         insertionSort(ceP4,rba3);
   // liberar(e4,cem4,ceP4);

printf("\nbuh 5");
    int e5[rba4]; // = (int*) malloc(rba4*sizeof(int));
  ler(rba4,"mediocaso.txt",e5);
         insertionSort(e5,rba4);
    int cem5[rba4]; // = (int*) malloc(rba4*sizeof(int));
  ler(rba4,"melhorcaso.txt",cem5);
         insertionSort(cem5,rba4);
    int ceP5[rba4]; // = (int*) malloc(rba4*sizeof(int));
  ler(rba4,"piorcaso.txt",ceP5);
         insertionSort(ceP5,rba4);
    //liberar(e5,cem5,ceP5);


printf("\nbuh 6");/*
       int *e6 = (int*) malloc(rba5*sizeof(int));
  ler(rba5,"mediocaso.txt",e6);
         insertionSort(e6,rba5);
        printf("buh\n");
    int *cem6 = (int*) malloc(rba5*sizeof(int));
  ler(rba5,"melhorcaso.txt",cem6);
         insertionSort(cem6,rba5);
        printf("buh\n");
    int *ceP6 = (int*) malloc(rba5*sizeof(int));
  ler(rba5,"piorcaso.txt",ceP6);
        insertionSort(ceP6,rba5);
        printf("buh\n");
    liberar(e6,cem6,ceP6);


*/
printf("\nbuh in");

  }



void geralCsort(){
    int ba = 10;
    int ba1 = 100;
    int ba2 = 1000;
    int ba3 = 10000;
    int ba4 = 100000;
    unsigned int ba5 = 1000000;


    int k1[ba]; // (int*) malloc(ba*sizeof(int));
  ler(ba,"mediocaso.txt",k1);
    csort(k1,ba,ba3,0);

    int km1[ba]; // (int*) malloc(ba*sizeof(int));
  ler(ba,"melhorcaso.txt",km1);
       csort(km1,ba,ba3,0);
    int kP1[ba]; // (int*) malloc(ba*sizeof(int));
  ler(ba,"piorcaso.txt",kP1);
        csort(kP1,ba,ba3,0);
   //liberar(k1,km1,kP1);

   printf("buh sort1\n");
    int k2[ba1]; // (int*) malloc(ba1*sizeof(int));
  ler(ba1,"mediocaso.txt",k2);
        csort(k2,ba1,ba3,0);
    int km2[ba1]; // (int*) malloc(ba1*sizeof(int));
  ler(ba1,"melhorcaso.txt",km2);
         csort(km2,ba1,ba3,0);
    int kP2[ba1]; // (int*) malloc(ba1*sizeof(int));
  ler(ba1,"piorcaso.txt",kP2);
         csort(kP2,ba1,ba3,0);
//liberar(k2,km2,kP2);
printf("buh sort2\n");
    int k3[ba2]; // (int*) malloc(ba2*sizeof(int));
  ler(ba2,"mediocaso.txt",k3);
         csort(k3,ba2,ba3,0);
    int km3[ba2]; // = (int*) malloc(ba2*sizeof(int));
  ler(ba2,"melhorcaso.txt",km3);
         csort(km3,ba2,ba3,0);
    int kP3[ba2]; // (int*) malloc(ba2*sizeof(int));
  ler(ba2,"piorcaso.txt",kP3);
         csort(kP3,ba2,ba3,0);

    //liberar(k3,km3,kP3);

printf("buh sort3\n");
    int k4[ba3]; // = (int*) malloc(ba3*sizeof(int));
  ler(ba3,"mediocaso.txt",k4);
        csort(k4,ba3,ba3,0);
    int km4[ba3]; // = (int*) malloc(ba3*sizeof(int));
  ler(ba3,"melhorcaso.txt",km4);
         csort(km4,ba3,ba3,0);
    int kP4[ba3]; // = (int*) malloc(ba3*sizeof(int));
  ler(ba3,"piorcaso.txt",kP4);
         csort(kP4,ba3,ba3,0);
    //liberar(k4,km4,kP4);

printf("buh sort4\n");
    int k5[ba4]; // = (int*) malloc(ba4*sizeof(int));
  ler(ba4,"mediocaso.txt",k5);
         csort(k5,ba4,ba3,0);
    int km5[ba4]; // = (int*) malloc(ba4*sizeof(int));
  ler(ba4,"melhorcaso.txt",km5);
         csort(km5,ba4,ba3,0);
    int kP5[ba4]; // = (int*) malloc(ba4*sizeof(int));
  ler(ba4,"piorcaso.txt",kP5);
         csort(kP5,ba4,ba3,0);
    //liberar(k5,km5,kP5);

/*
printf("buh sort5\n");
       int *k6 = (int*) malloc(ba5*sizeof(int));
  ler(ba5,"mediocaso.txt",k6);
         csort(k6,ba5,ba3,0);
        printf("buh\n");
    int *km6 = (int*) malloc(ba5*sizeof(int));
  ler(ba5,"melhorcaso.txt",km6);
         csort(km6,ba5,ba3,0);
        printf("buh\n");
    int *kP6 = (int*) malloc(ba5*sizeof(int));
  ler(ba5,"piorcaso.txt",kP6);
        csort(kP6,ba5,ba3,0);
        printf("buh sort6\n");
    liberar(k6,km6,kP6);
*/


printf("\nbuh csort");

  }


int main(){

//programa beta
geralmerge();
geralquick();
geralCsort();


geralbubble();
geralInsertion();


system("pause");
return 0;


}
