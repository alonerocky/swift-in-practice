public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode currentLevel = root;
        TreeLinkNode current = null;
        while (currentLevel != null) {
            TreeLinkNode nextLevel = null;
            TreeLinkNode p = null;
            current = currentLevel;
            while (current != null) {
                //link left node
                if (current.left != null) {
                    if (nextLevel == null) {
                        nextLevel = current.left;
                        p = current.left;
                    } else {
                        p.next = current.left;
                        p = p.next;
                    }
                }
                if (current.right != null) {
                    if (nextLevel == null) {
                        nextLevel = current.right;
                        p = current.right;
                    } else {
                        p.next = current.right;
                        p = p.next;
                    }
                }
                current = current.next;
            }
            currentLevel = nextLevel;

        }
    }
