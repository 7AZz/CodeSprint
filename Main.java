import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // enter number of days (size of temperature array)
        System.out.println("Enter number of days:");
        int n = sc.nextInt();

        int[] temps = new int[n];

        // enter the temperature readings
        System.out.println("Enter " + n + " temperature readings:");
        for (int i = 0; i < n; i++) {
            temps[i] = sc.nextInt();
        }

        // Initialize maxLength to keep track of the longest increasing subarray
        int maxLength = 1;
        int currentLength = 1;

        // Traverse the array to find the longest strictly increasing subarray
        for (int i = 1; i < n; i++) {
            if (temps[i] > temps[i - 1]) {
                // Continue increasing sequence
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Reset currentLength when sequence breaks
                currentLength = 1;
            }
        }

        // Output the result
        System.out.println("Length of longest strictly increasing subarray: " + maxLength);
    }
}