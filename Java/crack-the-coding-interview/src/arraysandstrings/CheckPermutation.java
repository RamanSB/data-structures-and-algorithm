package arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 *
 * I'm also aware that lines 36-41 can be replaced with a call to charFrequencyMap.merge(s1.charAt(i), 1, Integer::sum)
 * P.S: a maps merge method takes a key, value & bifunction, if the key does not have a value associated with it, the value passed
 * will be used, however if a value exists, we will set the new value to the output of the bifunction provided.
 *
 * My approach:
 * A string can only be a permutation of another string if the characters in both strings occur with the same frequency.
 * We can create a Hashmap with key values being characters and values being integer which are incremented when a character
 * is encountered.
 * We iterate through the characters of the 1st string and we put a character in the map with a value of 1 if we have not encountered it before
 * or we increment the counter if we encounter the value again.
 * We then iterate through the characters of the 2nd String, each time we encounter a character in the 2nd string, we check
 * if a value exists for it in the map, if not we return false - as we have encountered a character that does not occur in the 1st String.
 * Otherwise if a value exists in the map we decrement the value, if a String is a permutation of another string, the
 * map should end with a value of 0 for all keys.
 *
 *
 * ToDo: Learn how to perform a merge sort/quick sort
 * Another approach:
 * Perform a sort O(NlogN) [merge/quick] on the 1st String.
 * Iterate through the 2nd String for each character we encounter perform a binary search on the 1st String.
 * Once a character is matched, remove it from the sorted string & perform another binary search using the 2nd character in the 2nd string
 * so on so forth... O(NlogN) Time complexity
 *
 */
public class CheckPermutation {

    static boolean isPermutation(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }

        Map<Character, Integer> charFrequencyMap = new HashMap();
        for(int i=0; i<s1.length(); i++){
            Integer valueInMap = charFrequencyMap.get(s1.charAt(i));
            if(valueInMap == null) {
                charFrequencyMap.put(s1.charAt(i), 1);
            }else{
                charFrequencyMap.put(s1.charAt(i), valueInMap+1);
            }
        }
        for(int i=0; i<s2.length(); i++){
            Integer value = charFrequencyMap.get(s2.charAt(i));
            if(value!=null){
                charFrequencyMap.put(s2.charAt(i), --value);
            }else{
                return false;
            }
        }
        return charFrequencyMap.values().stream().allMatch(x->x==0);
    }

    public static void main(String[] args){
        System.out.println(isPermutation("cat", "tca"));
    }
}
