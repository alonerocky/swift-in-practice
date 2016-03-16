public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    public int sumNumbers(TreeNode root, int base) {
        if(root == null)
            return base;
        if (root.left == null && root.right == null) {
            return 10 * base + root.val;
        }
        int left = root.left == null ? 0 : sumNumbers(root.left , 10 * base + root.val);
        int right = root.right == null ? 0: sumNumbers(root.right,10 * base + root.val);
        return left + right;
    }
