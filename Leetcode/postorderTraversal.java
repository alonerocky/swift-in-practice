public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        TreeNode prev = null;
        TreeNode current ;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            current = stack.peek();
            //top -> down
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    result.add(stack.pop().val);
                }
            } else if (prev == current.left) { //just accessed it's left child
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    result.add(stack.pop().val);
                }
            } else if (prev == current.right) {
                result.add(stack.pop().val);
            }
            prev = current;
        }
        return result;
    }
