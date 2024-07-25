

class ListNode {
    val: any;
    next: ListNode | null;

    constructor(val: any) {
        this.val = val;
        this.next = null;
    }

}

/**
 * Queue backed by Singly Linked List Impl
 * 
 * Ref:    FRONT                BACK
 * Queue: "James" <- "John" <- "Jacob"
 * Underlying LL: "James" -> "John" -> "Jacob" -> Null
 * Starting at the front and invoking.next would take us to John, the linked list is in the reverse direction of the queue.
 * Operations: 
 * - Enqueue: Add Node to Tail
 * - Dequeue: Remove node at head.
 * FIFO (Add to the back of queue and remove from the front of the queue).
 * 
 */
class Queue {

    private front: ListNode | null;
    private back: ListNode | null;

    constructor() {
        this.front = null;
        this.back = null;
    }

    public enqueue(val: any) {
        const newNode = new ListNode(val);
        if (this.back) {
            this.back.next = newNode;
            this.back = newNode;
        } else {
            // Queue is empty (if this.back is null)
            // Point both the front and back of the queue to the only added node.
            this.front = newNode;
            this.back = newNode;
        }
    }

    public dequeue(): any {
        if (!this.front) {
            console.log("No element to dequeue.")
            return;
        }
        const nodeToRemoveVal = this.front.val;
        // Check if there is an existing node in the list that will become the new front.
        if (this.front.next) {
            this.front = this.front.next;
        } else {
            // If there's only 1 node at the front 
            this.front = null;
            this.back = null;
        }
        console.log("Dequeued: ", nodeToRemoveVal);
        return nodeToRemoveVal;
    }

    public printQueue() {
        let str: any = "";
        if (this.front) {
            let current: ListNode | null = this.front;
            while (current != null) {
                str += current.val + " -> ";
                current = current.next;
            }
        }
        console.log("LinkedList looks like this: ", str);
        console.log("Queue looks like this in reality: ", str?.replaceAll("->", "<-"));
        return str;
    }

}

function demo() {
    let queue: Queue = new Queue();
    queue.printQueue();
    queue.enqueue("John");
    queue.enqueue("Jacob");
    queue.printQueue();
    queue.dequeue();
    queue.dequeue();
    queue.printQueue();
    queue.enqueue("John");
    queue.enqueue("Jacob");
    queue.enqueue("Jenny");
    queue.enqueue("James");
    queue.enqueue("Jovan");
    queue.printQueue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
}

demo();