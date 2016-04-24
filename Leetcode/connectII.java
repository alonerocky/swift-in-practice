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



public void connect(TreeLinkNode root) {
          if (root == null) {
              return;
          }
          Deque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
          queue.addLast(root);
          while(!queue.isEmpty()) {
              //handle current level
              int size = queue.size();
              TreeLinkNode tail = null;
              for (int i = 0; i < size; i++) {
                  TreeLinkNode front = queue.pollFirst();
                  if (front.left != null) {
                      if (tail == null) {
                          tail = front.left;
                      } else {
                          tail.next = front.left;
                          tail = tail.next;
                      }
                      queue.addLast(front.left);
                  }
                  if (front.right != null) {
                      if (tail == null) {
                          tail = front.right;
                      } else {
                          tail.next = front.right;
                          tail = tail.next;
                      }
                      queue.addLast(front.right);
                  }
              }
          }
    }
