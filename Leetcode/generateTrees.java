public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (n == 0) {
            return result;
        }
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        else if (start == end) {
            result.add( new TreeNode(start));
            return result;
        }
        else {
            for (int i = start; i <= end; i++) {
                //i as root, [i, start - 1] , as left
                //[start +1, end] as right children
                List<TreeNode> left = generateTrees(start, i-1);
                List<TreeNode> right = generateTrees(i+1, end);
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode one = new TreeNode(i);
                        one.left = left.get(j);
                        one.right = right.get(k);
                        result.add(one);
                    }
                }
            }
            return result;
        }
    }
