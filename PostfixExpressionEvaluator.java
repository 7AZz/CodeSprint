import java.util.*;

public class PostfixExpressionEvaluator {
    public static int evalPostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (String token : arr) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;
                        break; // integer division truncates toward zero
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.trim().split("\\s+");
        System.out.println(evalPostfix(arr));
    }
}
