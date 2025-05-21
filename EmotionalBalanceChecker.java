import java.util.*;

public class EmotionalBalanceChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Set<Integer> frequencies = new HashSet<>(freqMap.values());

        if (frequencies.size() == 1) {
            System.out.println("Aashriya smiles: Emotional balance found.");
        } else {
            System.out.println("Aashriya wonders: These thoughts were scattered.");
        }
    }
}
