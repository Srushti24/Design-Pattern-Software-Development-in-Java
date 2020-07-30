
package studentCoursesBackup.driver;
    
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.myTree.Node;    
    public class Driver {

  
	
	public static void main(String[] args) {
          int bNo=0;
   String course=null;
  /**
   Takes 5 arguments which is the input,delete and the 3 output files
  */
        if(args.length!=5)
        {
          System.err.println("There should be 5 arguments, 4 for Bno and one for course");
          System.exit(0);
        }

 String line;
/**FileProcessor instances
*/
FileProcessor insertFileProcessor=new FileProcessor(args[0]);
FileProcessor deleteFileProcessor=new FileProcessor(args[1]);

/**Tree builder objects
*/
TreeBuilder originalTree=new TreeBuilder();
TreeBuilder backup1=new TreeBuilder();
TreeBuilder backup2=new TreeBuilder();

/**Node objects
*/
Node Node_orig;
Node  backup_Node_1=null;
Node  backup_Node_2=null;

/**Reading a file
*/

           while ((line = insertFileProcessor.readLine()) != null) {

             try {
                bNo = Integer.parseInt(line.split(":")[0].trim());
                course = line.split(":")[1].trim();
               Node currentNode = originalTree.searchNode(bNo);
                if(currentNode!=null && course.matches("[A-K]"))
                      {
                       if(!currentNode.courses.contains(course))
                         {
                          currentNode.courses.add(course);
                          currentNode.notifyAll("insert",bNo,course);
                          currentNode.backup.get(0).courses.add(course);
                           currentNode.backup.get(1).courses.add(course);
                          }
                       }
                       else
                       {
                       Node_orig =new Node(bNo,course);
                      
                        backup_Node_1 = (Node) Node_orig.clone();
                        backup_Node_2 = (Node) Node_orig.clone();
                        Node_orig.registerObserver( backup_Node_1 );
                        Node_orig.registerObserver(backup_Node_2);
                          originalTree.insertNode(Node_orig);
                        backup1.insertNode(backup_Node_1);
                        backup2.insertNode(backup_Node_2);
                       }
                } 
               
             catch (NumberFormatException e) {
                System.err.println("Invalid inputs");
            }


        }


/**deleting a course from a particular Bno
*/

  while((line=deleteFileProcessor.readLine())!=null)
   {
     try {
                bNo = Integer.parseInt(line.split(":")[0].trim());
                course = line.split(":")[1].trim();
               Node  currentNode = originalTree.searchNode(bNo);  
                  if(currentNode!=null)
                 {
                  originalTree.deleteNode(bNo,course); 
                  currentNode.notifyAll("delete",bNo,course);
                   
                }
            }
             catch (NumberFormatException e) {
                System.err.println("Invalid inputs");
            }
        }

//I have referred the link mentioned in readme for the print Nodes functions.   
Results file1=new Results(args[2]);
        originalTree.printTree();
        originalTree.printNodes(file1);
        file1.writeToFile(file1.message);

       Results file2=new Results(args[3]);
        backup1.printTree();
        backup1.printNodes(file2);
       file2.writeToFile(file2.message);

       Results file3=new Results(args[4]);
        backup2.printTree();
        backup2.printNodes(file3);
        file3.writeToFile(file3.message);    

}
}