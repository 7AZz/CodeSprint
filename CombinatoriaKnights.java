public class CombinatoriaKnights {
    static int[][] dp = new int[101][101];

    public static int nCr(int n, int r) {
        if (r == 0 || r == n)
            return 1;
        if (dp[n][r] != 0)
            return dp[n][r];
        dp[n][r] = nCr(n - 1, r) + nCr(n - 1, r - 1);
        return dp[n][r];
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt();
        System.out.println(nCr(n, r));
    }
}
