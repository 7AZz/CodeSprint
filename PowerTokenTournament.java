import java.util.*;

public class PowerTokenTournament {
    public static int maxScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int score = 0, maxScore = 0;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0 && left < right) {
                power += tokens[right--];
                score--;
            } else {
                break;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tokens = new int[n];
        for (int i = 0; i < n; i++)
            tokens[i] = sc.nextInt();
        int power = sc.nextInt();
        System.out.println(maxScore(tokens, power));
    }
}
