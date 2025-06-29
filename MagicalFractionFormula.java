import java.util.*;

public class MagicalFractionFormula {
    public static String fractionAddition(String formula) {
        int num = 0, den = 1;
        int i = 0, n = formula.length();
        while (i < n) {
            int sign = 1;
            if (formula.charAt(i) == '+' || formula.charAt(i) == '-') {
                sign = (formula.charAt(i) == '-') ? -1 : 1;
                i++;
            }
            int numStart = i;
            while (i < n && formula.charAt(i) != '/')
                i++;
            int currNum = Integer.parseInt(formula.substring(numStart, i));
            i++;
            int denStart = i;
            while (i < n && Character.isDigit(formula.charAt(i)))
                i++;
            int currDen = Integer.parseInt(formula.substring(denStart, i));
            currNum *= sign;

            num = num * currDen + currNum * den;
            den = den * currDen;
            int g = gcd(Math.abs(num), den);
            num /= g;
            den /= g;
        }
        return num + "/" + den;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String formula = sc.nextLine();
        System.out.println(fractionAddition(formula));
    }
}
