public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        if (left.size() == 0 && right.size() == 0) {
            result.add("" + root.val);
        } else if (left.size() == 0) {
            for (int i =0; i < right.size(); i++) {
                result.add(root.val+"->"+right.get(i));
            }
        } else if (right.size() == 0) {
            for (int i =0; i < left.size(); i++) {
                result.add(root.val+"->"+left.get(i));
            }
        } else {
            for (int i =0; i < left.size(); i++) {
                result.add(root.val+"->"+left.get(i));
            }
            for (int i =0; i < right.size(); i++) {
                result.add(root.val+"->"+right.get(i));
            }
        }
        return result;
    }
