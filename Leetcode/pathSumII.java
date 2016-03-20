c List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        } else if (root.left == null && root.right == null && root.val == sum) {
            ArrayList<Integer> one = new ArrayList<Integer>();
            one.add(sum);
            result.add(one);
            return result;
        } else {
            
            List<List<Integer>> left =  pathSum(root.left, sum - root.val);
            List<List<Integer>> right = pathSum(root.right, sum - root.val);
            for (int i =0; i < left.size(); i++) {
                ArrayList<Integer> one = (ArrayList<Integer>)left.get(i);
                one.add(0, root.val);
                result.add(one);
            }
            for (int j =0; j < right.size(); j++) {
                ArrayList<Integer> one = (ArrayList<Integer>)right.get(j);
                one.add(0, root.val);
                result.add(one);
            }
            return result;
        }
    }
