int closest = 0;
    public int closestValue(TreeNode root, double target) throws IllegalArgumentException {
          if (root == null) {
              throw new IllegalArgumentException();
          }
          closest = root.val;
          closestValue_helper(root, target);
          return closest;
    }
    
    public void closestValue_helper(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (Math.abs(root.val - target) < Math.abs(closest - target)) {
            closest = root.val;
        }
        closestValue_helper(root.left, target);
        closestValue_helper(root.right, target);
    }
