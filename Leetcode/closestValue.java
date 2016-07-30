public int closestValue(TreeNode root, double target) {
         int result = root.val;
         if (root.val == target) {
             return root.val;
         } else if (root.left != null && target < root.val) {
              
             int left = closestValue(root.left, target);
             if (Math.abs(left - target) < Math.abs(result - target)) {
                 result = left;
             }
         } else if (root.right != null) {
              
             int right = closestValue(root.right, target);
             if (Math.abs(right - target) < Math.abs(result - target)) {
                 result = right;
             }
         }
         return result;
    }

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
