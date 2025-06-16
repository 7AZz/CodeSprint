public class LeaderSelection {
    public static int missingBadge(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i <= n; i++)
            xor ^= i;
        for (int num : nums)
            xor ^= num;
        return xor;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 0, 3 };
        System.out.println(missingBadge(nums1)); // Output: 2

        int[] nums2 = { 5, 2, 0, 4, 1 };
        System.out.println(missingBadge(nums2)); // Output: 3
    }
}
