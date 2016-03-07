public boolean isValidBST(TreeNode root) 
    {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min ,long max)
    {
        if(root == null)
            return true;
        return (root.val < max && root.val > min)  &&
                isValidBST(root.left, min, root.val  ) &&
                isValidBST(root.right, root.val ,max );
    }
