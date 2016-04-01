public static String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            return "";
        }
        Deque<TreeNode> currentLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel    = new ArrayDeque<>();
        currentLevel.addLast(root);
        sb.append(root.val);
        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pollFirst();
            if (node.left != null) {
                nextLevel.addLast(node.left);
                sb.append(","+node.left.val);
            } else {
                sb.append(",#");
            }
            if (node.right != null) {
                nextLevel.addLast(node.right);
                sb.append(","+node.right.val);
            } else {
                sb.append(",#");
            }
            if (currentLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new ArrayDeque<>();
            }
        }
        int i = sb.length() - 1;
        while (i > 0) {
            if (sb.charAt(i) == '#') {
                //remove # and previous ,

                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i -= 2;
            } else {
                break;
            }
        }

        return sb.toString();

    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        Deque<TreeNode> currentLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();
        int rootVal = Integer.parseInt(nodes[0]);
        TreeNode root = new TreeNode(rootVal);
        currentLevel.addLast(root);
        int i = 1;
        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pollFirst();
            //
            if (i >= nodes.length) {
                break;
            }
            String left = nodes[i++];
            if (left.equals("#")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(left));
                nextLevel.addLast(node.left);
            }
            if (i >= nodes.length) {
                break;
            }
            String right = nodes[i++];
            if (right.equals("#")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(right));
                nextLevel.addLast(node.right);
            }
            if (currentLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new ArrayDeque<>();
            }
        }
        return root;
    }
