#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    FILE *arq;
    FILE *arqOrd;
    FILE *arqDes;
    int i,j,result, result1, result2;
    arq = fopen("Aleatorio.txt", "wt");  // Cria um arquivo texto para gravação
    arqOrd = fopen("Ordenado.txt","wt");
    arqDes = fopen("Desordenado.txt","wt");

  if (arq == NULL) // Se nào conseguiu criar
  {
     printf("Problemas na CRIACAO do arquivo\n");
     return;
  }
  if (arqOrd == NULL) // Se nào conseguiu criar
  {
     printf("Problemas na CRIACAO do arquivo\n");
     return;
  }
  if (arqDes == NULL) // Se nào conseguiu criar
  {
     printf("Problemas na CRIACAO do arquivo\n");
     return;
  }
    printf("Digite a quantidade de numero a serem geradas: ");
    scanf("%d",&j);

    if(j = malloc((int*) sizeof ((int)1000000)) == NULL){
        printf("Memoria insuficiente!");
    }
    j = 1000000;

    printf("intervalo da rand: [0,%d]\n", RAND_MAX);
    srand( (unsigned)time(NULL) );
    for(i=0 ; i < j ; i++){
        result = fprintf(arq,"%d\n",rand());
        result1 = fprintf(arqOrd,"%d\n",i+1);
        result2 = fprintf(arqDes,"%d\n",j-i);
        result = fprintf(arq,rand());
        printf("Numero %d: %d\n",i, rand());
        if (result == EOF || result1 == EOF || result2 == EOF)
        printf("Erro na Gravacao\n");
    }
    fclose(arq);
    fclose(arqDes);
    fclose(arqOrd);
}
