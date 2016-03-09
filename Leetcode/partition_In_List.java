public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode lessThan = null;
        ListNode p1 = null;
        ListNode greaterOrEqual = null;
        ListNode p2 = null;
        ListNode p = head;
        while (p != null) {
            ListNode node = p;
            p = p.next;
            node.next = null;
            
            if (node.val < x) {
                if (p1 == null) {
                    lessThan = p1 = node;
                } else {
                    p1.next = node;
                    p1 = p1.next;
                }
            } else {
                if (p2 == null) {
                    greaterOrEqual = p2 = node;
                } else {
                    p2.next = node;
                    p2 = p2.next;
                }
            }
        }
        if (p1 == null) {
            return greaterOrEqual;
        } else {
            p1.next = greaterOrEqual;
            return lessThan;
        }
    }
