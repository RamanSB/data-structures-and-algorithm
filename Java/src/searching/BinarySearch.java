package searching;

import java.util.Comparator;

/**
 * Binary search is a O(log(n)) algorithm which searches for an element in an ordered array.
 *
 * The BinarySearch algorithm works by taking an ordered array (arr) of size N and a search key, key.
 * A lower & upper bound are set to be the at the indices of the respective ends of arr: 0 and N-1.
 * A current index is then formed based on the average of these; several iterations occur via a while-loop
 * in order to identify the value at the currentIndex, if this value is:
 *
 * a) arr[currentIndex] > key (searchKey) we set the new lowerBound to the currentIndex
 * b) arr[currentIndex] < key (searchKey) we set the new upperBound to the currentIndex
 *
 * For an array of N elements we perform less than N/2 iterations of the while-loop
 * N = 10, max iterations = 5 (key doesn't exist)
 * N = 10, max iterations = 4 (key does exist).
 */

public class BinarySearch {

    static int[] arr = {1,5, 9, 10, 13, 17, 21, 192, 432, 1021}; //MUST BE ORDERED.

    public static int binarySearch(int key){
        int count = 0;
        int nElems = arr.length;
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int currentIdx;

        if(!checkIfOrdered(arr)) throw new IllegalArgumentException("Binary Search requires an ordered array must be ordered");
        
        while(true){
            count++;
            currentIdx = (lowerBound + upperBound) / 2; //Calculate currentIdx using LB & UB.
            System.out.format("\nIteration: %d | CurrentIndex: %d | LB: %d | UB: %d", count, currentIdx, lowerBound, upperBound);
            if(arr[currentIdx] == key){ //if searchKey is at currentIndex (we have found our element)
                System.out.println("\n\nSearch Key, " + key + " found at index: " + currentIdx);
                System.out.println("Number of elements: " + nElems + " Number of iterations: " + count);
                return currentIdx;
            }
            else if(lowerBound > upperBound){ //if lowerBound > upperBound stop iterating as array doesn't contain searchKey
                System.out.println("\n\nSearch Key, " + key + " does not exist in array");
                System.out.println("Number of elements: " + nElems + " Number of iterations: " + count);
                return -1;
            }
            else {
                if(arr[currentIdx] > key){ //if elem at currIdx in array is greater than search key then reduce the upperBound.
                    upperBound = currentIdx - 1;
                }else if(arr[currentIdx] < key){ //if element at currIdx in array is less than searchKey increase the lowerBound.
                    lowerBound = currentIdx + 1;
                }
            }
        }
    }

    static boolean checkIfOrdered(int[] arr){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(i==arr.length-1){
                count++;
                break;
            }
            if(arr[i] < arr[i+1]){
                count++;
            }
        }
        return count==arr.length;
    }

    public static void main(String[] args){
        binarySearch(21);
        binarySearch(1021);
        binarySearch(-30);
    }

}
