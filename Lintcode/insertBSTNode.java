public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        TreeNode p = root;
        TreeNode parent = null;
        while(p != null) {
            if (p.val < node.val) {
                parent = p;
                p = p.right;
            } else if (p.val > node.val) {
                parent = p;
                p = p.left;
            } else {
                return root;
            }
        }
        if (parent.val < node.val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return root;
    }
    
    public TreeNode insertNodeI(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        insertNode_helper(root, node);
        return root;
    }
    
    private void insertNode_helper(TreeNode root, TreeNode node) {
        if (root == null) {
            //do nothing
            return;
        }
        if (node.val > root.val) {
            //should insert into right child
            if (root.right == null) {
                root.right = node; 
                return;
            } else {
                insertNode_helper(root.right, node);
            }
        } else if (node.val < root.val) {
            if (root.left == null) {
                root.left = node; 
                return;
            } else {
                insertNode_helper(root.left, node);
            }
        }
    }
