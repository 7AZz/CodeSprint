import java.util.*;

public class ArborisSymmetricTree {
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

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] vals = line.split("\\s+");
        TreeNode root = buildTree(vals);
        System.out.println(isSymmetric(root));
    }
}
