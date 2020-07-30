package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


 public class FileProcessor {
    BufferedReader bufferedReader = null;
    FileReader fileReader = null;
/**
  Constructor used to create object of bufferreader
*/
       public FileProcessor(String fileName) {
        try {
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
		String line = null;
		try {
			line = bufferedReader.readLine();
		} 
                  catch (IOException e) {
			System.out.println("Error while reading line from input file");
			System.exit(1);
		}
		return line;
                }
  }