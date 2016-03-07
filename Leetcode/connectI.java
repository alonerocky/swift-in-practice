public void connect(TreeLinkNode root) {
        TreeLinkNode currentLevel = root;
        while (currentLevel != null) {

            TreeLinkNode nextLevel = null;
            TreeLinkNode p = null;
            TreeLinkNode current = currentLevel;
            while (current != null) {
                //link it's left
                if (current.left != null) {
                    if (nextLevel == null) {
                        nextLevel = current.left;
                        p = current.left;
                    } else {
                        p.next = current.left;
                        p = p.next;
                    }

                    p.next = current.right;
                    p = p.next;
                     
                }
                current = current.next;
            }
            currentLevel = nextLevel;

        }
    }



//recursive
public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

//recursive second
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

