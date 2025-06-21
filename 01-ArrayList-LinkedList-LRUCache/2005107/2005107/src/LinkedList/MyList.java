package LinkedList;

public class MyList<Data>
{
    private class Node
    {
        private Data value;
        private Node next;
        private Node ()
        {
            this.next=null;
        }

        private Node(Data value)
        {
            this.value = value;
        }

        private Node(Data value, Node next)
        {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node currentPosition;
    public MyList()
    {
        head=null;
        currentPosition=null;
    }
    public MyList(Data[] arr, int size)
    {
        head=null;
        int initial=0;
        for(int i=0;i<size;i++)
        {
            pushBack(arr[i]);
        }
        Node n=head;
        while(n.next!=null)
        {
            if(initial==size/2)
            {
                currentPosition=n;
            }
            initial++;
            n=n.next;

        }
    }

    public int size()
    {
        int size=0;
        Node temp = head;
        while (temp != null)
        {
            size++;
            temp = temp.next;
        }
        return size;
    }
    public void push(Data d)
    {
        if(head==null)
        {
            Node node=new Node(d,null);
            head=node;
            currentPosition=node;
        }
        else if (currentPosition==head && head!=null)
        {
            Node n=new Node(d,currentPosition);
            currentPosition=n;
            head=n;
        }
        else
        {
            Node node = head;

            while (node.next != currentPosition) {
                node = node.next;
            }
            Node n = new Node(d, currentPosition);
            currentPosition = n;
            node.next = n;
        }
    }

    public void pushBack(Data d)
    {
        if(head==null)
        {
            Node n=new Node(d,null);
            head=n;
            currentPosition=n;
        }
        else
        {
            Node node = head;
            while (node.next!= null)
            {
                node = node.next;
            }
            Node n = new Node(d, null);
            node.next = n;
        }

    }

    public Data erase()
    {
        Data x=currentPosition.value;
        if(head==currentPosition)
        {
            head=currentPosition.next;
            currentPosition=currentPosition.next;
        }
        else
        {
            Node node = head;
            while (node.next != currentPosition) {
                node = node.next;
            }
            node.next = currentPosition.next;
            currentPosition = currentPosition.next;
        }
        return x;
    }
    public void setToBegin()
    {
        currentPosition=head;
    }
    public void setToEnd()
    {
        while(currentPosition.next!=null)
        {
            currentPosition=currentPosition.next;
        }
    }

    public void prev()
    {
        if(currentPosition!=head)
        {
            Node node=head;
            while (node.next!=currentPosition)
            {
                node=node.next;
            }
            node=currentPosition;
        }
    }

    public void next()
    {
        if(currentPosition.next!=null)
        {
                currentPosition=currentPosition.next;
        }
    }

    public int currPos()
    {
        int count=0;
        Node node=head;
        while(node!=currentPosition)
        {
            count++;
            node=node.next;
        }
        return count;

    }
    public void setToPos(int d)
    {
        int size=0;
        Node node=head;
        while (node.next!=null)
        {
            if(d==size)
            {
                currentPosition=node;
                break;
            }
            node=node.next;
            size++;
        }
    }

    public Data getValue()
    {
        return currentPosition.value;
    }


    public int find(Data d)
    {
       int position=0;
        Node node=head;
        while(node!=null)
        {
            if (node.value == d)
            {
                return position;
            }
            position++;
            node=node.next;
        }
        return -1;

    }

    public void clear()
    {
        head=null;
        currentPosition=null;
    }

}

