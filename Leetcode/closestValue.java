private double min = Double.MAX_VALUE;
    private int node;
    public int closestValue(TreeNode root, double target) throws IllegalArgumentException {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        node = 0;
        min = Double.MAX_VALUE;
        closestValue_helper(root, target);
        return node;
        
    }
    public void closestValue_helper(TreeNode root, double target) {
        if (Math.abs(target - root.val) < min) {
            min = Math.abs(target - root.val);
            node = root.val;
        }
        if (root.left != null && target < root.val) {
            closestValue_helper(root.left, target);
        } else if (root.right != null && target > root.val) {
            closestValue_helper(root.right, target);
        }
    }
