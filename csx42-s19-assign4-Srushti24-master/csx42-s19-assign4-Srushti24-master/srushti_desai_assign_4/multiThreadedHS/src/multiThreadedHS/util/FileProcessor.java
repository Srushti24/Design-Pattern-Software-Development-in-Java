package multiThreadedHS.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;



 public class FileProcessor {
    BufferedReader bufferedReader = null;
    FileReader fileReader = null;
/**
  Constructor used to create object of bufferreader
*/
       public FileProcessor(String fileName) {
     MyLogger.writeMessage("constructor is made",DebugLevel.CONSTRUCTOR);

      
        try {
              MyLogger.writeMessage("InputFile is called and read from",DebugLevel.RELEASE);
              fileReader = new FileReader(fileName);
              bufferedReader = new BufferedReader(fileReader);
             
           }
          catch (FileNotFoundException e) 
          {
           System.out.println("File not found");
			System.exit(1);        
        
            }
                                          }

/**
  Method used to read line by line from the input file
*/

      public String readLine() {
        String line = "";
        String value = null;
        try {
            if ((line = bufferedReader.readLine()) != null) {
                value = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}