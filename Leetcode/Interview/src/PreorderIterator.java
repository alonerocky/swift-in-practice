import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PreorderIterator implements Iterator<Integer> {

    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public PreorderIterator(TreeNode root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            stack.push(top.right);
        }
        if (top.left != null) {
            stack.push(top.left);
        }

        return top.val;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        PreorderIterator iterator = new PreorderIterator(root);
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

}

