public class ReverseLinkedList {

    ListNode first;

    ReverseLinkedList(){
        this.first = null;
    }

    ListNode insertFirst(ListNode node){
        node.next = this.first;
        this.first = node;
        return node;
    }

    public static void main(String[] args){
        ReverseLinkedList list = new ReverseLinkedList();
        ListNode node = new ListNode(5);
        list.insertFirst(node);
        list.insertFirst(new ListNode(4));
        list.insertFirst(new ListNode(3));
        list.insertFirst(new ListNode(2));
        list.insertFirst(new ListNode(1));
        System.out.println(list);
        list.reverseBetween(list.first, 0, 0);
        System.out.println(list);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode prev = null;
        int counter = 0;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.first = prev;
        return prev;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode current = this.first;
        while(current != null){
           stringBuilder.append(current.val + " ");
           current = current.next;
       }
        return stringBuilder.toString();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


}
