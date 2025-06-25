import java.util.*;

public class ArborisMaxDepth {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    public static TreeNode buildTree(String[] vals) {
        if (vals.length == 0 || vals[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < vals.length) {
            TreeNode curr = q.poll();
            if (i < vals.length && !vals[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(vals[i]));
                q.add(curr.left);
            }
            i++;
            if (i < vals.length && !vals[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(vals[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] vals = line.split("\\s+");
        TreeNode root = buildTree(vals);
        System.out.println(maxDepth(root));
    }
}
