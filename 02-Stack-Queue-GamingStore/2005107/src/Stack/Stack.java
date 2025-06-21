package Stack;
import ArrayList.MyList;
public class Stack <Data>
{
    MyList<Data> list;
    private int top=-1;
    public Stack()
    {
        list=new MyList<>();
    }

    public Stack(int size)
    {
        list=new MyList<>(size);
    }

    public void push(Data d)
    {
        top++;
        list.pushBack(d);
    }
    private boolean isEmpty()
    {
        return top==-1;
    }

    public Data pop() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("Cannot pop from an empty stack!");
        }
        list.setToPos(top);
        Data remove=list.erase();
        top--;
        return remove;

    }
    public Data topValue() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("Cannot pop from an empty stack!");
        }
        list.setToEnd();
        return list.getValue();
    }
    public void clear()
    {
        list=new MyList<>();
        top=-1;
    }
    public int length()
    {
        return top+1;
    }

    public String print()
    {
        StringBuffer str=new StringBuffer();
        str.append("< ");
        for(int i=0;i<list.size();i++)
        {
            list.setToPos(i);
            if(i==list.size()-1)
            {
                str.append("| ");
                str.append(list.getValue());
            }
            else
            {
                str.append(list.getValue()+" ");
            }
        }
        str.append(" >");
        return String.valueOf(str);
    }

}


