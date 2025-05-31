class ListNode {
    String val;
    ListNode next;

    ListNode(String val) {
        this.val = val;
    }
}

public class ShoppingListReversal {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;
        ListNode dummy = new ListNode("");
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++)
            prev = prev.next;
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }

    public static ListNode buildList(String[] arr) {
        ListNode dummy = new ListNode(""), tail = dummy;
        for (String v : arr) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static String[] toArray(ListNode head) {
        java.util.List<String> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] arr1 = { "Bread", "Eggs", "Milk", "Cheese", "Tomatoes" };
        ListNode head1 = buildList(arr1);
        head1 = reverseBetween(head1, 2, 4);
        System.out.println(java.util.Arrays.toString(toArray(head1))); // ["Bread", "Cheese", "Milk", "Eggs",
                                                                       // "Tomatoes"]

        String[] arr2 = { "Bread", "Eggs", "Milk", "Cheese", "Tomatoes" };
        ListNode head2 = buildList(arr2);
        head2 = reverseBetween(head2, 1, 5);
        System.out.println(java.util.Arrays.toString(toArray(head2))); // ["Tomatoes", "Cheese", "Milk", "Eggs",
                                                                       // "Bread"]
    }
}
