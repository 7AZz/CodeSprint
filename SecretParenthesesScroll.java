import java.util.*;

public class SecretParenthesesScroll {
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0)
                    result.append('(');
                depth++;
            } else {
                depth--;
                if (depth > 0)
                    result.append(')');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(removeOuterParentheses(s));
    }
}
