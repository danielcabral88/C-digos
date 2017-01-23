#ifndef AVLTREE_H_INCLUDED
#define AVLTREE_H_INCLUDED


typedef struct arvore {

int info;
struct arvore* dir;
struct arvore* esq;
int h;

}arv;

typedef struct arv* Arv;
void dispose(arv* t);
arv* find( int e, arv *t );
arv* find_min( arv *t );
arv* find_max( arv *t );
arv* insert( int data, arv *t );
arv* delete( int data, arv *t );
void display_avl(arv* t);
int get( arv* n );


#endif // AVLTREE_H_INCLUDED
