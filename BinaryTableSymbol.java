import java.util.*;

public class BinaryTableSymbol {
    public static int kthSymbol(int n, int k) {
        if (n == 1)
            return 0;
        int parent = kthSymbol(n - 1, (k + 1) / 2);
        // If k is odd, symbol is same as parent; if even, it's flipped
        if (k % 2 == 1)
            return parent;
        else
            return 1 - parent;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        System.out.println(kthSymbol(n, k));
    }
}
