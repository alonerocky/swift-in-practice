import java.util.*;

/**
 * Created by shoulongli on 3/6/16.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public static void main(String[] argv) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        root.left = node2;
        root.right = node4;
        node2.left = node1;
        String serialized = serialize(root);
        System.out.println(serialized);

        TreeNode a1 = new TreeNode(1);
        a1.left = new TreeNode(2);
        a1.right = new TreeNode(3);
        a1.right.left = new TreeNode(4);
        a1.right.right = new TreeNode(5);
        System.out.println();
        preorderTraversal(a1);
        System.out.println();
        inorderTraversal(a1);
        System.out.println();
        String serialized2 = serialize(a1);
        System.out.println(serialized2);

        TreeNode b1 = deserialize(serialized2);
        System.out.println();
        preorderTraversal(b1);
        System.out.println();
        inorderTraversal(b1);


        TreeNode i1 = new TreeNode(1);
        i1.left = new TreeNode(2);
        String str = serializeII(i1);
        deserializeII(str);


        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);
        t3.right = new TreeNode(8);
        t3.right.left = new TreeNode(6);
        t3.right.right = new TreeNode(7);
        System.out.println(getWidth(t1));
        System.out.println(getWidthII(t1));
        System.out.println(getWidth(t1) == getWidthII(t1));
        System.out.println(getDiameter(t1));
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    //Maximum width of a binary tree
    //http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
    public static int getWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int max = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            max = Math.max(size, max);
            for(int i = 0; i < size;i++) {
                TreeNode front = queue.pollFirst();
                if (front.left != null) {
                    queue.addLast(front.left);
                }
                if (front.right != null) {
                    queue.addLast(front.right);
                }
            }
        }
        return max;
    }

    public static int getWidthII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = getHeight(root);
        int[] count = new int[height];
        helper(root,count, 0 );
        int max = 0;
        for (int i = 0; i < count.length;i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
    public static void helper(TreeNode node, int[] count, int level) {
        if (node != null) {
            count[level]++;
            helper(node.left, count, level+1);
            helper(node.right, count, level+1);
        }
    }

    public static int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        int ld = getDiameter(root.left);
        int rd = getDiameter(root.right);
        return Math.max(lh + rh + 1 , Math.max(ld, rd));

    }

    private double min = Double.MAX_VALUE;
    private int node;
    public int closestValue(TreeNode root, double target) throws IllegalArgumentException {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        node = 0;
        min = Double.MAX_VALUE;
        closestValue_helper(root, target);
        return node;

    }
    public void closestValue_helper(TreeNode root, double target) {
        if (Math.abs(target - root.val) < min) {
            min = Math.abs(target - root.val);
            node = root.val;
        }
        if (root.left != null ) {
            closestValue_helper(root.left, target);
        }
        if (root.right != null) {
            closestValue_helper(root.right, target);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        } else if (root.left == null && root.right == null && root.val == sum) {
            ArrayList<Integer> one = new ArrayList<Integer>();
            one.add(sum);
            result.add(one);
            return result;
        } else {

            List<List<Integer>> left = pathSum(root.left, sum - root.val);
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null ) {
            return null;
        }
        if (p.right != null) {
            //the most left children of p's righ
            TreeNode q = p.right;
            while (q.left != null) {
                q = q.left;
            }
            return q;
        } else {
            //find p's parent
            TreeNode parent = null;

            TreeNode q = root;
            while (q != null && q != p) {
                parent = q;
                if (q.val < p.val) {
                    q = q.right;
                } else if(q.val > p.val) {
                    q = q.left;
                }
            }
            //q point to p or null;
            if (q == null) {
                return null;
            } else {
                return parent;
            }
        }
    }

    public TreeNode inorderSuccessorII(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //
        pushLeftChildren(root, stack);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            pushLeftChildren(top.right, stack);
            if (top == p) {
                if (stack.isEmpty()) {
                    return null;
                } else {
                    return stack.peek();
                }
            }
        }
        return null;
    }
    private void pushLeftChildren(TreeNode r, Stack<TreeNode> stack) {
        TreeNode p = r;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }


    private static TreeNode toNode(String s) {

        if (s.equals("null")) {
            return null;
        } else {
            try {
                return new TreeNode(Integer.parseInt(s));
            } catch(Exception e) {
                System.out.println(s);
            }
        }
        return null;
    }



    public static void preorderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + ",");
        inorderTraversal(root.right);

    }



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
        /*
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
        */

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
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int i = 1; //we already read the first one as root

        Deque<TreeNode> currentLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();
        currentLevel.addLast(root);
        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pollFirst();
            if (i >= nodes.length) {
                break;
            }
            String left = nodes[i++];
            node.left = left.equals("#") ? null : new TreeNode(Integer.parseInt(left));
            if (node.left != null)
                nextLevel.addLast(node.left);
            if (i >= nodes.length) {
                break;
            }
            String right = nodes[i++];
            node.right = right.equals("#") ? null : new TreeNode(Integer.parseInt(right));
            if (node.right != null)
                nextLevel.addLast(node.right);
            //switch to next level
            if (currentLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new ArrayDeque<>();
            }
        }

        return root;
    }




    public static String serializeII(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        sb.append(root.val);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.pollFirst();
                if (front.left != null) {
                    queue.addLast(front.left);
                    sb.append(",");
                    sb.append(front.left.val);
                } else {
                    sb.append(",#");
                }
                if (front.right != null) {
                    queue.addLast(front.right);
                    sb.append(",");
                    sb.append(front.right.val);
                } else {
                    sb.append(",#");
                }
            }
        }
        return sb.toString();
    }

    public static TreeNode deserializeII(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[i++]));
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0;j < size; j++) {
                TreeNode front = queue.pollFirst();
                if (i >= nodes.length){
                    return root;
                }
                String left = nodes[i++];
                if (!left.equals("#")) {
                    front.left = new TreeNode(Integer.parseInt(left));
                    queue.addLast(front.left);
                }

                if (i >= nodes.length){
                    return root;
                }
                String right = nodes[i++];
                if (!right.equals("#")) {
                    front.right = new TreeNode(Integer.parseInt(right));
                    queue.addLast(front.right);
                }
            }
        }
        return root;
    }

}
