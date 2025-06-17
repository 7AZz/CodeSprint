import java.util.*;

public class BinaryStringSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int ones = 0;
        for (char c : s.toCharArray())
            if (c == '1')
                ones++;
        int zeros = n - ones;
        int misplaced = 0;

        for (int i = 0; i < zeros; i++) {
            if (s.charAt(i) == '1')
                misplaced++;
        }
        System.out.println(misplaced);
    }
}
