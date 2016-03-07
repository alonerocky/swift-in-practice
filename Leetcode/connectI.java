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
