import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Online
{
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";

    static class Customer
    {

        int id;
        int deadline;
        int profit;
        public Customer(int id, int deadline, int profit)
        {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        public int getProfit() {
            return profit;
        }

        public int getDeadline() {
            return deadline;
        }
        public int getId(){
            return id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));

        String line=br.readLine();
        String [] output=line.split(" ");
        int totalOperations=Integer.parseInt(output[0]);
        ArrayList<Customer> customers = new ArrayList<>();
        for(int i = 0; i<totalOperations; i++)
        {
            String line2=br.readLine();
            String []output2=line2.split(" ");
            int start=Integer.parseInt(output2[0]);
            int end=Integer.parseInt(output2[1]);
            customers.add(new Customer(i+1,start,end));
        }
        int deadline=0;

        for(int i = 0; i < customers.size(); i++) {
            for (int j = i + 1; j < customers.size(); j++) {
                if (customers.get(j).getProfit()> customers.get(i).getProfit()) {
                    Collections.swap(customers, j, i);
                }
            }
        }
        ArrayList<Customer> ans=new ArrayList<>();

        int[] result =new int[100];
        for(int i=0;i<result.length;i++)
        {
            result[i]=-1;
        }
        int profit=0;

        for(int i=0;i<customers.size();i++)
        {
            if(result[customers.get(i).getDeadline()]==-1)
            {
                ans.add(customers.get(i));
                result[customers.get(i).getDeadline()]=1;
                profit=profit+customers.get(i).getProfit();
            }
            else
                for(int j=customers.get(i).getDeadline();j>=1;j--)
                {
                    if(result[customers.get(j).getDeadline()]==-1)
                    {
                        ans.add(customers.get(i));
                        result[customers.get(j).getDeadline()]=1;
                        profit=profit+customers.get(i).getProfit();
                    }
                }

        }

        for(int i = 0; i < ans.size(); i++) {
            for (int j = i + 1; j < ans.size(); j++) {
                if (ans.get(j).getId()< ans.get(i).getId())
                {
                    Collections.swap(ans, j, i);
                }
            }
        }

        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i).getId());
        }
        System.out.println(profit);




        br.close();
        bw.close();



    }





}
