package BST;

import java.io.*;

public class Main {
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        BST MyBst=new BST();
        String line;
        while ((line = br.readLine()) != null)
        {
            String []output=line.split(" ");
            String input1=output[0];
            if(input1.equalsIgnoreCase("I"))
            {
                int input2=Integer.parseInt(output[1]);
                String output1=MyBst.insert(input2);
                bw.write(output1);
                bw.write(System.lineSeparator());
            }

            if(input1.equalsIgnoreCase("F"))
            {
                int input2=Integer.parseInt(output[1]);
                Boolean output1=MyBst.find(input2);
                bw.write(String.valueOf(output1));
                bw.write(System.lineSeparator());
            }

            if(input1.equalsIgnoreCase("T"))
            {
                String output1=MyBst.Traversal(output[1]);
                bw.write(output1);
                bw.write(System.lineSeparator());
            }

            if(input1.equalsIgnoreCase("D"))
            {
                int input2=Integer.parseInt(output[1]);
                String output1=MyBst.Delete(input2);
                bw.write(output1);
                bw.write(System.lineSeparator());
            }

        }
        br.close();
        bw.close();


    }
}
