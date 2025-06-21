package Task1Main;

import Queue.Queue;
import Stack.Stack;

import java.io.*;

public class FileOperations {
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";
    ;

    public static void main(String[] args) throws Exception {
        int initialLength;
        int initialCapacity;
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        //for queue
        String line=br.readLine();
        String [] output=line.split(" ");
        initialLength=Integer.parseInt(output[0]);
        initialCapacity=Integer.parseInt(output[1]);
        String line2 = br.readLine();
        String [] output2=line2.split(" ");
        Queue<Integer>myQueue= new Queue<Integer>(initialCapacity);
        for(int i=0;i<initialLength;i++)
        {
            myQueue.enqueue(Integer.parseInt(output2[i]));
        }

        //for Stack
        String line3=br.readLine();
        String [] output3=line3.split(" ");
        initialLength=Integer.parseInt(output3[0]);
        initialCapacity=Integer.parseInt(output3[1]);
        String line4 = br.readLine();
        String [] output4=line4.split(" ");
        Stack<Integer>myStack= new Stack<Integer>(initialCapacity);
        for(int i=0;i<initialLength;i++)
        {
            myStack.push(Integer.parseInt(output4[i]));
        }


        String l=br.readLine();
        int totalOperations=Integer.parseInt(l);
        bw.write(myQueue.print());
        bw.write(System.lineSeparator());
        bw.write(myStack.print());
        bw.write(System.lineSeparator());

        for(int i=0;i<totalOperations;i++)
        {
            String li=br.readLine();
            String []ou=li.split(" ");
            int choice=Integer.parseInt(ou[0]);
            int parameter=Integer.parseInt(ou[1]);

            if(choice==1)
            {
                myQueue.clear();
                bw.write(myQueue.print());
                bw.write(System.lineSeparator());
                bw.write("-1");
                bw.write(System.lineSeparator());
            }
            if(choice==2)
            {
                myQueue.enqueue(parameter);
                bw.write(myQueue.print());
                bw.write(System.lineSeparator());
                bw.write("-1");
                bw.write(System.lineSeparator());
            }
            if(choice==3)
            {
                int z=myQueue.dequeue();
                bw.write(String.valueOf(myQueue.print()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(z));
                bw.write(System.lineSeparator());
            }
            if(choice==4)
            {
                int z=myQueue.length();
                bw.write(myQueue.print());
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(z));
                bw.write(System.lineSeparator());
            }
            if(choice==5)
            {
                int z=myQueue.frontValue();
                bw.write(String.valueOf(myQueue.print()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(z));
                bw.write(System.lineSeparator());
            }
            if(choice==6)
            {
                int z=myQueue.rearValue();
                bw.write(String.valueOf(myQueue.print()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(z));
                bw.write(System.lineSeparator());
            }
            if(choice==7)
            {
                int z=myQueue.leaveQueue();
                bw.write(String.valueOf(myQueue.print()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(z));
                bw.write(System.lineSeparator());
            }
            if(choice==8)
            {
                myStack.clear();
                bw.write(myStack.print());
                bw.write(System.lineSeparator());
                bw.write("-1");
                bw.write(System.lineSeparator());
            }
            if(choice==9)
            {
                myStack.push(parameter);
                bw.write(String.valueOf(myStack.print()));
                bw.write(System.lineSeparator());
                bw.write("-1");
                bw.write(System.lineSeparator());
            }
            if(choice==10)
            {
                int z=myStack.pop();
                bw.write(String.valueOf(myStack.print()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(z));
                bw.write(System.lineSeparator());
            }
            if(choice==11)
            {
                int z=myStack.length();
                bw.write(String.valueOf(myStack.print()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(z));
                bw.write(System.lineSeparator());

            }
            if(choice==12)
            {
                int z=myStack.topValue();
                bw.write(String.valueOf(myStack.print()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(z));
                bw.write(System.lineSeparator());
            }


        }
        br.close();
        bw.close();




    }

}
