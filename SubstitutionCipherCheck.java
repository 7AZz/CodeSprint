import java.util.*;

public class SubstitutionCipherCheck {
    public static boolean isValidDecoding(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (mapST.containsKey(cs)) {
                if (mapST.get(cs) != ct)
                    return false;
            } else {
                mapST.put(cs, ct);
            }
            if (mapTS.containsKey(ct)) {
                if (mapTS.get(ct) != cs)
                    return false;
            } else {
                mapTS.put(ct, cs);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isValidDecoding(s, t));
    }
}
