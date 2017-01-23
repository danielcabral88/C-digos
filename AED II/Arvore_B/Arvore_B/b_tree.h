#ifndef B_TREE_H
#define B_TREE_H

#define TRUE 1
#define FALSE 0

#define t 3

#define MAX_c (2*t+1)

#define MAX_key (2*t) // considerando intervalo de 1 a n

typedef struct no_btree_ {
    int n;
    int folha;
    int chave[MAX_key];
    struct no_btree_ * c[MAX_c];
} no_btree;

typedef no_btree * No_BTree;

typedef struct btree_ {
    No_BTree root;
} btree;

typedef btree * BTree;

BTree btree_create();
void btree_destroy(BTree);
void btree_insert(BTree, int);
void btree_delete_key (BTree, int);
void print_btree(BTree);
int btree_search(BTree tree, No_BTree * result, int k, int *v);

#endif // B_TREE_H
