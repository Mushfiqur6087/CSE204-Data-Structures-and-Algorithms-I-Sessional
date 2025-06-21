import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";
    static class Activities
    {
        int startingTime;
        int finishTime;
        int totalTime;

        public Activities(int st,int ft)
        {
            this.startingTime=st;
            this.finishTime=ft;
            this.totalTime=ft-st;
        }

        public int getStartingTime() {
            return startingTime;
        }

        public int getFinishTime() {
            return finishTime;
        }

    }

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));

        String line=br.readLine();
        String [] output=line.split(" ");
        int totalOperations=Integer.parseInt(output[0]);
        ArrayList<Activities> activitiesList = new ArrayList<>();
        for(int i = 0; i<totalOperations; i++)
        {
            String line2=br.readLine();
            String []output2=line2.split(" ");
            int start=Integer.parseInt(output2[0]);
            int end=Integer.parseInt(output2[1]);
            activitiesList.add(new Activities(start,end));
        }

        for(int i = 0; i < activitiesList.size(); i++) {
            for (int j = i + 1; j < activitiesList.size(); j++) {
                if (activitiesList.get(j).getFinishTime() < activitiesList.get(i).getFinishTime()) {
                    Collections.swap(activitiesList, j, i);
                }
            }
        }

        int k=0;
        ArrayList<Activities>ans=new ArrayList<>();
        ans.add(activitiesList.get(0));
        for(int i=1;i<activitiesList.size();i++)
        {
            if(activitiesList.get(i).getStartingTime()>=activitiesList.get(k).getFinishTime())
            {
                k=i;
                ans.add(activitiesList.get(k));
            }
        }
        bw.write(String.valueOf(ans.size()));
        bw.write(System.lineSeparator());

        for (int i=0;i<ans.size();i++)
        {
            bw.write(String.valueOf(ans.get(i).getStartingTime()));
            bw.write(String.valueOf(" "));
            bw.write(String.valueOf(ans.get(i).getFinishTime()));
            bw.write(System.lineSeparator());
        }


        br.close();
        bw.close();


    }
}
