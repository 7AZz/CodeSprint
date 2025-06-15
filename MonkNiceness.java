import java.util.*;

public class MonkNiceness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) words[i] = sc.next();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int niceness = 0;
            for (String key : map.headMap(words[i], false).keySet()) {
                niceness += map.get(key);
            }
            System.out.println(niceness);
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
    }
}
