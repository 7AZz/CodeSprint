import java.util.*;

public class SandwichQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> students = new LinkedList<>();
        for (int i = 0; i < n; i++) students.add(sc.nextInt());
        int[] sandwiches = new int[n];
        for (int i = 0; i < n; i++) sandwiches[i] = sc.nextInt();

        int idx = 0, unable = 0;
        while (!students.isEmpty() && unable < students.size()) {
            if (students.peek() == sandwiches[idx]) {
                students.poll();
                idx++;
                unable = 0;
            } else {
                students.add(students.poll());
                unable++;
            }
        }
        System.out.println(students.size());
    }
}
