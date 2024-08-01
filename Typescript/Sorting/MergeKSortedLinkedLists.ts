


function mergeList(l1: ListNode | null, l2: ListNode | null): ListNode | null {

    if (!l1) {
        return l2;
    }
    if (!l2) {
        return l1;
    }

    // Determine starting node
    let mergedHead = l1.val <= l2.val ? l1 : l2;
    let head = mergedHead;
    if (mergedHead == l1) {
        l1 = l1.next;
    } else {
        l2 = l2.next;
    }

    while (l1 && l2) {
        if (l1.val <= l2.val) {
            mergedHead.next = l1;
            l1 = l1.next;
        } else {
            mergedHead.next = l2;
            l2 = l2.next;
        }
        mergedHead = mergedHead.next;
    }

    if (l1) {
        mergedHead.next = l1;
    }
    if (l2) {
        mergedHead.next = l2;
    }
    return head;
}

