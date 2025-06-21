package Queue;

import ArrayList.MyList;

public class Queue<Data> {

    MyList<Data> list;
    private int end=-1;
    public Queue()
    {
        list=new MyList<>();
    }

    public Queue(int size)
    {
        list=new MyList<>(size);
    }
    private boolean isEmpty()
    {
        return end==-1;
    }

    public void enqueue(Data d)
    {
        list.setToBegin();
        list.pushBack(d);
        end++;
    }

    public Data dequeue() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("cant dequeue empty queue");
        }
        list.setToBegin();
        end--;
        return list.erase();

    }
    public int length()
    {
        return end+1;
    }
    public Data frontValue()
    {
        list.setToBegin();
        return list.getValue();
    }

    public Data rearValue()
    {
        list.setToEnd();
        return list.getValue();
    }

    public Data leaveQueue() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("empty queue");
        }
        list.setToEnd();
        end--;
        return list.erase();

    }
    public void clear()
    {
        list=new MyList<>();
        end=-1;
    }

    public String print()
    {
        StringBuffer str=new StringBuffer();
        str.append("< ");
        for(int i=0;i<list.size();i++)
        {
            list.setToPos(i);
            if(i==0)
            {
                str.append("| ");
                str.append(list.getValue()+" ");
            }
            else
            {
                str.append(list.getValue()+" ");
            }
        }
        str.append(">");
        return String.valueOf(str);
    }



}
