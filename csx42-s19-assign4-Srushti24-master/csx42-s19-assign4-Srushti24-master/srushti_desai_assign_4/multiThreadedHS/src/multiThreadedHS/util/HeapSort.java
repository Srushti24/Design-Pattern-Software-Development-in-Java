//I referred the following link:
//https://repl.it/@StephanieStern/Merge-Sort-with-ArrayList
package multiThreadedHS.util;
import java.util.ArrayList;
import java.util.Collections;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;
public class HeapSort{

public void heap(ArrayList<Integer> results){

  doMergeSort(results);
}


private static void doMergeSort(ArrayList<Integer> results){
  int middle;
  ArrayList<Integer> left = new ArrayList<>();
  ArrayList<Integer> right = new ArrayList<>();
  
  if (results.size() > 1) {
     middle = results.size() / 2;
       
        for (int i = 0; i < middle; i++) 
            left.add(results.get(i));
 
      
        for (int j = middle; j < results.size(); j++)
            right.add(results.get(j));
            
     doMergeSort(left);
     doMergeSort(right);
     
     merge(results, left, right);
  }
}

private static void merge(ArrayList<Integer> results, ArrayList<Integer> left, ArrayList<Integer> right){

  ArrayList<Integer> temp = new ArrayList<>(); 
  
  
  int numbersIndex = 0;    
  int leftIndex = 0;
  int rightIndex = 0;

  while (leftIndex < left.size() && rightIndex < right.size()) {
    if (left.get(leftIndex) < right.get(rightIndex) ) {
            results.set(numbersIndex, left.get(leftIndex));
            leftIndex++;
        } else {
            results.set(numbersIndex, right.get(rightIndex));
            rightIndex++;
        }
        numbersIndex++;
    }
   
    int tempIndex = 0;
    if (leftIndex >= left.size()) {
        temp = right;
        tempIndex = rightIndex;
    } 
    else {
        temp = left;
        tempIndex = leftIndex;
    }
 
    for (int i = tempIndex; i < temp.size(); i++) {
        results.set(numbersIndex, temp.get(i));
        numbersIndex++;
    }
 }
} 


       
/*int size=results.size();
 for(int i = size / 2 - 1; i >= 0; i--) {
        maxHeap(results, i, size);
    }

    for(int i = size - 1; i >= 0; i--) {
        Collections.swap(results, i, 0);
        maxHeap(results, 0, i);
    }


}


public void maxHeap(ArrayList<Integer> array, int index, int size) {

        int largest = index; // Root Node
        int left = 2 * index + 1; // Left Child node
        int right = 2 * index + 2; // Right Child node

        if (left < size && array.get(left) > array.get(largest)) {
            largest = left;
        }
        if (right < size && array.get(right) > array.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            Collections.swap(array, index, largest); // Swap the indexes not the values
            maxHeap(array, largest, size);
        }*/

    