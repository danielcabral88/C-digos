#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "grafo.h"

#define V 18

#define AUTO 1
#define MANUAL 2

#define INICIO 1
#define OPERACOES 2

#define LIMPAR system("cls")

/**
Executa a função 'transpor()' para um grafo 'g'
**/
void transposta(Grafo g);

/**
Exibe as opções de entrada do programa, passando como parâmetro determinada 'seção' de opções.
Retorna a entrada inicial como 'manual' ou 'automática' para criação dos grafos e execução
de suas operações
**/
int menu(int op);

/**
Retorna um valor obtido de forma aleatória entre os valores de mínimo e máximo
passados como parâmetro
**/
int random(int min, int max);

/**
Faz a operação de criação de um grafo (quantidade de vértices e inserção de arestas),
baseada na opção de entrada da função 'menu()'
**/
Grafo inicializarGrafo(Grafo g, int entrada);

/**
Encerra programa atual
**/
int finalizar(Grafo g);

///Variáveis globais, para chamada da função principal

Grafo g, aux;

int main()
{
    srand(time(NULL));

    int op;

    fflush(stdin);

    op = menu(INICIO);

    g = inicializarGrafo(g, op);

    while (op != 0)
    {
        op = menu(OPERACOES);
    }

    return 0;
}

int menu(int secao)
{
    int op;

    char * s = "GRAFENO";
    char * e = "";

    fflush(stdin);

    switch (secao)
    {
        case INICIO:
            LIMPAR;
            fflush(stdin);
            printf("+------------------------------------------------------------------------------+");
            printf("| %*s%*s |", 42, s, 34, e);
            printf("+------------------------------------------------------------------------------+");
            printf("| Tipo de Entrada: %*s|", 60, e);
            printf("| %*s|", 77, e);
            printf("| 1 - Automatica (Random) %*s|", 53, e);
            printf("| 2 - Manual %*s|", 66, e);
            printf("| %*s|", 77, e);
            printf("| 0 - Sair %*s|", 68, e);
            printf("+------------------------------------------------------------------------------+");
            printf(" ->Opcao: ");
            scanf("%d", &op);
            break;
        case OPERACOES:
            while (op != 0)
            {
                LIMPAR;
                fflush(stdin);
                printf("+------------------------------------------------------------------------------+");
                printf("| %*s - OPERACOES %*s |", 36, s, 27, e);
                printf("+------------------------------------------------------------------------------+");
                printf("| 1 - Matriz de Adjacencia %*s|", 52, e);
                printf("| 2 - Busca em Largura %*s|", 56, e);
                printf("| 3 - Busca em Profundidade %*s|", 51, e);
                printf("| 4 - Ordenacao Topologica %*s|", 52, e);
                printf("| 5 - Alg. Kruskal %*s|", 60, e);
                printf("| 6 - Alg. Prim %*s|", 63, e);
                printf("| 7 - Alg. Bellman-Ford %*s|", 55, e);
                printf("| 8 - Alg. Dijkstra %*s|", 59, e);
                printf("| 9 - Transposta do Grafo %*s|", 53, e);
                printf("| 10 - Lista de Arestas %*s|", 55, e);
                printf("| %*s|", 77, e);
                printf("| 0 - Sair %*s|", 68, e);
                printf("+------------------------------------------------------------------------------+");
                printf(" ->Opcao: ");
                scanf("%d", &op);

                if (grafoNulo(g))
                {
                    printf("   \n** Grafo nao encontrado **");
                    return 0;
                }
                else
                {
                    switch (op)
                    {
                        case 1: imprimirGrafo(g);
                            break;
                        case 2: bfs(g, 1);
                            break;
                        case 3: dfs(g, 1);
                            break;
                        case 4: topologicalSort(g, 1);
                            break;
                        case 5: kruskal(g, 1);
                            break;
                        case 6: prim(g, 1);
                            break;
                        case 7: bellmanFord(g, 1);
                            break;
                        case 8: dijkstra(g, 1);
                            break;
                        case 9: transposta(g);
                            break;
                        case 10: percurso(g);
                            break;
                        case 0: finalizar(g);
                            break;
                        default: menu(OPERACOES);
                            break;
                    }
                    printf("\n ");
                    system("pause");
                }
                break;
            }
    }
    return op;
}

Grafo inicializarGrafo(Grafo g, int entrada)
{
    int v, a, d;
    int i, x, y, z;
    char m, n;

    char * e = "";

    if (entrada == MANUAL)
    {
        printf("\n");
        printf(" Numero de Vertices: ");
        scanf("%d", &v);
        printf(" Numero de Arestas: ");
        scanf("%d", &a);
        printf(" Direcao (1-Dir. 2-N. Dir.): ");
        scanf("%d", &d);

        g = criarGrafo(v, a, d);

        for (i = 1; i <= v; i++)
        {
            g->vertices[i] = criarVertice(i + 96, i);
        }

        fflush(stdin);

        printf("\n");
        printf("+------------------------------------------------------------------------------+");
        printf("| Indique as arestas. Entre com os valores na forma 'origem' 'destino' 'peso'. |");
        printf("| Os vertices variam entre '%c' e '%c'. %*s|", 97, v + 96, 41, e);
        printf("+------------------------------------------------------------------------------+");

        for (i = 0; i < a; i++)
        {
            fflush(stdin);
            scanf("%c %c %d", &m, &n, &z);
            inserirAresta(g, m, n, z);
        }
    }
    else
    {
        if (entrada == AUTO)
        {
           g = criarGrafo(random(2, 10), random(1, 7), NAO_DIRECIONADO);
           a = random(1, numVertices(g));

           for (i = 1; i <= numVertices(g); i++)
           {
                g->vertices[i] = criarVertice(i + 96, i);
           }

           for (i = 0; i < a; i++)
           {
               x = random(1, numVertices(g));
               y = random(1, numVertices(g));
               z = random(1, numVertices(g));
               inserirAresta(g, g->vertices[x]->chave, g->vertices[y]->chave, z);
           }
        }
    }
    printf(" \nOperacao concluida.");

    return g;
}

int random(int min, int max)
{
    int n = rand() % (max - min + 1) + min;
    return n;
}

void transposta(Grafo g)
{
    imprimirGrafo(g);
    printf("\n");
    aux = transpor(g);
    imprimirGrafo(aux);
    destroiGrafo(aux);
}

int finalizar(Grafo g)
{
    destroiGrafo(g);
    return TRUE;
}

