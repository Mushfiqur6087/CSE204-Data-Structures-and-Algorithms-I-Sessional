package LRUCache;
import ArrayList.MyList;

public class LRUCache{

    private int size;
    CustomMap<Integer> map=new CustomMap<>();

    private class CustomMap<Data>
    {
        MyList<Data> key=new MyList<Data>();
        MyList<Data> value=new MyList<Data>();
        private boolean contains(Data d)
        {
            if (key.find(d)==-1)
            {
                return false;
            }
             return true;

        }
        private void add(Data k,Data v)
        {
            key.pushBack(k);
            value.pushBack(v);
        }

        private void remove(int index)
        {
            key.setToPos(index);
            value.setToPos(index);
            key.erase();
            value.erase();
            key.setToBegin();
            value.setToBegin();
        }

        private int indexOf(Data d)
        {
            return key.find(d);
        }
        private Data get(int index)
        {
            value.setToPos(index);
            Data t= value.getValue();
            value.setToBegin();
            return t;

        }
        private int size()
        {
            return key.size();
        }

    }

    public LRUCache(int size)
    {
        this.size = size;
    }

    public int get(int key)
    {
        if(map.contains(key))
        {
            int index = map.indexOf(key);
            int value = map.get(index);
            map.remove(index);
            map.add(key,value);
            return value;
        }
        else
        {
            return -1;
        }
    }
    public void put(int key, int value)
    {
        if(map.contains(key)){
            int index = map.indexOf(key);
            map.remove(index);
        }else if(size==map.size()){
            map.remove(0);
        }
        map.add(key,value);
    }
}


