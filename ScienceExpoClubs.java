import java.util.*;

public class ScienceExpoClubs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] themes = new int[n];
        Set<Integer> uniqueThemes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            themes[i] = sc.nextInt();
            uniqueThemes.add(themes[i]);
        }
        if (uniqueThemes.size() < k) {
            System.out.println("NO");
            return;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int t : themes)
            freq.put(t, freq.getOrDefault(t, 0) + 1);
        int atLeastTwo = 0;
        for (int v : freq.values())
            if (v >= 2)
                atLeastTwo++;

        if (uniqueThemes.size() >= 2 * k || atLeastTwo >= 2 * k - uniqueThemes.size()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
