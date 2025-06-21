import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Main {
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";
    static class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
    static ArrayList<Pair> inversions=new ArrayList<>();

    static void mergeSort(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }

        int mid=(start + end)/2;

        mergeSort(arr,start,mid);
        mergeSort(arr,mid,end);
        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int[] mix=new int[end-start];

        int i=start;
        int j=middle;
        int k=0;

        while (i<middle && j<end)
        {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                for (int x = i; x < middle; x++)
                {
                   inversions.add(new Pair(arr[x],arr[j]));
                }
                j++;
            }
            k++;
        }
        while(j<end)
        {
            mix[k] = arr[j];
            j++;
            k++;
        }
        while(i<middle)
        {
            mix[k] = arr[i];
            i++;
            k++;
        }

        System.arraycopy(mix, 0, arr, start, mix.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        String line=br.readLine();
        int length=Integer.parseInt(line);
        String line2=br.readLine();
        String []output2=line2.split(" ");
        int []arr=new int[length];
        for (int i=0;i<length;i++)
        {
            arr[i]=Integer.parseInt(output2[i]);
        }
        mergeSort(arr,0,arr.length);
        bw.write(String.valueOf(inversions.size()));
        Collections.sort(inversions, Comparator.comparing(Pair::getFirst));
        bw.write(System.lineSeparator());
        bw.write("The inverted pairs are ");
        for(int i=0;i<inversions.size();i++)
        {
            bw.write("("+inversions.get(i).getFirst()+","+inversions.get(i).getSecond()+")");
            if(i!=inversions.size()-1)
                bw.write(",");
        }






        br.close();
        bw.close();

    }


}
