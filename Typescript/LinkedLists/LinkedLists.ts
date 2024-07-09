
/**
 * Note: Singly LinkedList. 
 * 
 * A simple class representing a Node that can contain data of generic type T.
 * The node contains a reference to the subsequent node in the list (null if it doesn't exist)
 */
class ListNode<T> {

    data: T;
    next: ListNode<T> | null = null;

    constructor(data: T) {
        this.data = data;
    }

}

interface ILinkedList<T> {
    // Insert - insertAtHead or insertAtTail
    insertAtHead(data: T): void
    insertAtTail(data: T): void
    // Search
    find(data: T): ListNode<T> | null
    // Delete
    delete(data: T): void
    printList(): void

}

class LinkedList<T> implements ILinkedList<T> {

    head: ListNode<T> | null = null;

    insertAtHead(data: T): void {
        let newNode: ListNode<T> = new ListNode<T>(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    insertAtTail(data: T): void {
        let newNode: ListNode<T> = new ListNode<T>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            let currentNode = this.head;
            while (currentNode.next !== null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    find(data: T): ListNode<T> | null {

        let currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.data == data) {
                console.log("Found node: ", data)
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        console.log(`Unable to find ${data} within the linked list.`)
        return null;

    }


    /**
     * When deleting a node, we must ensure that the previous node's next reference is the deleted nodes next reference. 
     * Hence we must keep track of the previous node and the current node we are deleting.
     * 
     * Cases to consider: 
     *  - When there is no head node.
     *  - When head node is the node to be deleted.
     *  - Node to delete cannot be found.
     */
    delete(data: T): void {
        if (!this.head) {
            console.log("List is empty, nothing to delete.");
            return;
        }

        if (this.head.data == data) {
            console.log("Deleted head node : ", data)
            this.head = this.head.next;
            return;
        }

        let current = this.head;
        while (current.next != null && current.next.data !== data) {
            current = current.next;
        }

        if (current.next == null) {
            console.log(`Unable to find ${data} to delete.`);
            return;
        }
        // If we are here that means current.next is the node to delete. (current -> current.next -> current.next.next)
        console.log("Deleted node: " + data);
        current.next = current.next.next; // here we are saying replace current.next with the value that is next after that.

    }

    printList(): void {
        const values: T[] = [];
        let currentNode: ListNode<T> | null = this.head;
        if (currentNode) {
            do {
                values.push(currentNode.data);
                currentNode = currentNode.next;
            } while (currentNode != null)
        } else {
            console.log("List is empty.");
        }
        console.log(values);
    }
}

function demoSinglyLinkedList() {
    const ll: LinkedList<number> = new LinkedList<number>();
    ll.printList() // List is empty
    ll.insertAtHead(10); // 10 -> null
    ll.insertAtHead(25) // 25 -> 10
    ll.insertAtTail(30); // 25 -> 10 -> 30;
    ll.printList();
    ll.find(15); // Unable to find 15 within the linked list.
    ll.find(30); // Finds value
    ll.insertAtHead(5); // 5 -> 25 -> 10 -> 30
    ll.printList();
    ll.delete(5);
    ll.delete(30);
    ll.insertAtHead(30); // 30 -> 25 -> 10
    ll.find(25);
    ll.printList();
}

demoSinglyLinkedList();