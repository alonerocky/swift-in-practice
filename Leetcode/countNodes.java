public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        int total = 0;
        int leftHeight = getHeight(root.left);
        while (root != null) {
            int rightHeight = getHeight((root.right));
            if (leftHeight == rightHeight) {
                total += (1 << leftHeight) - 1 + 1 ; //the total left children nodes + root
                root = root.right;

            } else {
                total += (1 << rightHeight) - 1 + 1;
                root = root.left;

            }
            leftHeight = leftHeight - 1;

        }
        return total;
    }
    public int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
    public int countNodesII(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftDepth = 0;
            TreeNode p = root;
            while (p != null) {
                p = p.left;
                leftDepth++;
            }
            int rightDepth = 0;
            p = root;
            while (p != null) {
                p = p.right;
                rightDepth++;
            }
            if (leftDepth == rightDepth) {
                return (2 << leftDepth) - 1;
            } else {
                
                return countNodes(root.left) + countNodes(root.right) + 1;
            }
        }
    }
    
    public int countNodesI(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int total = 0;
        while(!queue.isEmpty()) {
            
            //check
            int size = queue.size();
            total += size;
            
            //now i point to the node has left children
            Deque<TreeNode> nextLevel = new ArrayDeque<TreeNode>();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    nextLevel.addLast(node.left);
                } else {
                    break;
                }
                if (node.right != null) {
                    nextLevel.addLast(node.right);
                } else {
                    break;
                }
            }
            if (nextLevel.size() < size << 1) {
                total += nextLevel.size();
                break;
            } else {
                queue = nextLevel;
            }
        }
        return total;
    }
