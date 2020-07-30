package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

 public class FileProcessor {
    BufferedReader bufferedReader = null;
    FileReader fileWriter = null;

       public FileProcessor(String fileName) {
        try {
             FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
        }
          catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

       public String readLine() {
        String line = "";
        String sentence = null;
        try {
            if ((line = bufferedReader.readLine()) != null) {
                sentence = line;
            }
        } 
          catch (IOException e) {
            e.printStackTrace();
        }
        return sentence;
    }
}