public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int min = 0;
        int max = 0;
        Deque<TreeNode> treeQueue = new ArrayDeque<TreeNode>();
        Deque<Integer> columnQueue = new ArrayDeque<Integer>();
        treeQueue.addLast(root);
        columnQueue.add(0);
        while (!treeQueue.isEmpty()) {
            TreeNode node = treeQueue.pollFirst();
            int column = columnQueue.pollFirst();
            if (column < min) {
                min = column;
            } else if (column > max) {
                max = column;
            }
            
            if (!map.containsKey(column)) {
                map.put(column, new ArrayList<Integer>());
            }
            map.get(column).add(node.val);
            if (node.left != null) {
                treeQueue.addLast(node.left);
                columnQueue.addLast(column-1);
            }
            if (node.right != null) {
                treeQueue.addLast(node.right);
                columnQueue.addLast(column+1);
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(new ArrayList<Integer>(map.get(i)));
        }
        return result;
    }
