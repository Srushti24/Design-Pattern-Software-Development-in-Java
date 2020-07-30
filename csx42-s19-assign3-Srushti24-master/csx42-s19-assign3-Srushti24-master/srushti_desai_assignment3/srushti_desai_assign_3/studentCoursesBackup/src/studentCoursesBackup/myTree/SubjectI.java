package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.Node;

public interface Subjecti {

        public void notifyAll(String update_type,int Bno,String course);
        public void registerObserver(Node observer);

  
      public void deregisterObserver(Node observer);

       }