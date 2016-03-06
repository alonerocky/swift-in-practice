public class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        pushLeft(root, stack);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        pushLeft(top.right, stack);
        return top.val;
    }
    private void pushLeft(TreeNode root, Stack<TreeNode> stack) {
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
    }
}
