import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ParadeLeaderSelection {

    public static List<Integer> middleToEnd(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        List<Integer> result = new ArrayList<>();
        while (slow != null) {
            result.add(slow.val);
            slow = slow.next;
        }
        return result;
    }

    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : arr) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example 1: [1, 2, 3, 4, 5] -> Output: [3, 4, 5]
        int[] arr1 = { 1, 2, 3, 4, 5 };
        ListNode head1 = buildList(arr1);
        System.out.println(middleToEnd(head1));

        // Example 2: [1, 2, 3, 4, 5, 6] -> Output: [4, 5, 6]
        int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        ListNode head2 = buildList(arr2);
        System.out.println(middleToEnd(head2));
    }
}
