
package studentCoursesBackup.myTree;

import java.util.ArrayList;

public class Node implements Observeri, Subjecti, Cloneable {

public int Bno=0;
public ArrayList<String> courses=null;
public Node left=null;
public Node right=null;
public ArrayList<Node> backup=null;
String course=null;

/**
* Constructor used to initialize all values
*/
public Node(int Bno,String course){
 this.Bno=Bno;
 this.course=course;
 this.courses=new ArrayList<String>();
 this.backup=new ArrayList<Node>();
 this.courses.add(course);

                                  }

/**
 * notifyAll method is used while inserting a course in an already existing Bno or while deleting
 * the course of a particular Bno, it finds out the node for which it has to be implemented and passed that
*node to update method which carries out the necessary operations.
*/
  public void notifyAll(String update_type,int Bno,String course) 
      {
        for(Node node: backup) {
              if(Bno==node.Bno)
              {
            update(update_type,node, course);
              }
                                }
       }

 public void update(String update_type,Node node, String update)
                 {
		if(update_type.equals("delete"))
			{
                           if(node.courses.contains(course))
                             {
                                node.courses.remove(course);
                             }
                       }
		 else if(update_type == "insert")
                            {
			node.courses.add(course);
	                     }
                    }
/** Used for cloning
*/
 public Object clone() {
        return new Node(Bno, course);
    }

/** this method is used to register observer
*/
 public void registerObserver(Node observer) {
        backup.add(observer);
    }

  /**this method is used to deregister observer
  */  
    public void deregisterObserver(Node observer) 
       {
        if(backup.contains(observer)) 
             {
            backup.remove(observer);
             }
         }

}