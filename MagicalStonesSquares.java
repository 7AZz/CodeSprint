public class MagicalStonesSquares {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1, idx = n - 1;
        while (left <= right) {
            int lSq = nums[left] * nums[left];
            int rSq = nums[right] * nums[right];
            if (lSq > rSq) {
                res[idx--] = lSq;
                left++;
            } else {
                res[idx--] = rSq;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = sortedSquares(nums1);
        for (int x : result1) System.out.print(x + " ");
        System.out.println();

        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] result2 = sortedSquares(nums2);
        for (int x : result2) System.out.print(x + " ");
        System.out.println();
    }
}
