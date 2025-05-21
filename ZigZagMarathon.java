import java.util.Scanner;

public class ZigZagMarathon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n > 10) {
            System.out.println("Abhik’s marathon journey intensifies! Let’s see his detailed zig-zag pattern:\n");
        }

        int totalCount = 0;
        int maxWidth = (n - 1) * 4;

        for (int day = 1; day <= n; day++) {
            StringBuilder line = new StringBuilder();

            if (day % 2 == 1) {
                for (int i = 1; i <= day; i++) {
                    line.append(i);
                    if (i != day)
                        line.append("   ");
                    totalCount++;
                }
            } else {
                for (int i = day; i >= 1; i--) {
                    line.append(i);
                    if (i != 1)
                        line.append("   ");
                    totalCount++;
                }
            }

            int padding = (maxWidth - line.length()) / 2;
            for (int s = 0; s < padding; s++) {
                System.out.print(" ");
            }

            System.out.println(line);
        }

        System.out.println("\nTotal numbers printed: " + totalCount);
    }
}
