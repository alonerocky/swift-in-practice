public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Result r = largestBSTSubtree_helper(root);
        return r.size;
    }
    
    public Result largestBSTSubtree_helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Result(1, root.val, root.val, true);
        } else if (root.left == null) {
            Result right = largestBSTSubtree_helper(root.right);
            if (right.isValid && root.val < right.min) {
                return new Result(right.size + 1, root.val, right.max, true);
            } else {
                return new Result(right.size, -1,-1,false);
            }

        } else if (root.right == null) {
            Result left = largestBSTSubtree_helper(root.left);
            if (left.isValid && root.val > left.max) {
                return new Result(left.size + 1, left.min, root.val, true);
            } else {
                return new Result(left.size, -1,-1, false);
            }
        } else {
            Result left = largestBSTSubtree_helper(root.left);
            Result right = largestBSTSubtree_helper(root.right);
            if (left.isValid && right.isValid && root.val > left.max && root.val < right.min) {
                return new Result(left.size + right.size + 1, left.min, right.max, true);
            } else {
                return new Result(Math.max(left.size, right.size), -1,-1, false);
            }
        }
    }

    class Result {
        int size; //
        int min;
        int max;
        boolean isValid;
        public Result(int size, int min, int max, boolean isValid) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isValid = isValid;
        }
    }
