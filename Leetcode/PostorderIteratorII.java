class PostorderIterator implements Iterator<Integer> {
        private Stack<TreeNode> stack;
        public PostorderIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            if (root != null) {
                findNextLeaf(root);
            }
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        @Override
        public Integer next() {
            TreeNode top = stack.pop();
            if (!stack.isEmpty()) {
                TreeNode p = stack.peek();
                if (p.left == top) {
                    findNextLeaf(p.right);
                }
            }
            return top.val;
        }
        private void findNextLeaf(TreeNode cur) {
            while (cur != null) {
                stack.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<Integer>();
         PostorderIterator iterator = new PostorderIterator(root);
         while (iterator.hasNext()) {
             result.add(iterator.next());
         }
         return result;
    }
