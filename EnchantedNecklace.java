class DoublyListNode {
    int val;
    DoublyListNode prev, next;

    DoublyListNode(int val) {
        this.val = val;
    }
}

public class EnchantedNecklace {
    public static DoublyListNode removeCursed(DoublyListNode head, int target) {
        DoublyListNode curr = head;
        // Move head to the first non-target node
        while (curr != null && curr.val == target) {
            curr = curr.next;
        }
        head = curr;
        if (head == null)
            return null;

        DoublyListNode prev = null;
        while (curr != null) {
            if (curr.val == target) {
                DoublyListNode next = curr.next;
                if (prev != null)
                    prev.next = next;
                if (next != null)
                    next.prev = prev;
                curr = next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static DoublyListNode buildList(int[] arr) {
        DoublyListNode head = null, tail = null;
        for (int v : arr) {
            DoublyListNode node = new DoublyListNode(v);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
        return head;
    }

    public static void printList(DoublyListNode head) {
        DoublyListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null)
                System.out.print(" ⇄ ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 1, 4 };
        DoublyListNode head1 = buildList(arr1);
        head1 = removeCursed(head1, 1);
        printList(head1);

        int[] arr2 = { 2, 3, -1, 4, 2 };
        DoublyListNode head2 = buildList(arr2);
        head2 = removeCursed(head2, 2);
        printList(head2);

        int[] arr3 = { 5, 5, 5 };
        DoublyListNode head3 = buildList(arr3);
        head3 = removeCursed(head3, 5);
        printList(head3);
    }
}
