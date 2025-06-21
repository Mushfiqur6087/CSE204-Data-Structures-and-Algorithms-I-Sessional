package ArrayList;

import java.util.Arrays;

public class MyList<Data>
{
    private int currentPosition;
    private  int DEFAULT_SIZE = 2;
    private Object[] myData ;
    private int size;

    public MyList()
    {
        myData=new Object [DEFAULT_SIZE];
        currentPosition = 0;
        size=0;
    }
    public MyList(Data[] array, int length, int capacity)
    {
        DEFAULT_SIZE=capacity;
        myData=array;
        currentPosition=length/2;
        size=length;
    }

    public int size()
    {
        return size;
    }

    private void increaseSize() throws RuntimeException {
        myData = Arrays.copyOf(myData, myData.length * 2);
    }

    private void decreaseSize() throws RuntimeException {
        myData = Arrays.copyOf(myData, myData.length / 2);
    }
    public void push (Data data)
    {
        if (size == myData.length)
        {
            increaseSize();
        }
        for(int i=size;i>currentPosition;i--)
        {
            myData[i]=myData[i-1];
        }
        myData[currentPosition]=data;
        size++;
    }
    public void pushBack(Data data)
    {
        if (size == myData.length)
        {
            increaseSize();
        }
        myData[size++]=data;

    }

    public Data erase()
    {
        Object ob= myData[currentPosition];
        for(int i=currentPosition;i<size-1;i++)
        {
            myData[i]=myData[i+1];
        }
        myData[size-1]=null;
        size--;
        if (size <= myData.length/2)
        {
            decreaseSize();
        }
        return (Data) ob;

    }

    public void setToBegin()
    {
        currentPosition=0;
    }
    public void setToEnd()
    {
        currentPosition=size-1;
    }
    public void prev()
    {
        if(currentPosition!=0)
        {
            currentPosition--;
        }
    }
    public void next()
    {
        if(currentPosition!=size-1)
        {
            currentPosition++;
        }
    }
    public int currPos()
    {
        return currentPosition;
    }
    public void setToPos(int i)
    {
        currentPosition=i;
    }
    public Data getValue()
    {
        return (Data) myData[currentPosition];
    }
    public int find(Data d)
    {
        for(int i=0;i<size;i++)
        {
            if( myData[i]==d)
            {
                return i;

            }
        }
        return -1;

    }

    public void clear()
    {
        myData=new Object[DEFAULT_SIZE];
        currentPosition=0;
        size=0;
    }

}





