package Task2Main;

import Task2.Customer;
import Task2.CustomerList;
import Task2.GamingStoreQueue;

import java.io.*;

public class Task2FileOperations {
    final static String INPUT_FILE_NAME = "Task2Input.txt";
    final static String OUTPUT_FILE_NAME = "Task2Output.txt";

    public static void main(String[] args) throws Exception {
        int totalTime;
        int noOfCustomers;
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        //for queue
        String line=br.readLine();
        String [] output=line.split(" ");
        noOfCustomers=Integer.parseInt(output[0]);
        totalTime=Integer.parseInt(output[1]);
        GamingStoreQueue gQueue=new GamingStoreQueue(totalTime);
        for (int i=0;i<noOfCustomers;i++)
        {
            String line2 = br.readLine();
            String [] output2=line2.split(" ");
            Customer c=new Customer(i+1,Integer.parseInt(output2[0]),Integer.parseInt(output2[1]));
            gQueue.addCustomer(c);
        }
        gQueue.maintainPosition();
        gQueue.sort();
            for (int i = 0; i < noOfCustomers; i++) {
                CustomerList c = gQueue.getValue(i);
                bw.write(String.valueOf(c.getPosition()) + " -> " + c.getDepartedTime());
                bw.write(System.lineSeparator());
            }

        bw.close();
        br.close();

    }


}
