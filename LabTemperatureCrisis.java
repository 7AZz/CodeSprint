import java.util.*;

public class LabTemperatureCrisis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("PUSH")) {
                int x = Integer.parseInt(line.split(" ")[1]);
                stack.push(x);
                if (minStack.isEmpty() || x <= minStack.peek()) {
                    minStack.push(x);
                }
            } else if (line.equals("POP")) {
                if (!stack.isEmpty()) {
                    int popped = stack.pop();
                    if (!minStack.isEmpty() && popped == minStack.peek()) {
                        minStack.pop();
                    }
                }
            } else if (line.equals("MIN")) {
                if (minStack.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(minStack.peek());
                }
            }
        }
    }
}
