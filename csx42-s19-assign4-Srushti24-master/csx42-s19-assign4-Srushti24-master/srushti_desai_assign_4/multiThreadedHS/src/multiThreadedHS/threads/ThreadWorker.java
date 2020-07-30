package multiThreadedHS.threads;

import java.lang.Thread;
import multiThreadedHS.util.Results;
import multiThreadedHS.util.FileProcessor;
import java.util.ArrayList;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;

public class ThreadWorker implements Runnable{
 Results result;
FileProcessor s;


public ThreadWorker(String fileName, Results r)
{
 MyLogger.writeMessage("constructor is made",DebugLevel.CONSTRUCTOR);

 FileProcessor fileprocessor=new FileProcessor(fileName);
 s=fileprocessor;
  result=r;
}


public void run()
{
  

  String line=null;
 ArrayList < Integer > arraylist = new ArrayList < Integer > ();
MyLogger.writeMessage("ArrayList is made for the individual thread",DebugLevel.IN_RESULTS);

     while ((line = s.readLine()) != null) {
        try
       {
        int i=Integer.parseInt(line);
        
      arraylist.add(i);
        }
          catch(Exception e)
        {
         System.err.println("Number Format wrong");
         }
         }
      for (int i=0; i<arraylist.size(); i++) 
         {

          for (int j = arraylist.size() - 1; j > i; j--) 
               {
              if (arraylist.get(i) > arraylist.get(j)) 
                   {

                  int temp = arraylist.get(i);
                  arraylist.set(i,arraylist.get(j)) ;
                  arraylist.set(j,temp);
                     }
                     }
                     }
         
         
       
        
         result.add(arraylist);

        
      
}



}
