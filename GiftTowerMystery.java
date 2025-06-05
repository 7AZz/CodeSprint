import java.util.*;

public class GiftTowerMystery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("PUSH")) {
                String gift = line.substring(5);
                stack.push(gift);
                freq.put(gift, freq.getOrDefault(gift, 0) + 1);
            } else if (line.equals("POP")) {
                if (!stack.isEmpty()) {
                    String top = stack.pop();
                    freq.put(top, freq.get(top) - 1);
                    if (freq.get(top) == 0)
                        freq.remove(top);
                }
            } else if (line.equals("COUNT")) {
                if (stack.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    String top = stack.peek();
                    System.out.println(freq.get(top));
                }
            }
        }
    }
}
