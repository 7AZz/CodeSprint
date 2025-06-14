import java.util.*;

public class BennySlips {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0, slips = 0;
        visited.add(x + "," + y);
        for (char c : S.toCharArray()) {
            if (c == 'L')
                x--;
            else if (c == 'R')
                x++;
            else if (c == 'U')
                y++;
            else if (c == 'D')
                y--;
            String pos = x + "," + y;
            if (!visited.add(pos))
                slips++;
        }
        System.out.println(slips);
    }
}