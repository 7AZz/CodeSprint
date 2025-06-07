import java.util.*;

public class DungeonEscape {
    public static int maxDungeonScore(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);

        for (int i = 1; i < n; i++) {
            // Remove indices out of window
            while (!dq.isEmpty() && dq.peekFirst() < i - k)
                dq.pollFirst();
            dp[i] = nums[i] + dp[dq.peekFirst()];
            // Maintain deque in decreasing order of dp values
            while (!dq.isEmpty() && dp[i] >= dp[dq.peekLast()])
                dq.pollLast();
            dq.addLast(i);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, -2, -5, 7, -6, 4 };
        int k1 = 2;
        System.out.println(maxDungeonScore(nums1, k1)); // Output: 10

        int[] nums2 = { 2, 3, -2, 5, -1, 4 };
        int k2 = 3;
        System.out.println(maxDungeonScore(nums2, k2)); // Output: 14
    }
}
