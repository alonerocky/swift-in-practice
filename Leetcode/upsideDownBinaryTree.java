public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            return root;
        } else {
            TreeNode left = upsideDownBinaryTree(root.left);
            //root will be the right child of most
            //sibling will be left childrent
            //find the most right children
            TreeNode rightMost = left;
            while (rightMost != null && rightMost.right != null) {
                rightMost = rightMost.right;
            }
            rightMost.left = root.right;
            root.right = null;
            root.left = null;
            rightMost.right = root;
            return left;
        }
    }
