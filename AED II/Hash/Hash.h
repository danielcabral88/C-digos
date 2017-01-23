#include <stdio.h>
#include <stdlib.h>

using namespace std;

typedef char *string;

typedef struct {
   str chave;
   int    ocorrencias;
} tipoObjeto;

typedef struct STnode *link;

struct STnode {
   tipoObjeto obj;
   link next;
};


int funcaohash(string v, int M);
void STinit();
void STinsert(tipoObjeto obj);
tipoObjeto STsearch(string v);

