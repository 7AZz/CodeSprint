import java.util.*;

public class PacketNesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        int maxFreq = 0;
        for (int f : freq.values()) {
            if (f > maxFreq)
                maxFreq = f;
        }
        System.out.println(maxFreq);
    }
}
