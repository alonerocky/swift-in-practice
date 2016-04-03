class InorderIterator implements Iterator<Integer> {
        private Stack<TreeNode> stack ;
        public InorderIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            pushLeft(root);
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        @Override
        public Integer next() {
            TreeNode top = stack.pop();
            pushLeft(top.right);
            return top.val;
        }
        
        private void pushLeft(TreeNode root) {
            TreeNode p = root;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        InorderIterator iterator = new InorderIterator(root);
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }
