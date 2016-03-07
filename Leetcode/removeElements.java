public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode p = head;
        ListNode result = head;
        while (p != null) {
            ListNode node = p;
            if (node.val == val) {
                if (prev == null) {
                    p = p.next;
                    result = p;//reset new head
                    node.next = null;
                } else {
                    p = p.next;
                    prev.next = p;
                    node.next = null;
                }
            } else {
                prev = p;
                p = p.next;
            }
        }
        return result;
    }
