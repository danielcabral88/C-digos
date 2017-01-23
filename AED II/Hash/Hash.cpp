#include <stdio.h>
#include <stdlib.h>
#define M 1021
#include "Hash.h"

using namespace std;

char stringvazia[1];
stringvazia[0] = '\0';
tipoObjeto objetonulo;
objetonulo.chave = stringvazia;

link tab[M];

// Fun��o de dispers�o: transforma uma chave n�o-vazia v em um
// n�mero no intervalo 0..M-1.
//
int hash(string v, int M) {
   int i, h = v[0];
   for (i = 1; v[i] != '\0'; i++)
      h = (h * 251 + v[i]) % M;
   return h;
}

// Inicializa uma tabela que apontar� as M listas de colis�es.
void STinit() {
   int h;
   for (h = 0; h < M; h++)
      tab[h] = NULL;
}

// Se o objeto obj j� est� na tabela de s�mbolos, a fun��o
// insert incrementa o campo ocorrencias de obj. Sen�o,
// obj � inserido e seu contador � inicializado com 1.
void STinsert(tipoObjeto obj)
{
   string v = obj.chave;
   int h = hash(v, M);
   link t = tab[h];
   for (t = tab[h]; t != NULL; t = t->next)
      if (strcmp(t->obj.chave, v) == 0) break;
   if (t != NULL)
      t->obj.ocorrencias++;
   else {
      obj.ocorrencias = 1;
      link novo = malloc(sizeof (STnode));
      novo->obj = obj;
      novo->next = tab[h];
      tab[h] = novo;
   }
}

// A fun��o search devolve um objeto obj que tenha chave v.
// Se tal objeto n�o existe, a fun��o devolve um objeto cuja
// chave � a string vazia (ou seja, chave[0] == '\0').
//
tipoObjeto STsearch(string v)
{
   link t;
   int h = hash(v, M);
   for (t = tab[h]; t != NULL; t = t->next)
      if (strcmp(t->obj.chave, v) == 0) break;
   if (t != NULL) return t->obj;
   return objetonulo;
}

