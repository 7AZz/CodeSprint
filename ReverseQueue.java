import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ids = new int[n];
        for (int i = 0; i < n; i++)
            ids[i] = sc.nextInt();
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(ids[i]);
            if (i > 0)
                System.out.print(" ");
        }
    }
}
