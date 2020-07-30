
package studentCoursesBackup.driver;
    
/**
 * @author AuthorName
 *
 */
    
    public class Driver {

   int bNo=0;
   String course=null;
  
	
	public static void main(String[] args) {
        if(args.length!=5)
        {
          System.err.println("There should be 5 arguments, 4 for Bno and one for course);
          System.exit(0);
        }

 String line=null;
FileProcessor insertFileProcessor=new FileProcessor(args[0]);
FileProcessor deleteFileProcessor=new FileProcessor(args[1]);
TreeBuilder originalTree=new TreetBuilder();
TreeBuilder backup1=new TreeBuilder();
TreeBuilder backup2=new TreeBuilder();
Node Node_orig;
Node  backup_Node_1;
Node  backup_Node_2;


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
                          currentNode.notifyAll(insert,currentNode,course);
                          }
                       }
                       else
                       {
                       Node_orig =new Node(bNo,course);
                      
                        backup_Node_1 = (Node) node.clone();
                        backup_Node_2 = (Node) node.clone();
                        node.registerObserver( backup_Node_1 );
                        node.registerObserver(backup_Node_2);
                          originalTree.insertNode(Bno,course);
                        backup1.insertNode(nodeBackup1);
                        backup2.insertNode(nodeBackup2);
                    }
                } 
                 else {
                    continue;
                }

            } catch (NumberFormatException e) {
                System.err.println("Invalid inputs");
            }


        }


  while(line=deleteFileProcessor.readLine()!=null)
   {
     try {
                bNo = Integer.parseInt(line.split(":")[0].trim());
                course = line.split(":")[1].trim();
                 tree.deleteNode(bNo, course);
                    currentNode.notifyAll(course);
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid inputs);
            }
        }

//I have referred the link mentioned in readme for the print Nodes functions.   
Results file1=new Results(args[2]);
        tree.print();
        tree.printNodes(file1);
        result1.writeToFile(file1.message);

       Results file2=new Results(args[3]);
        backup1.print();
        backup1.printNodes(file2);
        result2.writeToFile(file2.message);

       Results file3=new Results(args[4]);
        backup2.print();
        backup2.printNodes(result3);
        result3.writeToFile(result3.message);    




    

}