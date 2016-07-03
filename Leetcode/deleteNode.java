public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        ListNode p = node;
        ListNode previous = null;
        while (p != null && p.next != null) {
            previous = p;
            p = p.next;
            previous.val = p.val;
        }
        previous.next = null;
    }
