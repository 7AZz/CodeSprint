import java.util.*;

public class WesterosHeaterRadius {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);
            if (idx < 0)
                idx = -idx - 1;
            int dist1 = idx < heaters.length ? Math.abs(heaters[idx] - house) : Integer.MAX_VALUE;
            int dist2 = idx > 0 ? Math.abs(heaters[idx - 1] - house) : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] houses1 = { 1, 2, 3 };
        int[] heaters1 = { 2 };
        System.out.println(findRadius(houses1, heaters1)); // Output: 1

        int[] houses2 = { 1, 5 };
        int[] heaters2 = { 2 };
        System.out.println(findRadius(houses2, heaters2)); // Output: 3
    }
}
