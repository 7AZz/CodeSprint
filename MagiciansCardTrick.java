import java.util.*;

public class MagiciansCardTrick {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> dq = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!dq.isEmpty()) {
                dq.addFirst(dq.removeLast());
            }
            dq.addFirst(deck[i]);
        }
        int[] result = new int[deck.length];
        int idx = 0;
        for (int num : dq) {
            result[idx++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] deck1 = { 5, 12, 9 };
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck1))); // [5, 9, 12]

        int[] deck2 = { 1, 10, 3, 8, 6 };
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck2))); // [1, 3, 6, 8, 10]
    }
}