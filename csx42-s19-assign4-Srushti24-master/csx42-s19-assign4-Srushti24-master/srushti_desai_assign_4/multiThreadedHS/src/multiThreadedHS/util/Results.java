package multiThreadedHS.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;



import multiThreadedHS.util.HeapSort;

public class Results implements FileDisplayInterface{
public ArrayList<Integer> resultList = new ArrayList<Integer>();

FileWriter  fileWriter=null;

String fileName=null;
 








public Results(String name)
{
MyLogger.writeMessage("constructor is made",DebugLevel.CONSTRUCTOR);

 fileName=name;
 System.out.println(name);
//try
//{
 //fileWriter = new FileWriter(name);
 //bufferedWriter = new BufferedWriter(fileWriter);
//}
//catch(Exception e)
//{
//System.err.println("File Not found Exception");
//}
}

public  void writefile(String s, String name){
           //System.out.println(name);
          // System.out.println(s);
           
          try
          {
	  File file = new File(name);
	  FileWriter fw = new FileWriter(file);
	  BufferedWriter bw = new BufferedWriter(fw);
	  bw.write(s);
bw.close();
         }
       catch(Exception e)
{
System.err.println("File Not found Exception");
}
}


public void add(ArrayList<Integer> arraylist)
{
 for(int i=0;i<arraylist.size();i++)
  {
   resultList.add(arraylist.get(i));  

}


}


public void writeToFile(){
MyLogger.writeMessage("HeapSort is used to sort",DebugLevel.FROM_RESULTS);


HeapSort hs=new HeapSort();
hs.heap(resultList);

//for(int i=0;i<resultList.size();i++)
//{
//System.out.println(resultList.get(i));
//}

//for(int i=0;i<resultList.size();i++)
//{
//System.out.println(resultList.get(i));
//}


ArrayList<String> temp = new ArrayList<>();
for(int i=0;i<resultList.size();i++)
{ 
try {      
        
           //String s=String.valueOf(resultList.get(i));
           String s=resultList.get(i).toString();
          // System.out.println(s);
            temp.add(s);
           //bufferedWriter.write(s);
            
          
           
        } catch (Exception e) {
           System.err.println("Exception found");
        }
}

writefile(temp.toString(),fileName);



}
}