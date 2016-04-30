public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Result r =  countUnivalSubtrees_helper(root);
        return r.size;
    }
    
    public Result countUnivalSubtrees_helper(TreeNode root) {
        if (root.left == null && root.right == null) {
          return new Result(root.val, true, 1);  
        } else if (root.left == null) {
            Result right = countUnivalSubtrees_helper(root.right);
            if (right.isUnitree && right.value == root.val) {
                return new Result(root.val, true, right.size+1);
            } else {
                return new Result(root.val, false, right.size);
            }
        } else if (root.right == null) {
            Result left = countUnivalSubtrees_helper(root.left);
            if (left.isUnitree && left.value == root.val) {
                return new Result(root.val, true, left.size + 1);
            } else {
                return new Result(root.val, false, left.size);
            }
        } else {
            Result left = countUnivalSubtrees_helper(root.left);
            Result right = countUnivalSubtrees_helper(root.right);
            if (left.isUnitree && right.isUnitree && root.val == left.value && root.val == right.value) {
                return new Result(root.val, true, left.size + right.size + 1);
            } else {
                return new Result(root.val, false, left.size + right.size);
            }
        }
    } 
    
    class Result{
        int value ;
        boolean isUnitree;
        int size;
        public Result(int value, boolean isUnitree, int size) {
            this.value = value;
            this.isUnitree = isUnitree;
            this.size = size;
        }
    }
