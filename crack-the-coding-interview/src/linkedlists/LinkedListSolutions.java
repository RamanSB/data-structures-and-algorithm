package linkedlists;

import java.util.ArrayDeque;
import java.util.Deque;
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
 * 4) We continue iterating through the linked list until the current link is null.
 *
 * Return kth to last element: Write an algorithm to find the kth to last element in a singly linked list.
 */

public class LinkedListSolutions {

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(9);
        linkedList.insertFirst(7);
        linkedList.insertFirst(6);
        linkedList.insertFirst(2);
        linkedList.insertFirst(5);
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(7);
        linkedList.insertFirst(3);
        System.out.println(linkedList);
        System.out.println("Removing duplicates");
        System.out.println(LinkedListSolutions.kthToLastElement(linkedList, 4));;
        LinkedList linkedList1 = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList1.insertFirst(6);
        linkedList1.insertFirst(1);
        linkedList1.insertFirst(7);
        linkedList2.insertFirst(2);
        linkedList2.insertFirst(9);
        linkedList2.insertFirst(5);
        System.out.println(sumListsReverseOrder(linkedList1, linkedList2));
        System.out.println(sumListInOrder(linkedList1, linkedList2));
        LinkedList linkedList3 = new LinkedList();
        linkedList3.insertFirst(4);
        linkedList3.insertFirst(2);
        linkedList3.insertFirst(1);
        linkedList3.insertFirst(2);
        linkedList3.insertFirst(4);
        System.out.println(isPalindrome(linkedList3));
        System.out.println(isPalindrome(linkedList1));
        System.out.println(isPalindrome(linkedList2));
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

    static LinkedList.Link kthToLastElement(LinkedList linkedList, int k){
        int counter = 0;
        LinkedList.Link current = linkedList.first;
        while(current!=null){
            counter++;
            current = current.next;
        }
        if(k>counter){
            throw new IndexOutOfBoundsException("List is of size " + counter + ". " + k +"th to last element does not exist.");
        }
        current = linkedList.first;
        for(int i=0; i<counter-k; i++){
            current = current.next;
        }
        return current;
    }

    static LinkedList.Link deleteLink(LinkedList linkedList, LinkedList.Link link) {
        LinkedList.Link prev = linkedList.first;
        LinkedList.Link current = linkedList.first;
        while (current != null) {
            if (link.equals(current)) {
                if (link.equals(linkedList.first)) { //Lines 83-85 aren't necessary for this question, it ensures the 1st elem can also be deleted.
                    linkedList.first = linkedList.first.next;
                }
                LinkedList.Link temp = current;
                prev.next = current.next;
                return temp;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }


    static int sumListsReverseOrder(LinkedList linkedList1, LinkedList linkedList2){
        System.out.println("Linked list 1: " + linkedList1);
        System.out.println("Linked list 2: " + linkedList2);
        int count = 0;
        LinkedList.Link current1 = linkedList1.first;
        while(current1 != null){
            count++;
            current1 = current1.next;
        }

        int sum = 0;
        current1 = linkedList1.first;
        for(int i=count-1; i>=0; i--){
            sum += (current1.data * Math.pow(10, i));
            current1 = current1.next;
        }

        LinkedList.Link current2 = linkedList2.first;
        count = 0;
        while(current2 != null){
            count++;
            current2 = current2.next;
        }
        current2 = linkedList2.first;
        for(int i=count-1; i>=0; i--){
            sum += (current2.data * Math.pow(10, i));
            current2 = current2.next;
        }
        return sum;
    }

    static int sumListInOrder(LinkedList linkedList1, LinkedList linkedList2){
        int sum = 0;
        int count = 0;
        LinkedList.Link current = linkedList1.first;
        while(current!=null){
            sum+=(current.data * Math.pow(10, count++));
            current = current.next;
        }
        count = 0;
        current = linkedList2.first;
        while(current!=null){
            sum+=(current.data * Math.pow(10, count++));
            current = current.next;
        }
        return sum;
    }

    static boolean isPalindrome(LinkedList linkedList){
        boolean isPalindrome = false;
        Deque<Integer> stack = new ArrayDeque<>();
        LinkedList.Link current = linkedList.first;
        while(current != null){
            stack.push(current.data);
            current = current.next;
        }
        System.out.println(stack);
        current = linkedList.first;
        for(int i=0; i<stack.size(); i++){
            isPalindrome = (stack.pop()==current.data);
            if(!isPalindrome){
                break;
            }
            current = current.next;
        }
        return isPalindrome;
    }


}
