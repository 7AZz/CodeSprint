import java.util.*;

public class VowelStartingUniquePatients {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedHashSet<String> uniqueVowelNames = new LinkedHashSet<>();
        String vowels = "aeiou";

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            if (vowels.indexOf(name.charAt(0)) != -1) {
                uniqueVowelNames.add(name);
            }
        }

        System.out.println(uniqueVowelNames.size());`
        for (String name : uniqueVowelNames) {
            System.out.println(name);
        }
    }
}