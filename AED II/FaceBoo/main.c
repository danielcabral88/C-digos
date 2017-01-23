#include "Grafo.h"
#include "Fila.h"

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <tchar.h>

int main()
{
    /** Faceboo **/

	int i, v, a, x, y, aux, aux2;
	Grafo g;

	do
	{
		scanf("%d %d", &v, &a);
		if (v > 0 && a > 0) // testa a condição de parada
		{
			if ((v >= 1 && v <= 50) || (a >= 1 && a <= 250)) //testa as restrições de vertices e arestas
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
                aux = bfsboo(g, 1);
                aux2 = 0;
                for (i = 1; i <= aux; i++)
                {
                    if (i%2 == 0)
                    {
                        aux2 +=1;
                    }
                }

                printf("%0.2f\n", (float) aux2/g->num_vertices);
			}
			else // condição de parada
			{
				v = 0;
				a = 0;
			}
		}
	} while ((v != 0) && (a != 0));
}
