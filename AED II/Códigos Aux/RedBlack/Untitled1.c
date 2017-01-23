#include <stdio.h>
#include <stdlib.h>
#include "RBT.h"

//struct rbtNode* root = NULL;
RB Nil(RB feeh){

RB t = (RB)malloc(sizeof(rb));
t->info = 0;
t->esq = NULL;
t->dir = NULL;
t->pai = feeh;
t->cor = BLACK;

return t;
}

void esqRot(RB root,RB x){
printf("yo");
RB y;
y = x->dir;  //Set y
x->dir = y->esq; // Turn y's left subtree into x's right subtree
if( y->esq != NULL){
    y->esq->pai = x; //Bridge the y's left sublink
}
y->pai = x->pai; //Bridge x's old parent and y's parent
if( x->pai == NULL){
    root = y;
}
else if( x->info == x->pai->esq->info){
    x->pai->esq = y; //Bridge x's old parent's left or right child
}
else x->pai->dir = y;
y->esq = x;
x->pai = y;

return;
}

void dirRot(RB x,RB raiz){
RB y;
printf("yo");

 y = x -> esq;
		 x -> esq = y -> dir;
			 if (y -> dir == NULL) {
					 y -> dir -> pai = x;
			 }
			 y -> pai = x -> pai;
			 if ( ( x -> pai) == NULL ) {
						 raiz = y;
			 }
			 else {
							if ( x == ( x -> pai ) -> esq ) {
								 x -> pai -> esq = y;
							}
							else {
									 x -> pai -> dir = y;
							}
			 }
			 y -> dir = x;
			 x -> pai = y;
/*x = y->esq;
y->esq = x->dir;
if ( x->dir == NULL){
    x->dir->pai = y;
}
x->pai = y->pai;
if( y->pai == NULL){
    root = x;
}
else if((y->pai->esq != NULL) &&(y->info == y->pai->esq->info)){
    y->pai->esq = x;
}
else y->pai->dir = x;
x->dir = y;
y->pai = x;

return;
*/
}


RB avo(RB n)
{
        if ((n != NULL) && (n->pai != NULL))
                return n->pai->pai;
        else
                return NULL;
}


RB tio(RB n)
{

        RB g = avo(n);
         RB x = Nil(g);
        if (g == NULL)
                return x; // Não ter avô significa não ter tio
        if (n->pai == g->esq){
                 if(g->dir == NULL){
                    return x;}
                 else
                    return g->dir;
                 }
        else{

                if(g->dir== NULL)
                    return x;
                else
                    return g->esq;
                 }
}




void InsertFix(RB rbtree, RB no)
{
        RB y;

        while (no->pai->cor == RED)
        {
                if (no->pai == avo(no)->esq)
                {
                        y=tio(no);

                        if (y->cor == RED)
                        {
                                no->pai->cor=BLACK;
                                y->cor=BLACK;
                                avo(no)->cor=RED;
                                no=avo(no);
                        }
                        else
                        {
                                if (no == no->pai->dir)
                                {
                                        no=no->pai;
                                        esqRot(rbtree,no);
                                }

                                no->pai->cor=BLACK;
                                avo(no)->cor=RED;

                                dirRot(rbtree,avo(no));
                        }
                }
                else
                {
                        y=tio(no);

                        if (y->cor == RED)
                        {
                                no->pai->cor=BLACK;
                                y->cor=BLACK;
                                avo(no)->cor=RED;
                                no=avo(no);
                        }
                        else
                        {
                                if (no == no->pai->esq)
                                {
                                        no=no->pai;
                                        dirRot(rbtree,no);
                                }

                                no->pai->cor=BLACK;
                                avo(no)->cor=RED;

                                esqRot(rbtree,avo(no));
                        }

                }
        }
        rbtree->cor=BLACK;

return;
}

RB inserir(RB root, int feeh){
RB z = (RB)malloc(sizeof(rb));
z->info = feeh;
z->esq = NULL;
z->dir = NULL;
z->cor = RED;
RB x = root;
RB y;
printf("buuh");
if ( root == NULL ){
    root = z;
    root->cor = BLACK;
    printf("\nbuhh");
    return root;
}


while ( x != NULL){
    y = x;
    if ( z->info < x->info){
        x = x->esq;
    }
    else
        x = x->dir;
}
z->pai = y;
if ( y == NULL){
    root = z;
}
else if( z->info < y->info ){
    y->esq = z;
}
else y->dir = z;
InsertFix(root,z);


return root;
}


RB min(RB feeh){
if(feeh->esq == NULL)
return feeh;

return min(feeh->esq);

}

RB max(RB feeh){
if(feeh->dir == NULL)
return feeh;

return max(feeh->dir);

}


RB pesquisar(RB root, int feeh){

if(root == NULL){

return NULL;
}

if(feeh< root->info)
    return pesquisar(root->esq, feeh);
else if(feeh > root->info)
    return pesquisar(root->esq, feeh);
else if(feeh == root->info)
    return root;

return NULL;

}



void ArvoreEmOrdem(RB temp){

    if (temp != NULL){
    ArvoreEmOrdem(temp->esq);
    printf(" %d-%d ",temp->info,temp->cor);
   ArvoreEmOrdem(temp->dir);
}
return;
}


void ArvorePreOrdem(RB root){
RB temp = root;
if (temp != NULL){
    printf(" %d-%d ",temp->info,temp->cor);
    ArvorePreOrdem(temp->esq);

   ArvorePreOrdem(temp->dir);
}
return;
}

void ArvorePosOrdem(RB root){
RB temp = root;
if (temp != NULL){
    ArvorePosOrdem(temp->esq);

   ArvorePosOrdem(temp->dir);
   printf(" %d-%d ",temp->info,temp->cor);

}
return;
}
