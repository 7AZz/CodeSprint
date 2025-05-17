import java.util.Scanner;

public class ArcheryPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for number of shots
        System.out.print("Enter the number of shots: ");
        int n = scanner.nextInt();
        int[] scores = new int[n];

        // Ask for each score
        System.out.println("Enter the scores of each shot (between 0 and 10):");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int goodShots = 0;
        int missedShots = 0;

        // Count good and missed shots
        for (int i = 0; i < n; i++) {
            if (scores[i] >= 7) {
                goodShots++;
            } else {
                missedShots++;
            }
        }

        // Display the result
        System.out.println("Number of good shots (score ≥ 7): " + goodShots);
        System.out.println("Number of missed shots (score < 7): " + missedShots);
    }
}
