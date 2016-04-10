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
