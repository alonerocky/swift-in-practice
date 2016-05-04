public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return longestConsecutive_helper(root, 0, root.val + 1);
       
    }
    public int longestConsecutive_helper(TreeNode root, int curLen, int next) {
        if (root == null) {
            return curLen;
        } else  {
            if (root.val == next) {
                curLen += 1;
            } else {
                curLen = 1;
            }
            int leftLen = longestConsecutive_helper(root.left, curLen, root.val + 1);
            int rightLen = longestConsecutive_helper(root.right, curLen, root.val + 1);
            return Math.max(curLen, Math.max(leftLen, rightLen));
        
        }
    }



public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Result r = longestConsecutive_helper(root);
        return r.max;
       
    }
    public Result longestConsecutive_helper(TreeNode root) {
        if (root == null) {
            return new Result(0, -1, 0);
        } else if (root.left == null && root.right == null) {
            return new Result(1, root.val, 1);
        } else {
            Result left = longestConsecutive_helper(root.left);
            Result right = longestConsecutive_helper(root.right);
            int len = 1;
            int max = (left.max == 0 && right.max == 0 ? 1 : Math.max(left.max, right.max));
            if (left.len > 0 && root.val == left.value - 1) {
                len = Math.max(left.len + 1, len);
                max = Math.max(max, len);
            }
            if (right.len > 0 && root.val == right.value - 1) {
                len = Math.max(len, right.len + 1);
                max = Math.max(max, len);
            }
            return new Result(len, root.val, max);
        }
    }
    
    class Result {
        int len ;
        int value;
        int max;
        public Result(int len, int value, int max) {
            this.len = len;
            this.value = value;
            this.max = max;
        }
    } 



-----------------
public int longestConsecutive(TreeNode root) {
         if (root == null) {
             return 0;
         }
         Result r = longestConsecutive_helper(root);
         return r.maxLen;
    }
    
    public Result longestConsecutive_helper(TreeNode root) {
         if (root.left == null && root.right == null) {
             return new Result(root.val, 1, 1);
         } else if (root.left == null) {
             Result right = longestConsecutive_helper(root.right);
             int len = 1;
             if (root.val == right.val - 1) {
                 len += right.len;
             }
             int maxLen = Math.max(right.maxLen, len);
             return new Result(root.val, len, maxLen);
         } else if (root.right == null) {
             Result left = longestConsecutive_helper(root.left);
             int len = 1;
             if (root.val == left.val - 1) {
                 len += left.len;
             }
             int maxLen = Math.max(left.maxLen, len);
             return new Result(root.val, len, maxLen);
         } else {
             Result left = longestConsecutive_helper(root.left);
             Result right = longestConsecutive_helper(root.right);
             int len = 1;
             if (root.val == left.val - 1 && root.val == right.val - 1) {
                 len += Math.max(left.len, right.len);
             } else if (root.val == right.val - 1) {
                 len += right.len;
             } else if (root.val == left.val - 1) {
                 len += left.len;
             }
             int maxLen = Math.max(len, Math.max(left.maxLen, right.maxLen));
             return new Result(root.val, len, maxLen);
         }
    }
    
    class Result {
        int val;
        int maxLen;
        int len;
        public Result(int val, int len, int maxLen) {
            this.val = val;
            this.len = len;
            this.maxLen = maxLen;
        }
    }
