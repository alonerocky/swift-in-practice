public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    public int sumNumbers(TreeNode root, int base) {
        if(root == null)
            return base;
        
        if(root.left != null && root.right != null)
        {
            return sumNumbers(root.left , 10 * base + root.val) + sumNumbers(root.right,10 * base + root.val);
        }
        else if(root.left != null)
        {
            return sumNumbers(root.left , 10 * base + root.val) ;
        }
        else if(root.right != null)
        {
            return sumNumbers(root.right,10 * base + root.val);
        }
        else
            return 10 * base + root.val;
            
    }
