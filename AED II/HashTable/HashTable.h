#define tam 10
struct dados
{
  int info;
  struct dados *prox;
};

typedef struct dados Dados;
typedef Dados* Hash[tam];

int funcaoHash(int num);/**/
void inicializaHash(Hash tab); /**/
void insereHash(Hash tab,int num);
void buscaHash(Hash tab, int num);
void imprimeHash(Hash tab);
void removeHash(Hash tab, int num);

void imprimeColisao(Hash tab, int pos);
