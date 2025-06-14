import java.util.*;

public class SpellheavenDuel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] merlin = new int[n];
        for (int i = 0; i < n; i++)
            merlin[i] = sc.nextInt();
        int m = sc.nextInt();
        int maxMorgana = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int val = sc.nextInt();
            if (val > maxMorgana)
                maxMorgana = val;
        }
        int minMana = 0;
        int minRequired = maxMorgana + 1;
        for (int power : merlin) {
            if (power < minRequired)
                minMana += (minRequired - power);
        }
        System.out.println(minMana);
    }
}
