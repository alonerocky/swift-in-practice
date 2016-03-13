private int i =0;
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        // result = -1;
        // findKthSmallest(root, k);
        // return result;
        int result = -1;
        
        if (root.left != null) {
       	    result = kthSmallest(root.left, k);
        }
        
        if (i == k) {
            return result;
        }
        //need continue to find
        i++;
        if (i == k) {
            return root.val;
        } else {
            if (root.right != null) {
                result = kthSmallest(root.right, k);
            }
        }
        return result;
        
    }
    public void findKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        findKthSmallest(root.left, k);
        i++;
        if (i == k) {
            result = root.val;
            return;
        } 
        findKthSmallest(root.right, k);
    }
