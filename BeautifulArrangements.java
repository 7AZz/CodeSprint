import java.util.*;

public class BeautifulArrangements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }
        List<Integer> unique = new ArrayList<>(set);
        Collections.sort(unique);
        int count = 0;
        int sz = unique.size();
        // For each pair (first, last) with first > last
        for (int i = sz - 1; i >= 1; i--) {
            count += i;
        }
        System.out.println(count);
    }
}