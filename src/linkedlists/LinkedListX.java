public class LinkedList {

    Node head;

    void insertNode(int data) {
        Node prevNode = head;
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
        } else {
            while (prevNode.next != null) {
                prevNode = prevNode.next;
            }
            prevNode.next = newNode;
        }
    }

    Node remove(int data) {
        Node currentNode = head;
        Node prevNode = currentNode;
        while (currentNode.data != data) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        Node toRemove = currentNode;
        prevNode.next = currentNode.next;
        return toRemove;
    }

    Node search(int key) {
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.data != key) {
                currentNode = currentNode.next;
            } else {
                break;
            }
        }
        return currentNode;
    }

    public String toString() {
        Node currentNode = this.head;
        StringBuilder sb = new StringBuilder();
        while (currentNode != null) {
            sb.append(currentNode);
            currentNode = currentNode.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertNode(3);
        l1.insertNode(8);
        l1.insertNode(10);
        l1.insertNode(14);
        System.out.println(l1);

        LinkedList l2 = new LinkedList();
        l2.insertNode(4);
        l2.insertNode(5);
        l2.insertNode(11);
        l2.insertNode(12);
        l2.insertNode(16);
        l2.insertNode(17);
        System.out.println(l2);

        LinkedList l3 = new LinkedList();
        l3.insertNode(2);
        l3.insertNode(4);
        l3.insertNode(5);
        l3.insertNode(10);

        LinkedList l4 = new LinkedList();
        l4.insertNode(6);
        l4.insertNode(7);
        l4.insertNode(9);
        l4.insertNode(10);


        System.out.println(mergeLists(l1, l2));
        System.out.println(mergeLists(l3, l4));
    }


    class Node {

        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            return this.data+"->";
        }
    }


    /**
     * List 1) is of size n
     * List 2) is of size m
     *
     * Algo runs in O(n+m) and O(n) space for the additional linked list that we store our results in.
     */
    static LinkedList mergeLists(LinkedList l1, LinkedList l2) {
        LinkedList sortedList = new LinkedList();
        Node l1Curr = l1.head;
        Node l2Curr = l2.head;
        while (l1Curr != null && l2Curr != null) {
            if (l1Curr.data < l2Curr.data) {
                sortedList.insertNode(l1Curr.data);
                l1Curr = l1Curr.next;
            } else {
                sortedList.insertNode(l2Curr.data);
                l2Curr = l2Curr.next;
            }
        }
        while (l1Curr != null) {
            sortedList.insertNode(l1Curr.data);
            l1Curr = l1Curr.next;
        }
        while (l2Curr != null) {
            sortedList.insertNode(l2Curr.data);
            l2Curr = l2Curr.next;
        }
        return sortedList;
    }

    /**
     *
     * @param l1 3->8->10->14->
     * @param l2 4->5->11->12->16->17->
     * @return
     */
    static LinkedList mergeListsInToL1(LinkedList l1, LinkedList l2) {
        LinkedList sortedList = new LinkedList();
        Node l1Curr = l1.head; // 3
        Node l2Curr = l2.head; // 4
        if (l1Curr.data < l2Curr.data) { // merge elements in to L1

        }
        Node l1Remaining = l1Curr.next; // 8-10-14
        Node l2Remaining = l2Curr.next; // 5-11-12-16-17
        while (l1Curr != null && l2Curr != null) {
            if (l1Curr.data < l2Curr.data) {

            } else {

            }
        }
        while (l1Curr != null) {

            l1Curr = l1Curr.next;
        }
        while (l2Curr != null) {

            l2Curr = l2Curr.next;
        }
        return sortedList;
    }



}
