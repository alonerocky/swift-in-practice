class PostorderIterator implements Iterator<Integer> {
        Stack<TreeNode> stack;
        TreeNode current;
        TreeNode prev;
        public PostorderIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            if (root != null) {
                stack.push(root);
            }
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        @Override
        public Integer next() {
             
            while (!stack.isEmpty()) {
                current = stack.peek();
                if (prev == null || current == prev.left || current == prev.right) {
                    prev = current;
                    if (current.left != null) {
                        stack.push(current.left);
                    } else if (current.right != null) {
                        stack.push(current.right);
                    } else {
                        current = stack.pop();
                        break;
                    }
                } else if (prev == current.left) {
                    prev = current;
                    if (current.right != null) {
                        stack.push(current.right);
                    } else {
                        current = stack.pop();
                        break;
                    }
                } else  { /* if (prev == current.right) */
                    prev = current;
                    current = stack.pop();
                    break;
                }
                
            }
            
            return current.val;
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
