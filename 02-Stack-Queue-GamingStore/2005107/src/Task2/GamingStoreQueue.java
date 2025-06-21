package Task2;

import LinkedList.MyList;
import Queue.Queue;
import Stack.Stack;

public class GamingStoreQueue
{
    MyList<Customer> customerQueue= new MyList<>();
    Queue<Customer> fifaConsole1=new Queue<Customer>();
    Stack<Customer> fifaConsole2=new Stack<Customer>();
    MyList<CustomerList> output=new MyList<CustomerList>();
    private int totalTime;
    public GamingStoreQueue(int totalTime )
    {
        this.totalTime=totalTime;
    }
    public void addCustomer(Customer c)
    {
        customerQueue.pushBack(c);
    }

    public void maintainPosition() throws Exception
    {
        boolean Console1Occupation=false;
        boolean Console2Occupation=false;
        int Console1TotalTime=0;
        int Console2TotalTime=0;
        Customer c;

        for(int i =1;i<totalTime;i++)
        {
                //console1
                if (i == Console1TotalTime)
                {
                    Console1Occupation = false;
                }

                if (Console1Occupation == false)
                {
                    if (fifaConsole1.length() <= 0 && customerQueue.getValue().getArrivalTime() == i)
                    {
                        customerQueue.setToBegin();
                        output.pushBack(new CustomerList(customerQueue.getValue().getPosition(), customerQueue.getValue().endTime()));
                        Console1TotalTime = customerQueue.getValue().endTime();
                        customerQueue.erase();
                        Console1Occupation = true;

                    }
                    if (fifaConsole1.length() > 0 && Console1TotalTime == i)
                    {
                        c = fifaConsole1.dequeue();
                        c.startTime(i);
                        if(c.endTime()<=totalTime)
                        output.pushBack(new CustomerList(c.getPosition(), c.endTime()));
                        else
                            output.pushBack(new CustomerList(c.getPosition(),totalTime));
                        Console1TotalTime = c.endTime();
                        Console1Occupation = true;
                    }
                }
                if(Console1Occupation==true)
                {
                    if(customerQueue.size()!=0)
                    {
                        if (fifaConsole1.length() <= 2 && customerQueue.getValue().getArrivalTime() == i)
                        {
                            fifaConsole1.enqueue(customerQueue.getValue());
                            customerQueue.erase();
                        }
                    }
                }

                //console2

                if (i == Console2TotalTime)
                {
                    Console2Occupation = false;
                }

                if (Console2Occupation == false && (fifaConsole1.length() == 3 || fifaConsole2.length()!=0))
                {
                    if (fifaConsole2.length() <= 0 && customerQueue.getValue().getArrivalTime() == i) {
                        customerQueue.setToBegin();
                        customerQueue.getValue().startTime(i);
                        if(customerQueue.getValue().endTime()<=totalTime)
                        output.pushBack(new CustomerList(customerQueue.getValue().getPosition(), customerQueue.getValue().endTime()));
                        else
                            output.pushBack(new CustomerList(customerQueue.getValue().getPosition(), totalTime));
                        Console2TotalTime = customerQueue.getValue().endTime();
                        customerQueue.erase();
                        Console2Occupation = true;

                    }
                    if (fifaConsole2.length() > 0 && Console2TotalTime == i )//&& fifaConsole1.length() <= 3)
                    {
                        c = fifaConsole2.pop();
                        c.startTime(i);
                        if(c.endTime()<=totalTime)
                        output.pushBack(new CustomerList(c.getPosition(), c.endTime()));
                        else
                            output.pushBack(new CustomerList(c.getPosition(), 60));

                        Console2TotalTime = c.endTime();
                        Console2Occupation = true;
                    }
                }
                if(Console2Occupation == true && fifaConsole1.length() >= 3)
                {
                    if(customerQueue.size()!=0)
                    {
                        if (fifaConsole1.length() == 3 && customerQueue.getValue().getArrivalTime() == i)
                        {
                            fifaConsole2.push(customerQueue.getValue());
                            customerQueue.erase();
                        }
                    }

                }

        }

    }

    public void sort()
    {
        for (int i = 0; i < output.size(); i++)
        {
            for (int j = i + 1; j < output.size(); j++)
            {
                output.setToPos(i);
                output.setToPos(j);
                CustomerList iElement=output.getValue();
                CustomerList jElement=output.getValue();
                if (iElement.getPosition() > jElement.getPosition())
                {
                    output.setToPos(i);
                    output.erase();
                    output.push(jElement);
                    output.setToPos(j);
                    output.erase();
                    output.push(iElement);

                }
            }
        }

    }


    public CustomerList getValue(int i)
    {
        output.setToPos(i);
        return output.getValue();

    }
}





