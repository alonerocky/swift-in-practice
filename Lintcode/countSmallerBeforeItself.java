public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return result;
        }
        int len = A.length;
        TreeNode root = new TreeNode(A[0]);
        result.add(0);
        for(int i = 1; i < len; i++) {
            int res = insert(root, A[i]);
            result.add(res);
        }
        return result;
    }
    
    private int insert(TreeNode root, int val) {
        
        TreeNode p = root;
        int count = 0;
        while(p != null) {
            if (val <= p.val) {
                p.count++;
                if (p.left == null) {
                    p.left = new TreeNode(val);
                    break;
                } else {
                    p = p.left;
                }
            } else {
                count += p.count;
                if (p.right == null) {
                    p.right = new TreeNode(val);
                    break;
                } else {
                    p = p.right;
                }
            }
        }
        return count;
    }
    
    class TreeNode {
        public TreeNode left, right;
        public int val;
        public int count = 1;// number of nodes that val is smallerOrEqual than val
        public TreeNode(int val) {
            this.val = val;
        }
    }
