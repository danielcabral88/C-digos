#include<stdio.h>
#include<stdlib.h>
#include "b_tree.h"

No_BTree no_btree_create(BTree arv){
    No_BTree no = (No_BTree) malloc (sizeof(no_btree));
    no->folha = TRUE;
    no->n = 0;
    arv->root = no;
    return no;
}

BTree btree_create(){
    BTree arv = (BTree) malloc (sizeof (btree));
    no_btree_create(arv);
    return arv;
}

void btree_destroy(BTree arv){

}
void split_child(No_BTree no, int i, No_BTree c){
    int j;

    No_BTree z = (No_BTree)malloc(sizeof(no_btree));
    z->folha = c->folha;
    z->n = t - 1;
    for (j = 0 ; j < t - 1; j++){
        z->chave[j] = c->chave[j+t]
    }
    if (c->folha == FALSE){
        for (j=0 ; j < t ; j++){
            z->c[j] = c->c[j+t];
        }
    }
    c->n = t - 1;
    for (j = no->n + 1 ; j > i + 1; j--){
        no->c[j+1] = no->c[j];
    }
    no->c[i+1] = z;
    for (j = no->n ; j > i ; j--){
        no->chave[j+1] = no->chave[j];
    }
    no->chave[i] = c->chave[t];
    no->n++;
}
void insert_non_full(No_BTree no, int k){
    int i = no->n;
    if (no->folha == TRUE){
        while (i >= 1 && k <= no->chave[i]){
            no->chave[i + 1] = no->chave[i];
            i--;
        }
        no->chave[i+1] = k;
        no->n++;
    }
    else{
        while (i >= 1 && k <= no->chave[i]){
            i--;
        }
        i++;
        if (no->c[i]->n == (2*t) - 1 ){
            split_child(no, i, no->c[i]);
            if (k > no->chave[i]){
                i++;
            }
        insert_non_full(no->c[i], k);
        }

    }
}

void btree_insert(BTree arv,int k){
    No_BTree r = (No_BTree) malloc (sizeof(no_btree));
    r = arv->root;
    if (r->n == ((2*t) - 1)){
        No_BTree s = (No_BTree)malloc (sizeof(no_btree));
        arv->root = s;
        s->folha = FALSE;
        s->n = 0;
        s->c[0] = r;
        split_child(s,1,r);
        insert_non_full(s,k);
    }else{
        insert_non_full(r,k);
    }

}
void btree_delete_key (BTree arv, int k){

}
void print_btree(BTree arv){

}

int btree_search(BTree tree, No_BTree * result, int k, int *v){

}
