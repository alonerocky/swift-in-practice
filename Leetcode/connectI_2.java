public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
         TreeLinkNode p = root;
         while (p != null) {
             if (p.left != null) {
                 p.left.next = p.right;
                 p.right.next = p.next == null ? null : p.next.left;
             }
             p = p.next;
         }
         connect(root.left);
    }
