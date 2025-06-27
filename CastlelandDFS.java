import java.util.*;

public class CastlelandDFS {
    public static void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> order) {
        visited[node] = true;
        order.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, order);
            }
        }
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
        boolean[] visited = new boolean[n];
        List<Integer> order = new ArrayList<>();
        dfs(0, adj, visited, order);
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i));
            if (i < order.size() - 1)
                System.out.print(" ");
        }
    }
}
