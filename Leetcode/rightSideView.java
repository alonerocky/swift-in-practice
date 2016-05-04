public List<Integer> rightSideView(TreeNode root) {
         List<Integer> result = new ArrayList<Integer>();
         if (root == null) {
             return result;
         }
         Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
         queue.addLast(root);
         while(!queue.isEmpty()) {
             int size = queue.size();
             for (int i = 0; i < size; i++) {
                 TreeNode front = queue.pollFirst();
                 if (i == size - 1) {
                     result.add(front.val);
                 }
                 if (front.left != null) {
                     queue.addLast(front.left);
                 }
                 if (front.right != null) {
                     queue.addLast(front.right);
                 }
             }
         }
         return result;
    }
