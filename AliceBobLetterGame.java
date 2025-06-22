import java.util.*;

public class AliceBobLetterGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int pos = k - 1;
        int inc = 0;
        while (pos > 0) {
            pos = (pos - 1) / 2;
            inc++;
        }
        char letter = (char) ('A' + (inc % 26));
        System.out.println(letter);
    }
}
