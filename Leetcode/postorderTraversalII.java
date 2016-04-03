public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        findNextLeaf(root, stack);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (!stack.isEmpty()) {
                TreeNode p = stack.peek();
                if (p.left == top) {
                    findNextLeaf(p.right, stack);
                }
            }
        }
        return result;
    }
    private void findNextLeaf(TreeNode cur, Stack<TreeNode> stack) {
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }
