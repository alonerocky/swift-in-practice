package Facebook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by shoulongli on 5/27/16.
 */
public class TreeNode {
    String expression;
    TreeNode left;
    TreeNode right;
    public TreeNode(String expression) {
        this.expression = expression;
    }

    public static boolean sameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2 == null;
        }
        return t1.expression.equals(t2.expression) && sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }
    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println();
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.pollFirst();
                System.out.print(front.expression);
                if (front.left != null) {
                    queue.addLast(front.left);
                }
                if (front.right != null) {
                    queue.addLast(front.right);
                }
            }
        }
    }
}
