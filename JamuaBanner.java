import java.util.*;

public class JamuaBanner {
    public static String rearrangeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.add(new int[] { freq[i], i });
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = { 0, -1 };
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            sb.append((char) (curr[1] + 'a'));
            curr[0]--;
            if (prev[0] > 0)
                pq.add(prev);
            prev = curr;
        }
        // for adjacent duplicates
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == sb.charAt(i - 1))
                return "";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(rearrangeString(s));
    }
}
