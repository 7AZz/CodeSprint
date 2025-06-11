import java.util.*;

public class CrateFrequencySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        Integer[] sorted = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted, (a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb)
                return fb - fa;
            return a - b;
        });
        for (int i = 0; i < n; i++) {
            System.out.print(sorted[i]);
            if (i < n - 1)
                System.out.print(" ");
        }
    }
}
