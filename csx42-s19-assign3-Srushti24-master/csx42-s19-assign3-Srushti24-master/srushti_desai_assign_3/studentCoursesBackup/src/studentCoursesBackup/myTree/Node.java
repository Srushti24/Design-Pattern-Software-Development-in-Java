public class Node{

public int Bno=0;
public ArrayList<String> courses=null;
Node left=null;
Node right=null;
public ArrayList<Node> backupList=null;
String course=null;

public Node(int Bno,String course){
 this.Bno=Bno;
 this.course=course;
 this.courses=new ArrayList<String>();
 this.backup=new ArrayList<Node>();
 this.courses.add(course);

}

  public void notifyAll(String update_type,Node currentNode,String course) {
        for(Node node: backupList) {
              if(currentNode.Bno==node.Bno)
              {
            update(fact,node, course);
        }
    }

 public void update(String update_type,Node node, String update){
		if(update_type.equals("delete"))
			{
                           if(node.courses.contains(course)) {
            node.courses.remove(course);
        }
		 else if(update_type == "insert"){
			node.courses.add(course);
	}


 public Object clone() {
        return new Node(bNo, course);
    }

 public void registerObserver(Node observer) {
        backupList.add(observer);
    }

    
    public void deregisterObserver(Node observer) {
        if(backupList.contains(observer)) {
            backupList.remove(observer);
        }
    }

}