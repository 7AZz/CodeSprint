import java.util.*;

public class CheckerboardSeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                    count++;
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("Total students seated: " + count);
    }
}
