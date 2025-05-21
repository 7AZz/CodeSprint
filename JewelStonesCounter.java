import java.util.*;

public class JewelStonesCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jewels = sc.next();
        String stones = sc.next();
        int count = 0;

        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1) {
                count++;
            }
        }

        System.out.println(count);
    }
}