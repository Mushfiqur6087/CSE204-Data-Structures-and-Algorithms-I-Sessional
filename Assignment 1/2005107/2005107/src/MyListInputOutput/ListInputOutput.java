package MyListInputOutput;

import java.io.*;
import LinkedList.MyList;


public class ListInputOutput
{
     final static String INPUT_FILE_NAME = "list_input.txt";
     final static String OUTPUT_FILE_NAME = "list_output.txt";
    static StringBuffer printArray(MyList<Integer> list) throws IOException {
        StringBuffer str=new StringBuffer();
        str.append("<");
        int currPos=list.currPos();
        list.setToBegin();
        for(int i=0;i<list.size();i++ )
        {
            if(i==currPos)
            {
                str.append("| ");
            }

            if(i==list.size()-1)
            {
                str.append(list.getValue());
            }
            else
            {
                str.append(list.getValue()+" ");
            }
            list.next();
        }
        str.append(">");
        list.setToPos(currPos);
        return str;

    }

    public static void main(String[] args) throws IOException
    {

         int initialLength;
         int initialCapacity;
         BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
         BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
         String line=br.readLine();
         String [] output=line.split(" ");
         initialLength=Integer.parseInt(output[0]);
         initialCapacity=Integer.parseInt(output[1]);
         String line2 = br.readLine();
         String [] output2=line2.split(" ");
         Integer []arr=new Integer[initialCapacity];
          for(int i=0;i<initialLength;i++)
          {
              arr[i]=Integer.parseInt(output2[i]);
          }
          MyList<Integer> list=new MyList<>(arr,initialLength);
          String line3=br.readLine();
          int totalOperations=Integer.parseInt(line3);
          bw.write(String.valueOf(printArray(list)));
          bw.write(System.lineSeparator());
          for(int i=0;i<totalOperations;i++)
          {
              String line4=br.readLine();
              String []output3=line4.split(" ");
              int choice=Integer.parseInt(output3[0]);
              int parameter=Integer.parseInt(output3[1]);

              if(choice==1)
              {
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write(String.valueOf(list.size()));
                  bw.write(System.lineSeparator());
              }
              if(choice==2)
              {
                  list.push(parameter);
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write("-1");
                  bw.write(System.lineSeparator());
              }
              if(choice==3)
              {
                  list.pushBack(parameter);
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write("-1");
                  bw.write(System.lineSeparator());
              }
              if(choice==4)
              {
                  int z=list.erase();
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write(String.valueOf(z));
                  bw.write(System.lineSeparator());
              }
              if(choice==5)
              {
                  list.setToBegin();
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write("-1");
                  bw.write(System.lineSeparator());
              }
              if(choice==6)
              {
                  list.setToEnd();
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write("-1");
                  bw.write(System.lineSeparator());
              }
              if(choice==7)
              {
                  list.prev();
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write("-1");
                  bw.write(System.lineSeparator());
              }
              if(choice==8)
              {
                  list.next();
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write("-1");
                  bw.write(System.lineSeparator());
              }
              if(choice==9)
              {
                 int z= list.currPos();
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                 bw.write(String.valueOf(z));
                 bw.write(System.lineSeparator());
              }
              if(choice==10)
              {
                  list.setToPos(parameter);
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write("-1");
                  bw.write(System.lineSeparator());
              }
              if(choice==11)
              {
                  int z=list.getValue();
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write(String.valueOf(z));
                  bw.write(System.lineSeparator());

              }
              if(choice==12)
              {
                  int z=list.find(parameter);
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write(String.valueOf(z));
                  bw.write(System.lineSeparator());
              }
              if(choice==13)
              {
                  bw.write(String.valueOf(printArray(list)));
                  bw.write(System.lineSeparator());
                  bw.write("-1");
                  bw.write(System.lineSeparator());
              }


          }
          br.close();
          bw.close();
    }
}


