public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return root;
        }
        TreeNode parent = null;
        TreeNode p = root;
        while(p != null) {
            if (p.val < value) {
                parent = p;
                p = p.right;
            } else if (p.val > value) {
                parent = p;
                p = p.left;
            } else {
                //found the value
                break;
            }
        }
        if (p == null ) {
            return root;
        } else if (p == root) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode q = root.left;
                while(q.right != null) {
                    q = q.right;
                }
                q.right = root.right;
                root.right = null;
                return root.left;
            }
        } else {
            delete(root, parent, p);
        }
        return root;
    }
    private void delete(TreeNode root, TreeNode parent, TreeNode p) {
        if (p == parent.left) {
            deleteLeft(root, parent, p);
        } else {
            deleteRight(root, parent, p);
        }
    }
    private void deleteLeft(TreeNode root, TreeNode parent, TreeNode p) {
        if (p.left == null && p.right == null) {
                //delete the leaf
                parent.left = null;
            } else if (p.left == null) {
                parent.left = p.right;
                p.right = null;
            } else if (p.right == null) {
                parent.left = p.left;
                p.left = null;
            } else {
                TreeNode q = p.left;
                while(q.right != null) {
                    q = q.right;
                }
                
                q.right = p.right;
                parent.left = p.left;
                
                p.left = null;
                p.right = null;
            }
    }
    private void deleteRight(TreeNode root, TreeNode parent, TreeNode p) {
        if (p.left == null && p.right == null) {
            parent.right = null;
        } else if (p.left == null) {
            parent.right = p.right;
            p.right = null;
        } else if (p.right == null) {
            parent.right = p.left;
            p.left = null;
        } else {
            TreeNode q = p.left;
            while(q.right != null) {
                q = q.right;
            }
            q.right = p.right;
            parent.right = p.left;
                
            p.left = null;
            p.right = null;
        }
    }
