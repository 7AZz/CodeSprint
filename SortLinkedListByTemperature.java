class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SortLinkedListByTemperature {
    public static ListNode sortByActualValues(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode negDummy = new ListNode(0);
        ListNode negTail = negDummy;

        ListNode posDummy = new ListNode(0);
        ListNode posTail = posDummy;

        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val < 0) {
                // Insert at front of negative list (to reverse order)
                curr.next = negTail.next;
                negTail.next = curr;
            } else {
                posTail.next = curr;
                posTail = posTail.next;
                posTail.next = null;
            }
            curr = next;
        }

        // Find the end of the negative list
        ListNode negHead = negDummy.next;
        if (negHead == null)
            return posDummy.next;

        // Find the last node of the negative list
        ListNode negLast = negHead;
        while (negLast.next != null)
            negLast = negLast.next;
        // Attach positive list after negative list
        negLast.next = posDummy.next;

        return negHead;
    }

    // Helper to print the list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null)
                System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // Input: 1 -> -2 -> -3 -> 4 -> -5
        ListNode head = new ListNode(1);
        head.next = new ListNode(-2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(-5);

        head = sortByActualValues(head);
        printList(head); // Output: -5 -> -3 -> -2 -> 1 -> 4
    }
}