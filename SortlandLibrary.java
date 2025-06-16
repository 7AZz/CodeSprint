public class SortlandLibrary {
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 4, 6 };
        int target1 = 5;
        System.out.println(searchInsert(nums1, target1)); // Output: 2

        int[] nums2 = { 2, 4, 6, 8 };
        int target2 = 6;
        System.out.println(searchInsert(nums2, target2)); // Output: 2
    }
}
