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


public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        } else if (root.left == null && root.right == null) {
            result.add(""+root.val);
            return result;
        } else {
            ArrayList<String> left = (ArrayList<String>)binaryTreePaths(root.left);
            ArrayList<String> right = (ArrayList<String>)binaryTreePaths(root.right);
            for (int i = 0; i < left.size(); i++) {
                result.add(root.val + "->"+ left.get(i));
            }
            for (int i = 0; i < right.size(); i++) {
                result.add(root.val + "->" + right.get(i));
            }
            return result;
        }
    }
