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


public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }
    public void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#,");
            return;
        } 
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        StringTokenizer st = new StringTokenizer(data, ",");
        return deserialize(st);
    }
    public TreeNode deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            return null;
        }
        String val = st.nextToken();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(st);
        root.right = deserialize(st);
        return root;
    }
