package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.Node;

public interface subjectI {

        public void notifyAll();
        public void registerObserver(Node observer);

  
      public void deregisterObserver(Node observer);

       }