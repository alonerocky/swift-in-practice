private int max ;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return max;
    }
    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m = root.val;
        int left = maxPathSumHelper(root.left);
        if (left > 0) {
            m += left;
        }
        int right = maxPathSumHelper(root.right);
        if (right > 0) {
            m += right;
        }
        max = Math.max(max, m);
        return Math.max(left, right) > 0 ? (Math.max(left,right) + root.val) : root.val;
    }



---------------
public int maxPathSum(TreeNode root) {
         if (root == null) {
             return 0;
         }
         Result r = maxPathSum_helper(root);
         return r.max;
    }
    
    
    public Result maxPathSum_helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Result(root.val, root.val);
        } else if (root.left == null) {
            Result right = maxPathSum_helper(root.right);
            int max = root.val;
            if (right.maxByNode > 0) {
                max += right.maxByNode;
            }
            max = Math.max(max, right.max);
            int maxByNode = root.val + (right.maxByNode > 0 ? right.maxByNode : 0);
            return new Result(max, maxByNode);
        } else if (root.right == null) {
            Result left = maxPathSum_helper(root.left);
            int max = root.val;
            if (left.maxByNode > 0) {
                max += left.maxByNode;
            }
            max = Math.max(max, left.max);
            int maxByNode = root.val + (left.maxByNode > 0 ? left.maxByNode : 0);
            return new Result(max, maxByNode);
        } else {
            Result left = maxPathSum_helper(root.left);
            Result right = maxPathSum_helper(root.right);
            int max = root.val;
            if (left.maxByNode > 0) {
                max += left.maxByNode;
            }
            if (right.maxByNode > 0) {
                max += right.maxByNode;
            }
            
            max = Math.max(max, Math.max(left.max, right.max));
            int maxByNode = root.val + (Math.max(left.maxByNode , right.maxByNode) > 0 ? Math.max(left.maxByNode, right.maxByNode) : 0);
            return new Result(max, maxByNode);
            
            
        }
    }
    class Result {
        int max;
        int maxByNode;
        public Result(int max, int maxByNode) {
            this.max = max;
            this.maxByNode = maxByNode;
        }
    }
