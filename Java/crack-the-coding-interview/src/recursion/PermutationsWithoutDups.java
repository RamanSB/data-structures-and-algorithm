package recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, "CAT":
 * the 1st letter can be 3 possible values
 * the 2nd letter can have 2 possible values (as the first letter would've been assigned)
 * the last letter can have 1 possible value. (as letters at index 0 and 1 are already assigned)
 * Total # of permutations = 3! = 3*2*1 = 6
 *
 * "CAT", "CTA", "ACT", "ATC", "TAC", "TCA"
 *
 * 1) CAT ---> ACT
 * 2) TCA ---> CTA
 * 3) ATC ---> TAC
 */
public class PermutationsWithoutDups {


    void permutate(String inputString){
        rotate(inputString, inputString, inputString.length()-1);
    }

    void rotate(String startValue, String inputString, int idx){
        StringBuilder stringBuilder = new StringBuilder(inputString);
        if(idx < 0){
            return ;
        }
        char originChar = stringBuilder.charAt(0);
        char charToRotateWithOriginChar = stringBuilder.charAt(idx);
        stringBuilder.setCharAt(0, charToRotateWithOriginChar);
        stringBuilder.setCharAt(idx, originChar);
        String rotatedString = stringBuilder.toString();
        System.out.println(rotatedString);
        if(rotatedString.equals(startValue)){
            System.out.println("All permutations have been iterated");
            return ;
        }
        if(idx==0){
            rotate(startValue, rotatedString, 2);
        }
        rotate(startValue, rotatedString, idx-1);
    }

    public static void main(String[] args){
        String input = "CAT";
        new PermutationsWithoutDups().permutate(input);
    }

}
