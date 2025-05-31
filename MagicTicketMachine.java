class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MagicTicketMachine {
    public static ListNode doubleNumber(ListNode head) {

        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode revHead = prev;

        int carry = 0;
        ListNode dummy = new ListNode(0), tail = dummy;
        curr = revHead;
        while (curr != null) {
            int sum = curr.val * 2 + carry;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            tail = tail.next;
            curr = curr.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        prev = null;
        curr = dummy.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : arr) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

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

    public static void main(String[] args) {
        int[] arr1 = { 2, 5, 6 };
        ListNode head1 = buildList(arr1);
        printList(doubleNumber(head1)); // Output: 5 -> 1 -> 2

        int[] arr2 = { 7, 6 };
        ListNode head2 = buildList(arr2);
        printList(doubleNumber(head2)); // Output: 1 -> 5 -> 2

        int[] arr3 = { 5 };
        ListNode head3 = buildList(arr3);
        printList(doubleNumber(head3)); // Output: 1 -> 0
    }
}
