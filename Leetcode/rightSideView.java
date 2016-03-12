public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        //the end of each level
        List<TreeNode> currentLevel = new ArrayList<TreeNode>();
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            TreeNode current = currentLevel.remove(0);
            if (current.left != null) {
                nextLevel.add(current.left);
            }
            if (current.right != null) {
                nextLevel.add(current.right);
            }
            if (currentLevel.isEmpty()) {
                //we already reached the end of this level
                result.add(current.val);
                List<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return result;
    }
