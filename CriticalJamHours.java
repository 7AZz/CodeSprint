import java.util.Scanner;

public class CriticalJamHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input: number of hours
        System.out.println("Enter the total no. of hours: ");
        int n = scanner.nextInt();

        int[] vehicles = new int[n];

        // Input: No. of vehicles for each hour
        System.out.println("Enter the number of vehicles for each hour:");
        for (int i = 0; i < n; i++) {
            vehicles[i] = scanner.nextInt();
        }

        int criticalJamHours = 0;

        // Start checking from the second hour (index 1)
        for (int i = 1; i < n; i++) {
            if (vehicles[i] >= 50 && vehicles[i] > vehicles[i - 1]) {
                criticalJamHours++;
            }
        }

        // Output the result
        System.out.println("Number of critical jam hours: " + criticalJamHours);
    }
}