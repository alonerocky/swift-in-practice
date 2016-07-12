public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int len = nums.length;
        TreeNode root = new TreeNode(nums[len-1]);
        result.add(0);
        for(int i = len-2; i >= 0; i--) {
            int res = insert(root, nums[i]);
            result.add(0, res);
        }
        return result;
    }
    public int insert(TreeNode root, int val) {
        int smaller = 0;
        TreeNode p = root;
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
                smaller += p.count;
                if (p.right == null) {
                    p.right = new TreeNode(val);
                    break;
                } else {
                    p = p.right;
                }
            }
             
        }
        
        return smaller;
    }
    class TreeNode {
        public TreeNode left, right;
        public int count = 1;
        public int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
