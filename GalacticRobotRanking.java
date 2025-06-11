import java.util.*;

public class GalacticRobotRanking {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] sorted = score.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rankMap.put(sorted[i], n - i);
        }
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int rank = rankMap.get(score[i]);
            if (rank == 1)
                result[i] = "Gold Medal";
            else if (rank == 2)
                result[i] = "Silver Medal";
            else if (rank == 3)
                result[i] = "Bronze Medal";
            else
                result[i] = String.valueOf(rank);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] score1 = { 50, 80, 30, 100 };
        System.out.println(Arrays.toString(findRelativeRanks(score1)));
        int[] score2 = { 23, 45, 67, 12, 89 };
        System.out.println(Arrays.toString(findRelativeRanks(score2)));
    }
}