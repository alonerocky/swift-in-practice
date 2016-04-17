public int rob(TreeNode root) {
        Entry e = rob_helper(root);
        return Math.max(e.maxInclude, e.maxExclude);
    }
    public Entry rob_helper(TreeNode root) {
        if (root == null) {
            return new Entry(0,0);
        } else if (root.left == null && root.right == null) {
            return new Entry(0, root.val);
        } 
        /* else if (root.left == null) {
            Entry right = rob_helper(root.right);
            return new Entry(Math.max(right.maxInclude, right.maxExclude), right.maxExclude + root.val);
        } else if (root.right == null) {
            Entry left = rob_helper(root.left);
            return new Entry(Math.max(left.maxInclude, left.maxExclude), left.maxExclude + root.val);
        }  */
        else  {
            Entry left = rob_helper(root.left);
            Entry right = rob_helper(root.right);
            return new Entry(Math.max(left.maxInclude, left.maxExclude) + Math.max(right.maxExclude , right.maxInclude), 
            root.val + left.maxExclude + right.maxExclude);
            
        }
    }
    
    class Entry {
        public int maxExclude ;
        public int maxInclude ;
        public Entry(int maxExclude, int maxInclude) {
            this.maxExclude = maxExclude;
            this.maxInclude = maxInclude;
        }
    }


public int rob(TreeNode root) {
        int[] result = rob_helper(root);
        return Math.max(result[0], result[1]);
    }
    //int[0] is the max value exclude root
    //int[0] is the max value include root
    public int[] rob_helper(TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        } else if (root.left == null && root.right == null) {
            return new int[] {0, root.val};
        } else {
            int[] left = rob_helper(root.left);
            int[] right = rob_helper(root.right);
            int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            int include = left[0] + right[0] + root.val;
            return new int[] {exclude, include};
        }
    }
