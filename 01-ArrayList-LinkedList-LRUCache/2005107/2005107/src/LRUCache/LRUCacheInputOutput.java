package LRUCache;

import java.io.*;

public class LRUCacheInputOutput {
    final static String INPUT_FILE_NAME="lru_input.txt";
    final static String OUTPUT_FILE_NAME="lru_output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        int capacity,totalOperation;
        String line= br.readLine();
        capacity=Integer.parseInt(line);
        LRUCache cache=new LRUCache(capacity);
        String line2=br.readLine();
        totalOperation=Integer.parseInt(line2);
        for(int i=0;i<totalOperation;i++)
        {
            String line3=br.readLine();
            String [] out=line3.split(" ");
            if(Integer.parseInt(out[0])==1)
            {
               int value=cache.get(Integer.parseInt(out[1]));
               bw.write(String.valueOf(value));
               bw.write(System.lineSeparator());

            }
            else
            {
                cache.put(Integer.parseInt(out[1]),Integer.parseInt(out[2]));
            }

        }
        br.close();
        bw.close();

    }
}
