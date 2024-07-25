
class MyLinkedList {
    head: ListNode | null;

    constructor() {
        this.head = null;
    }

    get(index: number): number {
        if (!this.head) {
            return -1;
        }

        let current: ListNode | null = this.head;
        let counter: number = 0;
        while (current) {
            if (index == counter) {
                return current.val;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }

    addAtHead(val: number): void {
        const newHead: ListNode = new ListNode(val);
        newHead.next = this.head;
        this.head = newHead;
    }

    addAtTail(val: number): void {
        if (!this.head) {
            this.addAtHead(val);
        } else {
            let current: ListNode | null = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = new ListNode(val);
        }
    }

    addAtIndex(index: number, val: number): void {
        if (index === 0) { // Simplified condition
            this.addAtHead(val);
            return;
        }

        let current: ListNode | null = this.head;
        let prev: ListNode | null = null;
        for (let i = 0; i < index; i++) {
            if (!current) {
                return; // Handle out-of-bounds within loop
            }
            prev = current;
            current = current.next;
        }
        const newNode: ListNode = new ListNode(val);
        if (prev) {
            prev.next = newNode;
        }
        newNode.next = current;
    }

    deleteAtIndex(index: number): void {
        if (!this.head) {
            return;
        }

        let current: ListNode | null = this.head;
        let prev: ListNode | null = null;

        if (index === 0) {
            this.head = this.head.next;
            return;
        }

        for (let i = 0; i < index; i++) {
            if (!current) {
                return; // Handle out-of-bounds within loop
            }
            prev = current;
            current = current.next;
        }
        if (current && prev) {
            prev.next = current.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */