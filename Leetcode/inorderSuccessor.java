public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null ) {
            return null;
        }
        if (p.right != null) {
            //the most left children of p's righ
            TreeNode q = p.right;
            while (q.left != null) {
                q = q.left;
            }
            return q;
        } else {
            //find p's parent
            TreeNode parent = null;
            
            TreeNode q = root;
            while (q != null && q != p) {
                
                if (q.val < p.val) {
                    q = q.right;
                } else if(q.val > p.val) {
                    parent = q;
                    q = q.left;
                }
            }
            //q point to p or null;
            if (q == null) {
                return null;
            } else {
                return parent;
            }
        }
    }
    public TreeNode inorderSuccessorII(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //
        pushLeftChildren(root, stack);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            pushLeftChildren(top.right, stack);
            if (top == p) {
                if (stack.isEmpty()) {
                    return null;
                } else {
                    return stack.peek();
                }
            }
        }
        return null;
    }
    private void pushLeftChildren(TreeNode r, Stack<TreeNode> stack) {
        TreeNode p = r;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }
