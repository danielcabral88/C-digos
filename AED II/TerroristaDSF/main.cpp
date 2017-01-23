#include "Grafo.h"
#include "Grafo.c"

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <tchar.h>

using namespace std;

int main()
{
	int i;
	Grafo g;
	int v, a, x, y, origem;

	do
	{
		scanf("%d %d", &v, &a);
		if (v > 0 && a > 0) // testa a condição de parada
		{
			if ((v >= 1 && v <= 100) || (a >= 1 && a <= 50)) //testa as restrições de vertices e arestas
			{
				scanf("%d", &origem);

				if (origem >= 1 && origem <= v) // testa o valor da origem
				{
					g = criarGrafo(v,a,2);

					for (i = 1; i <= v; i++)
					{
						g->vertices[i] = criarVertice(i, i);
					}

					for (i = 0 ; i < a ; i++)
					{
						scanf("%d %d", &x, &y);
						if ((x >= 1 && x <= v) && (y >= 1 && y <= v)) // teste se o valor das vertices estão dentro dos limites
						{
							inserirAresta(g, x, y, 1);
						}
						else // condição de parada
						{
							v = 0;
							a = 0;
						}
					}

					dfs(g, origem);

					system("pause");
					system("cls");
				}
				else // condição de parada
				{
						v = 0;
						a = 0;
				}
			}
			else // condição de parada
			{
				v = 0;
				a = 0;
			}
		}

	} while ((v != 0) && (a != 0));
}
