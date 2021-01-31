package arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * My approach: Create a HashMap<K, V> - Where Keys represent unique characters in the string & values as true/false
 * as to whether a given character is present in the string.
 *
 * Iterate through each character in the string, check if a value exists in the hashmap, if the key has not been added before
 * a null value will be returned, this indicates we are encountering the given char for the 1st time.
 * As we iterate if we encounter this character again within the String, when we attempt to check our map, we will have a value that
 * is non-null - this indicates the character has been encountered before and the string does not consist of unique characters
 */
public class IsUnique {

    public static void main(String[] args){
        System.out.println("Is string unique: " + isStringUnique("fkulsdhfiuahie5hi7awehilufwe"));
        System.out.println("Is string unique: " + isStringUnique("07891724kansdj£"));
        System.out.println("Is string unique: " + isStringUnique("0789124kansdj£"));
    }

    static boolean isStringUnique(String string){
        Map<Character, Boolean> charPresentMap = new HashMap<>();
        for(int i=0; i<string.length(); i++){
            char charAtIndex = string.charAt(i);
            if(charPresentMap.get(charAtIndex)==null){
                charPresentMap.put(charAtIndex, true);
            }else{
                return false;
            }
        }
        return true;
    }
}
