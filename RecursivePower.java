public class RecursivePower {
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n < 0)
            return 1.0 / myPow(x, -(long) n);
        double half = myPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    private static double myPow(double x, long n) {
        if (n == 0)
            return 1.0;
        double half = myPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        System.out.printf("%.5f\n", myPow(x, n));
    }
}
