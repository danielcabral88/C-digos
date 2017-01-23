#ifndef RBT_H_INCLUDED
#define RBT_H_INCLUDED

#define BLACK 1
#define RED 0



typedef struct rbtNode{
int info;
int cor;
struct rbtNode *esq;
struct rbtNode *dir;
struct rbtNode *pai;
}rb;


typedef rb* RB;
RB Nil(RB feeh);
void dirRot(RB root,RB x);
void esqRot(RB root,RB y);
void InsertFix(RB root,RB z);
RB inserir(RB root, int feeh);
RB Min(RB feeh);
RB Max(RB feeh);
RB pesquisar(RB root, int feeh);
RB deletar(RB root, int feeh);
void ArvorePreOrdem(RB root);
void ArvorePosOrdem(RB root);

void ArvoreEmOrdem(RB root);

#endif // RBT_H_INCLUDED
