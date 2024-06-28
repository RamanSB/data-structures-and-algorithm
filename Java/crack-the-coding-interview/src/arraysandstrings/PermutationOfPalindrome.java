package arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * My approach
 * A palindrome is a word such that; when read forwards is equal to the same word when read from rtl (right to left).
 * i.e. racecar & redder.
 * In the 1st case, the string length is odd - we expect all but the central character to occur with a frequency = to a multiple of 2
 * In the 2nd case, the string length is even - we expect all characters to occur with a frequency as a multiple of 2.
 *
 * So here's how we shall proceed:
 * Check if the string length is even or odd:
 * if even: Iterate through the String and add each character to a HashMap<Character, Integer> - all values should appear with a multiple of 2.
 * else return false.
 * if odd: repeat the above, but only 1 character should occur with a frequency of an odd value. The character that occurs with an odd frequency,
 * will be in the middle, we can remove this from the map.
 */
public class PermutationOfPalindrome {


    public static void main(String[] args){
        System.out.println(isPermutationOfPalindrome("racecar"));
    }

    static boolean isPermutationOfPalindrome(String s1){
        s1 = s1.toLowerCase();
        s1 = s1.replaceAll("\\s", "");
        System.out.println(s1);
        boolean isOdd = s1.length() % 2 != 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            //charFrequencyMap.merge(s1.charAt(i), 1, (a, b)->a+b);
            char character = s1.charAt(i);
            Integer valueInMap = charFrequencyMap.get(character);
            if(valueInMap!=null){
                charFrequencyMap.put(character, ++valueInMap);
            }else{
                charFrequencyMap.put(character, 1);
            }
            System.out.println(charFrequencyMap);
        }
        int[] frequencyArray = charFrequencyMap.values().stream().mapToInt(x->x).toArray();
        boolean isPermutationOfPalindrome = false;
        if(isOdd){
            int oddFrequencyChar = charFrequencyMap.get(s1.charAt(s1.length()/2));
            System.out.println(oddFrequencyChar);
            isPermutationOfPalindrome = oddFrequencyChar%2 != 0;
        }
        int counter = 0;
        for(int i=0; i<frequencyArray.length; i++){
            if(frequencyArray[i]%2==0){
                counter++;
            }
            if(counter==frequencyArray.length-1){
                isPermutationOfPalindrome = true;
            }
        }
        return isPermutationOfPalindrome;
    }


}
