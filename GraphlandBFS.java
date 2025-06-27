import java.util.*;

public class GraphlandBFS {
    public static List<Integer> bfsOrder(int n, List<List<Integer>> adj) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            order.add(curr);
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return order;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            List<Integer> neighbors = new ArrayList<>();
            if (!line.isEmpty()) {
                for (String s : line.replaceAll("[\\[\\],]", "").split("\\s+")) {
                    if (!s.isEmpty())
                        neighbors.add(Integer.parseInt(s));
                }
            }
            adj.add(neighbors);
        }
        List<Integer> order = bfsOrder(n, adj);
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i));
            if (i < order.size() - 1)
                System.out.print(" ");
        }
    }
}
