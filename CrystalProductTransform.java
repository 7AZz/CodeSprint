import java.util.*;

public class CrystalProductTransform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] crystals = new int[n];
        for (int i = 0; i < n; i++)
            crystals[i] = sc.nextInt();

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * crystals[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * crystals[i + 1];
        }
        for (int i = 0; i < n; i++) {
            System.out.print((left[i] * right[i]));
            if (i < n - 1)
                System.out.print(" ");
        }
    }
}
