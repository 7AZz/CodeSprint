import java.util.Scanner;

public class MagicalDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of days
        System.out.print("Enter the number of days: ");
        int n = sc.nextInt();

        // Create an array to store scores for each day
        int[] scores = new int[n];
        System.out.print("Enter the scores for each day: ");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt(); // input scores
        }

        // Initialize a counter for magical days
        int magicalDays = 0;

        // Loop from the second day to the second-last day
        // because the first and last days cannot be magical
        for (int i = 1; i < n - 1; i++) {
            // Check if current day's score is greater than both neighbors
            if (scores[i] > scores[i - 1] && scores[i] > scores[i + 1]) {
                magicalDays++; // increase the count
            }
        }

        // Print the result
        System.out.println("Number of magical days: " + magicalDays);
    }
}
