import java.util.*;

public class WarpDriveCalibration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] crystals = new int[n];
        for (int i = 0; i < n; i++)
            crystals[i] = sc.nextInt();
        int target = sc.nextInt();
        Arrays.sort(crystals);

        int closest = crystals[0] + crystals[1] + crystals[2];
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = crystals[i] + crystals[left] + crystals[right];
                int diff = Math.abs(sum - target);
                int closestDiff = Math.abs(closest - target);
                if (diff < closestDiff || (diff == closestDiff && sum > closest)) {
                    closest = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(closest);
    }
}
