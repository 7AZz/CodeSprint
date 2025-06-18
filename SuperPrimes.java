import java.util.*;

public class SuperPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (long j = (long) i * i; j <= n; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }

        int maxIdx = primes.size();
        boolean[] isPrimeIdx = new boolean[maxIdx + 1];
        Arrays.fill(isPrimeIdx, true);
        isPrimeIdx[0] = isPrimeIdx[1] = false;
        for (int i = 2; i * i <= maxIdx; i++) {
            if (isPrimeIdx[i]) {
                for (int j = i * i; j <= maxIdx; j += i) {
                    isPrimeIdx[j] = false;
                }
            }
        }

        List<Integer> superPrimes = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            int idx = i + 1; // 1-based index
            if (isPrimeIdx[idx]) {
                superPrimes.add(primes.get(i));
            }
        }

        for (int i = 0; i < superPrimes.size(); i++) {
            System.out.print(superPrimes.get(i));
            if (i < superPrimes.size() - 1)
                System.out.print(" ");
        }
    }
}
