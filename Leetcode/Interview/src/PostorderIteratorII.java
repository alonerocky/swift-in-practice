import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by shoulongli on 4/3/16.
 */
class PostorderIteratorII implements Iterator<Integer> {
    private Stack<TreeNode> stack;
    public PostorderIteratorII(TreeNode root) {
        stack = new Stack<TreeNode>();
        if (root != null) {
            findNextLeaf(root);
        }
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    @Override
    public Integer next() {
        TreeNode top = stack.pop();
        if (!stack.isEmpty()) {
            TreeNode p = stack.peek();
            if (p.left == top) {
                findNextLeaf(p.right);
            }
        }
        return top.val;
    }
    private void findNextLeaf(TreeNode cur) {
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    public static void main(String[] argv) {
        TreeNode root = new TreeNode(1);
        System.out.println(postorderTraversal(root));
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        PostorderIteratorII iterator = new PostorderIteratorII(root);
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }
}