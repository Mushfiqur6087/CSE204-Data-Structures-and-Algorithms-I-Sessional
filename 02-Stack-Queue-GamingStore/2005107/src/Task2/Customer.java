package Task2;

public class Customer {
    private int position;
    private int arrivalTime;
    private int totalPlayTime;
    private int startTime;


    public Customer(int position,int arrivalTime, int totalPlayTime)
    {
        this.position=position;
        this.arrivalTime = arrivalTime;
        this.totalPlayTime = totalPlayTime;
        startTime=arrivalTime;

    }
    public int getPosition() { return position; }

    public int getArrivalTime() {
        return arrivalTime;
    }
    public void startTime(int i)
    {
        startTime=i;
    }

    public int getTotalPlayTime() {
        return totalPlayTime;
    }
    public int endTime()
    {
        return startTime+totalPlayTime;
    }
}

