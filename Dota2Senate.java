import java.util.*;

public class Dota2Senate {
    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                radiant.add(i);
            else
                dire.add(i);
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();
            if (r < d)
                radiant.add(r + n);
            else
                dire.add(d + n);
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String senate = sc.nextLine();
        System.out.println(predictPartyVictory(senate));
    }
}
