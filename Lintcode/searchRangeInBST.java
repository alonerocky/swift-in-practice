public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null || k1 > k2) {
            return result;
        } 
        
        //[k1,k2] < root.val
        if (k2 < root.val) {
            return searchRange(root.left, k1, k2);
        } else if (k1 > root.val) {
            return searchRange(root.right, k1, k2);
        } else {
            ArrayList<Integer> left = searchRange(root.left, k1, root.val);
            ArrayList<Integer> right = searchRange(root.right, root.val, k2);
            result.addAll(left);
            result.add(root.val);
            result.addAll(right);
            return result;
        }
    }
