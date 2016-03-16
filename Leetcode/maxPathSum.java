private int max ;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return max;
    }
    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m = root.val;
        int left = maxPathSumHelper(root.left);
        if (left > 0) {
            m += left;
        }
        int right = maxPathSumHelper(root.right);
        if (right > 0) {
            m += right;
        }
        max = Math.max(max, m);
        return Math.max(left, right) > 0 ? (Math.max(left,right) + root.val) : root.val;
    }
