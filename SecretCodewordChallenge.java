import java.util.*;

public class SecretCodewordChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        int[] masks = new int[n];
        int[] lens = new int[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            masks[i] = mask;
            lens[i] = words[i].length();
        }
        int maxStrength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxStrength = Math.max(maxStrength, lens[i] + lens[j]);
                }
            }
        }
        System.out.println(maxStrength);
    }
}
