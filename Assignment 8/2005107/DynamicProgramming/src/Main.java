import java.io.*;
import java.util.ArrayList;

public class Main {
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        String line=br.readLine();
        int length=Integer.parseInt(line);
        int []weightOfItem=new int[length];
        int []valueOfItem=new int[length];
        for (int i=0;i<length;i++)
        {
            String line2=br.readLine();
            String []output2=line2.split(" ");
            weightOfItem[i]=Integer.parseInt(output2[0]);
            valueOfItem[i]=Integer.parseInt(output2[1]);
        }
        String line3=br.readLine();
        int weight=Integer.parseInt(line3);
        int[][] solutionArray = new int[length+1][weight+1];
        for (int i=0;i<=length; i++) {
            for (int j=0;j<=weight;j++) {
                if (i==0 || j== 0) {
                    solutionArray[i][j] = 0;
                }
                else if (weightOfItem[i-1] <=j) {
                    solutionArray[i][j]= Math.max(valueOfItem[i-1]+solutionArray[i-1][j-weightOfItem[i-1]],solutionArray[i-1][j]);
                }
                else {
                    solutionArray[i][j] = solutionArray[i-1][j];
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int solution=solutionArray[length][weight];
        int w=weight;
        for(int i=length;i>0 && solution >0;i--)
        {
            if (solution!= solutionArray[i-1][w])
            {
                ans.add(weightOfItem[i - 1]);
                solution=solution-valueOfItem[i-1];
                w=w-weightOfItem[i-1];
            }
        }
        bw.write(String.valueOf(solutionArray[length][weight]));
        bw.write(System.lineSeparator());
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();


    }
}

