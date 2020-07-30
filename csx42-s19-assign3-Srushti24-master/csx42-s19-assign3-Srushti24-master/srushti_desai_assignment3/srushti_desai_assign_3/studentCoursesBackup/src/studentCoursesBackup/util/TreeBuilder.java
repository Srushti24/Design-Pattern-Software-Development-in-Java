
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.Results;

import java.util.ArrayList;

public class TreeBuilder{

public Node root;
public Node newNode;
public int Bno;
public String output="";
//public String design="";

 
/**
Insertion of node method in the binary tree
*/

  public void insertNode(Node newNode) 
       {

          Node copy=root;
          Node parent=copy;
    if(root==null)
    {
        root=newNode;
    }
    else
    {
       
        while(copy!=null)
   { 
        if(copy. Bno>newNode. Bno)
        {
            parent=copy;
            copy=copy.left;
        }
        else
        {
            parent=copy;
            copy=copy.right;
        }
    }
         if(parent. Bno>newNode. Bno )
        {
        parent.left=newNode;
       }
    else
       {
        parent.right=newNode;
       }
     }
}
   

/**
Method used to search if a particulr node exist or no
*/
 public Node searchNode(int bNumber)
       {
        Node copy=root;
        while (copy!= null) 
          {
            if (copy. Bno ==  bNumber) 
            {
                return copy;
            } 
             else if (copy.Bno < bNumber) 
             {
                copy = copy.right;
            }
             else 
             {
                copy = copy.left;
            }
        }
        return null;
    }

/**
 Method used to delete a particular course
*/
public void deleteNode(int Bnumber, String course)
{
   Node markedDeletion= searchNode(Bnumber);
        if(markedDeletion.courses.contains(course))
          {
           markedDeletion.courses.remove(course);
           }
}

/** 
Method used to print, i have referred the link mentioned in the READMe file to understand its implementation

*/
public void printTree()
   {
    Node temp=root;
    print(temp);
   }



 public void print(Node temp) {
        if (temp == null)
            return;
        print(temp.left);
        output =  output + temp.Bno + ": " + designOutput(temp.courses) + "\n";
       print(temp.right);
    }



public String designOutput(ArrayList<String> courses)
{    String design="";
    for(String course:courses)
     {
      design=design+","+course;
     }
   return  design;
}
 
      
        public void printNodes(Results result) {
        result.storeResult( output );
    }

}



      



