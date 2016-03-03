public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        pushLeft(root, stack);
        while (!stack.empty()) {
            TreeNode current = stack.pop();
            result.add(current.val);
            pushLeft(current.right, stack);
        }
        return result;
    }
    private void pushLeft(TreeNode root, Stack<TreeNode> stack) {
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }
