public class MagicalPotionSum {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        double r = 1.0 / 3.0;
        double sum = (1 - Math.pow(r, n + 1)) / (1 - r);

        sum -= Math.pow(r, n + 1);

        sum = (1 - Math.pow(r, n)) / (1 - r);
        System.out.printf("%.5f\n", sum);
    }
}
