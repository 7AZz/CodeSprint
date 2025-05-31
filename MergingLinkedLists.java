class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergingLinkedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
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
        int[] arr1 = { 1, 2, 4 };
        int[] arr2 = { 1, 3, 4 };
        ListNode list1 = buildList(arr1);
        ListNode list2 = buildList(arr2);
        ListNode merged = mergeTwoLists(list1, list2);
        printList(merged); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4

        int[] arr3 = {};
        int[] arr4 = {};
        printList(mergeTwoLists(buildList(arr3), buildList(arr4))); // Output: (empty)

        int[] arr5 = {};
        int[] arr6 = { 3, 4 };
        printList(mergeTwoLists(buildList(arr5), buildList(arr6))); // Output: 3 -> 4
    }
}
