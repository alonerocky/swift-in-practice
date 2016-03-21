public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode left = p.val < q.val ? p : q;
        TreeNode right = p.val < q.val ? q : p;
        if (root.val > left.val && root.val < right.val) {
            return root;
        } else if (left.val < root.val && right.val < root.val) {
            return lowestCommonAncestor(root.left, left, right);
        } else {
            return lowestCommonAncestor(root.right, left, right);
        }
    }
