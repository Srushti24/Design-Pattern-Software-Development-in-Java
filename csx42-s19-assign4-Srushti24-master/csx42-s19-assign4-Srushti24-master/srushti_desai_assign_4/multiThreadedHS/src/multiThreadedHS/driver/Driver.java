
package multiThreadedHS.driver;

import multiThreadedHS.util.Results;
import multiThreadedHS.threads.ThreadWorker;
import multiThreadedHS.util.FileProcessor;
import java.lang.Thread;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;


public class Driver{

//public List<Integer> resultList = Collections.synchronizedList(new ArrayList<Integer>());
public static void main(String args[])
{
if(args.length>6)
{
System.err.println("Invalid number of arguments");
System.exit(0);
}
String s=args[0];
int N= Integer.parseInt(s);
if(N<1 || N>3)
{
 System.out.println("There should not be less than 1 or more than 3 input files");
 System.exit(0);
}
else
{
Results results=new Results(args[N+1]);


if(N==1)
{
int debug=Integer.parseInt(args[3]);
if(debug>4)
{
System.err.println("Debug number should be between 0 and 4");
System.exit(0);
}
else{
MyLogger.setDebugValue(debug);
 
  
 ThreadWorker t1=new ThreadWorker(args[1],results);
 Thread t1s=new Thread(t1);
 try
 {
  
  MyLogger.writeMessage("Thread is made",DebugLevel.IN_RUN);
  t1s.start();
   t1s.join();

 }
 catch(Exception e)
{
System.err.println("Threads not synchornized exception");
}
}
}


else if(N==2)
 {
int debug=Integer.parseInt(args[4]);
if(debug>4)
{
System.err.println("Debug number should be between 0 and 4");
System.exit(0);
}
else{

MyLogger.setDebugValue(debug);



ThreadWorker t1=new ThreadWorker(args[1],results);
 Thread t1s=new Thread(t1);
 
ThreadWorker t2=new ThreadWorker(args[2],results);
 Thread t2s=new Thread(t2);
try
{
MyLogger.writeMessage("1stThread is made",DebugLevel.IN_RUN);
 t1s.start();
 t1s.join();
MyLogger.writeMessage("2nd Thread is made",DebugLevel.IN_RUN);

 t2s.start();
 t2s.join();

}
catch(Exception e)
{
System.err.println("Threads not synchornized exception");
}
}
}

else if(N==3)
{
int debug=Integer.parseInt(args[5]);
MyLogger.setDebugValue(debug);
if(debug>4)
{
System.err.println("Debug number should be between 0 and 4");
System.exit(0);
}
else{
ThreadWorker t1=new ThreadWorker(args[1],results);

 Thread t1s=new Thread(t1);
 
ThreadWorker t2=new ThreadWorker(args[2],results);
 Thread t2s=new Thread(t2);
ThreadWorker t3=new ThreadWorker(args[3],results);

 Thread t3s=new Thread(t3);
try
{
 MyLogger.writeMessage("1st Thread is made",DebugLevel.IN_RUN);
 t1s.start();
 t1s.join();
MyLogger.writeMessage("2nd Thread is made",DebugLevel.IN_RUN);
 t2s.start();
 t2s.join();
MyLogger.writeMessage("3rd Thread is made",DebugLevel.IN_RUN);
t3s.start();
 t3s.join();
}
catch(Exception e)
{
System.err.println("Threads not synchornized exception");
}
}
}
results.writeToFile();

}
}
}




 


