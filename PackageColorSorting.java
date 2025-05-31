class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PackageColorSorting {
    public static ListNode sortColors(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode zeroDummy = new ListNode(0), zeroTail = zeroDummy;
        ListNode oneDummy = new ListNode(0), oneTail = oneDummy;
        ListNode twoDummy = new ListNode(0), twoTail = twoDummy;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.val == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }

        // Connect the three lists
        zeroTail.next = oneDummy.next != null ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;

        return zeroDummy.next;
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
        // Input: 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head = sortColors(head);
        printList(head); // Output: 0 -> 1 -> 1 -> 2 -> 2 -> 2 -> 2 -> 2
    }
}
