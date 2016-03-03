public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = null;
        ListNode p = head;
        while (p != null ) {
            ListNode node = p;
            p = p.next;
            node.next = null;
            if (result == null) {
                result = node;
            } else {
                node.next = result;
                result = node;
            }
        }
        return result;
    }
