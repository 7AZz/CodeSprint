class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class AddReversedNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int sum = v1 + v2 + carry;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            tail = tail.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;
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
        int[] arr1 = { 2, 4, 3 };
        int[] arr2 = { 5, 6, 4 };
        ListNode l1 = buildList(arr1);
        ListNode l2 = buildList(arr2);
        printList(addTwoNumbers(l1, l2)); // Output: 7 -> 0 -> 8

        int[] arr3 = { 9, 9, 9, 9, 9, 9, 9 };
        int[] arr4 = { 9, 9, 9, 9 };
        ListNode l3 = buildList(arr3);
        ListNode l4 = buildList(arr4);
        printList(addTwoNumbers(l3, l4)); // Output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
    }
}