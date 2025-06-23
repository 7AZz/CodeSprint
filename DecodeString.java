import java.util.*;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                strStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder prev = strStack.pop();
                int count = countStack.pop();
                for (int i = 0; i < count; i++)
                    prev.append(curr);
                curr = prev;
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(decodeString(s));
    }
}
