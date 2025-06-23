public class GoodDigitStrings {
    public static int countGoodStrings(int n) {
        if (n == 0)
            return 1;
        if ((n - 1) % 2 == 0) {
            return 5 * countGoodStrings(n - 1);
        } else {
            return 4 * countGoodStrings(n - 1);
        }
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countGoodStrings(n));
    }
}
