package studentCoursesBackup.util;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    
    public ArrayList<String> messages;
   public String message;
 FileWriter fileWriter=null;
BufferedWriter  bufferedWriter=null;
   
      

       public Results() {
       messages = new ArrayList<>();
    }
/**
Constructor used to create object of buffer writer
*/
       public Results(String fileName) {
      
        try {
             fileWriter = new FileWriter(fileName);
              bufferedWriter = new BufferedWriter(fileWriter);
        } 
          catch (IOException e) {
            e.printStackTrace();
        }
       
    }

/**Method used to store result
*/

       public void storeResult(String message) {
        this.message = message;
    }

/** 
  Method to write inside a file which is selected
*/
       public void writeToFile(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.close();
        } 
         catch (IOException e) {
            e.printStackTrace();
        }
    
        }

    public void writeToStdout(String message) {
        System.out.println(message);
    }
}
