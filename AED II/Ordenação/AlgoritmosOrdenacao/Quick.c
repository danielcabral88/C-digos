#include <stdio.h>
#include <stdlib.h>

void permutar(int lista[], int d, int c)
{
    int aux;
    aux = lista[d];
    lista[d] = lista[c];
    lista[c] = aux;
}

int dividir(int lista[], int esq, int dir, int pivo)
{
    int pos, j;

    permutar(lista, pivo, dir);
    pos = esq;

    for (j = esq; j < dir; ++j)
    {
        if (lista[j] < lista[dir])
        {
            ++pos;
            permutar(lista, j, pos);
        }
    }
    permutar(lista, dir, pos);
    return pos;
}

void quickSort(int lista[], int esq, int dir)
{
    int i, pivo;

    if (esq < dir)
    {
        pivo = (esq + dir) / 2;
        i = dividir(lista, esq, dir, pivo);
        quickSort(lista, esq, i - 1);
        quickSort(lista, i + 1, dir);
    }
}
