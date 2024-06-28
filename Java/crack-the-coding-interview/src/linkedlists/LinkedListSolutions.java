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
        System.out.println(isPalindromeRecursive(linkedList3, true));
        System.out.println(isPalindromeRecursive(linkedList2, true));

        LinkedList list4 = new LinkedList();
        LinkedList list5 = new LinkedList();
        LinkedList.Link link = list4.new Link(5);
        list4.insertFirst(7);
        list4.insertFirstLink(link, 5);
        list4.insertFirst(4);
        list4.insertFirst(1);

        list5.insertFirst(7);
        list5.insertFirstLink(link, 5);
        list5.insertFirst(6);
        list5.insertFirst(2);

        System.out.println(LinkedListSolutions.intersection(list4, list5));




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

    /*
    This can be done using a stack, as I have done - by finding the middle of the list (if list is odd, skip middle link & remove it)
    - reverse the 2nd half of the linkedlist and compare to the 1st half. Or use recursion (see below)
     */
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

    /**
     * 1) Start at the 1st node of a linked list
     * 2) Iterate through to the final node.
     * 3) Compare then nodes if unequal, return false - else continue
     * 4) Delete both the 1st node and last node from the linked list and recurse.
     * @param linkedList
     * @param flag
     * @return
     */
    static int count = 0;

    static boolean isPalindromeRecursive(LinkedList linkedList, boolean flag){
        System.out.println(++count + ")" + " Linked list: " + linkedList);
        if(!flag){
            return flag;
        }
        if(linkedList.first == null){
            return flag;
        }
        else{
            LinkedList.Link current = linkedList.first;
            LinkedList.Link prev = current;
            while(current.next != null){
                prev = current;
                current = current.next;
            }
            if(current.data == linkedList.first.data){
                prev.next = null;
                linkedList.first = linkedList.first.next;
            }else{
                return false;
            }
            return isPalindromeRecursive(linkedList, flag);
        }
    }

    static LinkedList.Link intersection(LinkedList linkedList1, LinkedList linkedList2){
        LinkedList.Link current = linkedList1.first;
        int offset = 0;
        while(current!=null){
            offset++;
            current = current.next;
        }
        current = linkedList2.first;
        while(current!=null){
            offset--;
            current = current.next;
        }
        if(offset < 0){ //List 2 is longer
            current = linkedList2.first;
            for(int i=offset; i<0; i++){
                current = current.next;
            }
        }else{
            current = linkedList1.first;
            for(int i=0; i<offset; i++){
                current = current.next;
            }
        }
        LinkedList.Link comparisonRef = (offset < 0) ? linkedList1.first : linkedList2.first;
        while(current != null || comparisonRef!=null){
            if(current == comparisonRef){
                System.out.println("The intersecting link is: " + current);
                return current;
            }
            current = current.next;
            comparisonRef = comparisonRef.next;
        }
        return null;

    }

}
