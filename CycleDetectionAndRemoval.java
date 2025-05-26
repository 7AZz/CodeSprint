class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class CycleDetectionAndRemoval {
    public static boolean detectAndRemoveCycle(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;
        boolean hasCycle = false;

        // Detect cycle using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle)
            return true; // No cycle

        // Find the start of the cycle
        slow = head;
        if (slow == fast) {
            // Special case: cycle starts at head
            while (fast.next != slow)
                fast = fast.next;
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        // Remove the cycle
        fast.next = null;
        return true;
    }

    public static ListNode createListWithCycle(int[] vals, int pos) {
        ListNode head = null, tail = null, cycleNode = null;
        for (int i = 0; i < vals.length; i++) {
            ListNode node = new ListNode(vals[i]);
            if (head == null)
                head = node;
            else
                tail.next = node;
            tail = node;
            if (i == pos - 1)
                cycleNode = node;
        }
        if (pos > 0 && tail != null)
            tail.next = cycleNode;
        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < 100) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1: 1 -> 3 -> 4, pos = 2 (cycle at node with value 3)
        int[] vals1 = { 1, 3, 4 };
        int pos1 = 2;
        ListNode head1 = createListWithCycle(vals1, pos1);
        boolean result1 = detectAndRemoveCycle(head1);
        System.out.println(result1); // Output: true
        printList(head1); // Output: 1 -> 3 -> 4

        // Example 2: 1 -> 8 -> 3 -> 4, pos = 0 (no cycle)
        int[] vals2 = { 1, 8, 3, 4 };
        int pos2 = 0;
        ListNode head2 = createListWithCycle(vals2, pos2);
        boolean result2 = detectAndRemoveCycle(head2);
        System.out.println(result2); // Output: true
        printList(head2); // Output: 1 -> 8 -> 3 -> 4
    }
}