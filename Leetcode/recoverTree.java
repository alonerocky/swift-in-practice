TreeNode prev;
    TreeNode left;
    TreeNode right;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        prev = null;
        left = null;
        right = null;
        recoverTree_helper(root);
        if (left != null && right != null) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
    }
    public void recoverTree_helper(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverTree_helper(root.left);
        if (prev != null && prev.val > root.val) {
            if (left == null) {
                left = prev;
            }
            right = root;
        }
        prev = root;
        recoverTree_helper(root.right);
    }
