import java.util.*;

public class ParcelPacking {
    public static int minimizeHeaviestBox(int[] parcels, int k) {
        int left = Arrays.stream(parcels).max().getAsInt();
        int right = Arrays.stream(parcels).sum();
        int answer = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int groups = 1, currSum = 0;
            for (int w : parcels) {
                if (currSum + w > mid) {
                    groups++;
                    currSum = w;
                } else {
                    currSum += w;
                }
            }
            if (groups <= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] parcels = new int[n];
        for (int i = 0; i < n; i++)
            parcels[i] = sc.nextInt();
        System.out.println(minimizeHeaviestBox(parcels, k));
    }
}
