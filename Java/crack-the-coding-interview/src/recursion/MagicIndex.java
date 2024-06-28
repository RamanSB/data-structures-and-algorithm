package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array of distinct integers with size N, a magic index is defined to be the index i such that A[i] = i
 *
 * Follow up: What if the values are not distinct i.e. [0,0,1,2,3,4,5,9,9,9,12]
 *
 * Comments: I don't see how including non-distinct values in a sorted array of integers will differ from the solution below.
 */
public class MagicIndex {

    static int[] A = {0,1,2,5,6,7,8,13};

    public static void main(String[] args){
        List<Integer> magicIndices = new ArrayList<>();
        for(int i=0; i<A.length; i++){
            if(A[i] == i){
                magicIndices.add(i);
            }
        }

        System.out.println(magicIndices.size() + " magic index's have been found");
        System.out.println(magicIndices);
    }


}
