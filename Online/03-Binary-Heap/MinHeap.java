package MinHeap;
import java.util.Arrays;

public class MinHeap
{
    int [] heapArray ;
    int currentSize;
    int maxSize;

    private void increaseSize() throws RuntimeException {
        heapArray = Arrays.copyOf(heapArray, heapArray.length * 3);
    }

    public MinHeap(int size)
    {
        heapArray = new int[size];
        maxSize = size;
        currentSize = 0;
    }


    private int parent(int i)
    {
        return (i - 1) / 2;
    }

    public void insert(int key)
    {
         if(currentSize==maxSize)
         {
             increaseSize();
         }
         currentSize++;
         int i = currentSize-1;
         heapArray[i]=key;
         while (i != 0 && heapArray[parent(i)] > heapArray[i])
         {
             heapArray[i] = heapArray[i] ^ heapArray[parent(i)] ^ ( heapArray[parent(i)] = heapArray[i]);
             i = parent(i);
         }
    }

    public void insertMaxHeap(int key)
    {
        if(currentSize==maxSize)
        {
            increaseSize();
        }
        currentSize++;
        int i = currentSize-1;
        heapArray[i]=key;
        while (i != 0 && heapArray[parent(i)] < heapArray[i])
        {
            heapArray[i] = heapArray[i] ^ heapArray[parent(i)] ^ ( heapArray[parent(i)] = heapArray[i]);
            i = parent(i);
        }
    }

    public int findMin()
    {
        return heapArray[0];
    }
    private void minHeapify (int i)
    {
        int l = 2*i+1;
        int r = 2*i+2;
        int smallest = i;
        if (l < currentSize && heapArray[l] > heapArray[i])
            smallest = l;
        if (r < currentSize && heapArray[r] > heapArray[smallest])
            smallest = r;
        if (smallest != i)
        {
            heapArray[i] = heapArray[i] ^ heapArray[smallest] ^ ( heapArray[smallest] = heapArray[i]);
            minHeapify(smallest);
        }
    }






    public void heapSort()
    {

        for (int i = currentSize - 1; i >= 0; i--)
        {
            int temp = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = temp;
            minHeapify(i);
        }
    }


    public int extractMin()
    {
        if (currentSize <= 0)
            return Integer.MAX_VALUE;
        if (currentSize == 1) {
            currentSize--;
            return heapArray[0];
        }
        int root = heapArray[0];
        heapArray[0] = heapArray[currentSize - 1];
        currentSize--;
        minHeapify(0);

        return root;
    }

    public void decreaseKey(int prevKey,int newKey)
    {
        int index=0;
        for(int i=0;i< currentSize;i++)
        {
            if(heapArray[i]==prevKey)
            {
                index=i;
            }
        }
        heapArray[index]=newKey;
        while (index != 0 && heapArray[parent(index)] > heapArray[index])
        {
            heapArray[index] = heapArray[index] ^ heapArray[parent(index)] ^ ( heapArray[parent(index)] = heapArray[index]);
            index = parent(index);
        }

    }

    public String print()
    {
        StringBuilder str = new StringBuilder();
        int x=0;
        for(int i=0;i<currentSize;i++)
        {
            str.append("Level "+i+": ");
            for(int j=0 ; j<Math.pow(2,i) ; j++)
            {

                str.append(heapArray[x]+" ");
                x++;
                if(x==currentSize)
                    break;
            }
            str.append(System.getProperty("line.separator"));
            if(x==currentSize)
                break;
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        MinHeap heap=new MinHeap(10);
        heap.insert(7);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(15);
        heap.heapSort();
        System.out.println(heap.print());

    }
}

