import java.util.*;

public class PostfixToPrefixTransformer {
    public static String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(String.valueOf(c));
            } else {
                String right = stack.pop();
                String left = stack.pop();
                String expr = c + left + right;
                stack.push(expr);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String postfix = sc.nextLine();
        System.out.println(postfixToPrefix(postfix));
    }
}
