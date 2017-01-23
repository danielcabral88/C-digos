#include <stdio.h>
#include <stdlib.h>

Arv criar(inf){

 Arv no = (Arv) malloc(sizeof(arv));
     no->info = inf;
        no->dir = NULL;
        no->esq = NULL;
        no->hb = 0;
        return no;
}

Arv inserir(Arv xp, int inf){

if(n == NULL){

   return criar(inf);

}
else if( n->info > inf  ){
    n->esq = inserir(n->esq,inf);
    if( (altura(n->dir)-altura(n->esq))==-2){
            if(e < n->esq->info)
                n = kdir(n); //kill equipe direita
            else
                n = dkdir(n); //double kill equipe direita
    }
}
else if( n->info < inf  ){
    n->dir = inserir(n->dir,inf);
     if( (altura(n->dir)-altura(n->esq))==2){
            if(e > n->esq->info)
                n = kesq(n); //kill equipe esquerda
            else
                n = dkesq(n); //double kill equipe esquerda
     }

}

return n;
}


int altura ( Arv no ){

if(no->esq == no->dir)
 return 0;

else if(no->esq == NULL)

    return (altura(no->dir) +1);
else if(no->dir == NULL)
    return (altura(no->esq) -1);


}


Arv kdir(Arv r){

Arv p = r;
Arv q = p->esq;
p->esq = p->dir;
q->dir = p;
p = q;
return p;
}

Arv kesq(Arv r){

Arv p = r;
Arv q = p->dir;
p->dir = p->esq;
q->esq = p;
p = q;
return p;
}

Arv dkdir(Arv r){

r->esq = kesq(r->esq);
return kdir(r);

}

Arv dkesq(Arv r){

r->dir = kdir(r->dir);
return kesq(r);

}
