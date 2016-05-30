package Uber;

import java.util.*;

/**
 * Created by shoulongli on 5/28/16.
 */
public class TreeNode {
    private int val;
    public List<TreeNode> children;
    public TreeNode(int val) {
        this.val = val;
    }



    public List<TreeNode> getChildren() {
        return children;
    }
    public void addChild(TreeNode c) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(c);
    }
    public TreeNode getChild(int i) {
        if (children != null && i >= 0 && i < children.size()) {
            return children.get(i);
        }
        return null;
    }

    public static void print(TreeNode t) {
        if (t != null) {
            System.out.print(t.val);
            System.out.print(",");
            if (t.children != null) {
                for (int i = 0; i < t.children.size();i++) {
                    print(t.children.get(i));
                }
            }
        }
    }
    public static void levelPrint(TreeNode t) {
        if (t == null) {
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(t);
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println();
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.pollFirst();
                System.out.print(front.val+", ");
                if (front.children != null) {
                    for (int j = 0; j < front.children.size(); j++) {
                        queue.addLast(front.getChild(j));
                    }
                }
            }
        }
    }

    public static TreeNode createDummyTree() {
        TreeNode root = new TreeNode(1);
        root.addChild(new TreeNode(2));
        root.addChild(new TreeNode(3));
        root.addChild(new TreeNode(4));

        root.getChild(0).addChild(new TreeNode(5));
        root.getChild(0).addChild(new TreeNode(6));

        root.getChild(2).addChild(new TreeNode(7));
        root.getChild(2).addChild(new TreeNode(8));
        root.getChild(2).addChild(new TreeNode(9));

        root.getChild(0).getChild(1).addChild(new TreeNode(10));
        return root;
    }

    public static void main(String[] argv) {
        TreeNode root = createDummyTree();
        print(root);
        levelPrint(root);
        System.out.println();
        String str = serialize(root);
        System.out.println(str);
        TreeNode root2 = deserialize(str);
        print(root2);
        levelPrint(root2);
        System.out.println();
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }
    public static void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        if (root.children != null ) {
            for (int i = 0; i < root.children.size();i++) {
                serialize(root.children.get(i), sb);
            }
        }
        sb.append("#,");
    }

    public static TreeNode deserialize(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        StringTokenizer st = new StringTokenizer(s, ",");
        return deserialize(st);
    }

    public static TreeNode deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            return null;
        }
        String val = st.nextToken();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        TreeNode child ;
        while ((child = deserialize(st)) != null) {
            root.addChild(child);
        }
        return root;
    }
}
