void MergeSort(int *array, int left, int right)
{
       int mid = (left+right)/2;
       if(left<right)
        {
                MergeSort(array,left,mid);

                MergeSort(array,mid+1,right);

                Merge(array,left,mid,right);
        }
}
void Merge(int *array, int left, int mid, int right)
{

        int tempArray[right-left+1];
        int pos=0,lpos = left,rpos = mid + 1;
        while(lpos <= mid && rpos <= right)
        {
                if(array[lpos] < array[rpos])
                {
                        tempArray[pos++] = array[lpos++];
                }
                else
                {
                        tempArray[pos++] = array[rpos++];
                }
        }
        while(lpos <= mid)  tempArray[pos++] = array[lpos++];
        while(rpos <= right)tempArray[pos++] = array[rpos++];
        int iter;

        for(iter = 0;iter < pos; iter++)
        {
                array[iter+left] = tempArray[iter];
        }
        return;
}

void bubble(int v[], int qtd )
{
  int i;
  int j;
  int aux;
  int k = qtd - 1 ;

  for(i = 0; i < qtd; i++)
  {
     for(j = 0; j < k; j++)
     {
        if(v[j] > v[j+1])
        {
            aux = v[j];
        v[j] = v[j+1];
        v[j+1]=aux;
        }
     }
     k--;
  }

}

void Heap(int H[],int n)
{
    int i,j,k,v,heap;
    for(i=n/2;i>=1;i--)
    {
        k=i;
        v=H[k];
        heap=0;
        while(heap==0 && (2*k)<=n)
        {
            j=2*k;
            if(j<n)
            {
                if(H[j]<H[j+1])
                    j++;
            }
            if(v>=H[j])
                heap=1;
            else
            {
                H[k]=H[j];
                k=j;
            }
        }
        H[k]=v;
    }
}

void HeapSort(int H[],int n)
{
    int t,i;
    for(i=n;i>=1;i--)
    {
        build_Heap(H,i);
        t=H[1];
        H[1]=H[i];
        H[i]=t;
    }
}

void swap(int* a, int* b)
{
    int tmp;
    tmp = *a;
    *a = *b;
    *b = tmp;
}

int partition(int vec[], int left, int right)
{
    int i, j;

    i = left;
    for (j = left + 1; j <= right; ++j)
    {
        if (vec[j] > vec[left])
        {
            ++i;
            swap(&vec[i], &vec[j]);
        }
    }
    swap(&vec[left], &vec[i]);

    return i;
}

void quickSort(int vec[], int left, int right)
{
    int r;

    if (right > left)
    {
        r = partition(vec, left, right);
        quickSort(vec, left, r - 1);
        quickSort(vec, r + 1, right);
    }
}


void main() {
    int A[20], N, Temp, i, j;
    clrscr();
    printf("\n\n\t ENTER THE NUMBER OF TERMS...: ");
    scanf("%d", &N);
    printf("\n\t ENTER THE ELEMENTS OF THE ARRAY...:");
    for(i=0; i=0){
        A[j+1] = A[j];
        j = j-1;
        }
    A[j+1] = Temp;
    printf("\n\tTHE ASCENDING ORDER LIST IS...:\n");
    for(i=0; i<N; i++){

    printf("\n\t\t\t%d", A[i]);
    }
return 0;
}
