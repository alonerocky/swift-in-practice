public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> pre = new Stack<TreeNode>();
        Stack<TreeNode> post = new Stack<TreeNode>();
        pushLeft(root, pre);
        pushRight(root, post);
        while (!pre.isEmpty()) {
            if (pre.size() != post.size()) return false;
            TreeNode left = pre.pop();
            if (post.isEmpty()) return false;
            TreeNode right = post.pop();
            if (left.val != right.val) return false;
             
            pushLeft(left.right, pre);
            pushRight(right.left, post);
        }
        
        return post.isEmpty();
        
    }
    private void pushLeft(TreeNode root, Stack<TreeNode> stack) {
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }
    private void pushRight(TreeNode root, Stack<TreeNode> stack) {
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.right;
        }
    }
    public boolean isSymmetricI(TreeNode root) {
        return isSymmetric(root,root);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        } else if (right == null) {
            return left == null;
        } else {
            return left.val == right.val &&
                   isSymmetric(left.left, right.right) &&
                   isSymmetric(left.right, right.left);
                   
        }
    }
