package Graph;

import java.io.*;


public class Main
{
     final static String INPUT_FILE_NAME = "input.txt";
     final static String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) throws IOException
    {

         int noOfVertices;
         int noOfEdges;
         BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
         BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
         String line=br.readLine();
         String [] output=line.split(" ");
         noOfVertices=Integer.parseInt(output[0]);
         noOfEdges=Integer.parseInt(output[1]);
         Graph myGraph=new Graph(noOfVertices);
          for(int i=0;i<noOfEdges;i++)
          {
              String line4=br.readLine();
              String []output3=line4.split(" ");
              int start=Integer.parseInt(output3[0]);
              int end=Integer.parseInt(output3[1]);
              myGraph.addEdge(start,end);
          }
          String line5=br.readLine();
          int curr=Integer.parseInt(line5);
          myGraph.setSource(curr);
          bw.write(myGraph.bfs());
          bw.write(System.lineSeparator());
          bw.write(myGraph.dfsRecursive());



          br.close();
          bw.close();
    }
}


