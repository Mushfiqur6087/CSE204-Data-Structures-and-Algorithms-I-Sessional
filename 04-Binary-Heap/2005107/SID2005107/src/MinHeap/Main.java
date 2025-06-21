package MinHeap;

import java.io.*;

public class Main {
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        MinHeap myHeap = new MinHeap(2);
        String line;
        while ((line = br.readLine()) != null) {
            String[] output = line.split(" ");
            String input1 = output[0];
            if (input1.equalsIgnoreCase("INS")) {
                int input2 = Integer.parseInt(output[1]);
                myHeap.insert(input2);
                StringBuffer str = new StringBuffer();
                str.append("INSERTED " + input2);
                bw.write(String.valueOf(str));
                bw.write(System.lineSeparator());
            }

            if (input1.equalsIgnoreCase("PRI")) {
                bw.write(System.lineSeparator());
                bw.write("Printing the binary heap");
                bw.write(System.lineSeparator());
                bw.write("--------------------------------------------");
                bw.write(System.lineSeparator());
                bw.write(myHeap.print());
                bw.write("--------------------------------------------");
                bw.write(System.lineSeparator());
            }

            if (input1.equalsIgnoreCase("DEC"))
            {
                int input2 = Integer.parseInt(output[1]);
                int input3 = Integer.parseInt(output[2]);
                myHeap.decreaseKey(input2, input3);
                StringBuffer str = new StringBuffer();
                str.append(input2 + " decreased to " + input3);
                bw.write(String.valueOf(str));
                bw.write(System.lineSeparator());
            }

            if (input1.equalsIgnoreCase("FIN"))
            {
                int out = myHeap.findMin();
                StringBuffer str = new StringBuffer();
                str.append("FindMin returned "+out);
                bw.write(String.valueOf(str));
                bw.write(System.lineSeparator());
            }

            if (input1.equalsIgnoreCase("EXT"))
            {
                int out = myHeap.extractMin();
                StringBuffer str = new StringBuffer();
                str.append("ExtractMin returned "+out);
                bw.write(String.valueOf(str));
                bw.write(System.lineSeparator());
            }
        }
        br.close();
        bw.close();


    }
}

