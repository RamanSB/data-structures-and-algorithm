/**
 * Doubly Linked List Node 7
 */
class DoublyListNode {

    val: any;
    next: DoublyListNode | null;
    prev: DoublyListNode | null;

    constructor(val: any) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}


/**
 * Pronounced as "Deck", a double-ended queue. 
 * 
 * In addition to the existing queue operations / methods: enqueue() and dequeue() (which we will refer to as addBack() and popFront())
 * we must also implement (addFront() and popBack()). 
 * 
 * We will achieve the implementatino of this Deque using a doubly-linked-list.
 * 
 * Consider a Deque: 
 *      ["Thomas", "James", "Stefan", "Jovan", "Kavan", "Raman"]
 *        FRONT                                           BACK 
 *         NULL <- Thomas <-> 
 *   
 */
class Deque {

    private front: DoublyListNode | null;
    private back: DoublyListNode | null;

    constructor() {
        this.front = null;
        this.back = null;
    }


    // Existing Queue Methods

    addBack(val: any): void {
        const newNode: DoublyListNode | null = new DoublyListNode(val);
        if (this.back) {
            newNode.prev = this.back;
            this.back.next = newNode;
            this.back = newNode;
            return;
        }
        // Otherwise queue is empty
        this.front = newNode;
        this.back = newNode;
    }

    popFront(): any {
        const nodeToRemove = this.front;
        if (nodeToRemove) {
            // Is there an existing node that can be at the front of the queue?
            const newFront: DoublyListNode | null = nodeToRemove.next;
            if (newFront) {
                this.front = newFront;
                this.front.prev = null;
            } else {
                this.front = null;
                this.back = null;
            }
            console.log(`Removed ${nodeToRemove.val} from front.`);
            return nodeToRemove.val;
        } else {
            console.log("Deque is empty, nothing to remove.")
            return;
        }
    }

    // Additional Dequeue methods.
    addFront(val: any): void {
        const newNode: DoublyListNode | null = new DoublyListNode(val);
        if (!this.front) { // No elements in the queue exist, this will be the first?
            this.front = newNode;
            this.back = newNode;
        } else { // Node exists at the front already.
            this.front.prev = newNode;
            newNode.next = this.front;
            this.front = newNode;
        }
    }

    popBack(): any {
        const nodeToRemove: DoublyListNode | null = this.back;
        if (nodeToRemove) {
            const newBack: DoublyListNode | null = nodeToRemove.prev;
            if (newBack) {
                newBack.next = null;
                this.back = newBack;
            } else { // Only nodeToRemove exists in the Deque
                this.front = null;
                this.back = null;
            }
            console.log(`Removed ${nodeToRemove.val} from back.`)
            return nodeToRemove.val;
        } else {
            console.log("Deque is empty, nothing to remove.")
        }
    }


    // Method for Printing the Deque
    printDeque(): void {
        let current: DoublyListNode | null = this.front;
        let dequeString = "";
        while (current !== null) {
            dequeString += current.val + " <-> ";
            current = current.next;
        }
        if (dequeString.length > 0) {
            dequeString = dequeString.slice(0, -5); // Remove the last " <-> "
        }
        console.log("Deque: " + dequeString);
    }

}

// Demo usage
const deque = new Deque();
deque.addBack("Thomas");
deque.addBack("James");
deque.addBack("Stefan");
deque.addBack("Jovan");
deque.addBack("Kavan");
deque.addBack("Raman");
deque.printDeque(); // Deque: Thomas <-> James <-> Stefan <-> Jovan <-> Kavan <-> Raman
deque.popFront();
deque.printDeque(); // Deque: James <-> Stefan <-> Jovan <-> Kavan <-> Raman
deque.popBack();
deque.printDeque(); // Deque: James <-> Stefan <-> Jovan <-> Kavan
deque.addFront("Andrew");
deque.printDeque(); // Deque: Andrew <-> James <-> Stefan <-> Jovan <-> Kavan