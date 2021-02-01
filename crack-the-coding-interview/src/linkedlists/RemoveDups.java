package linkedlists;

import java.util.HashMap;
import java.util.Map;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 *
 * My approach:
 * 1) Create a Hashmap with Keys=Link & Value=Boolean representing whether the value been encountered before in the linked list.
 * 2) Iterate through the linked list keeping a reference on both the current link & the previous link.
 * 3) We will put each link we encounter in to our hashtable/map, however if the key already exists with a non-null value
 *    it is a duplicate and must be removed, we then set the previous.next = current.next, this 'cuts' out the duplicate link.
 * 4) We continue iteraing through the linked list until the current link is null.
 */

public class RemoveDups {

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(9);
        linkedList.insertFirst(7);
        linkedList.insertFirst(6);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(7);
        linkedList.insertFirst(3);
        System.out.println(linkedList);
        System.out.println("Removing duplicates");
        RemoveDups.removeDuplicates(linkedList);
        System.out.println(linkedList);
    }

    static LinkedList removeDuplicates(LinkedList linkedList){
        Map<LinkedList.Link, Boolean> duplicateLinkMap = new HashMap<>();
        LinkedList.Link current = linkedList.first;
        LinkedList.Link prev = linkedList.first;
        while(current != null){
            Boolean isDuplicate = duplicateLinkMap.get(current);
            if(isDuplicate == null){
                duplicateLinkMap.put(current, true);
            }else{
                prev.next = current.next;
            }
            prev = current;
            current = current.next;
        }
        return linkedList;
    }
}
