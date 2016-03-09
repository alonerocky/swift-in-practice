public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode p = head;
        ListNode result = head;
        while (p.next != null) {
            ListNode q = p.next;
            while (q != null && q.val == p.val) q = q.next;
            if (q == null) {
                if (prev == null) {
                    return null;
                } else {
                    prev.next = null;
                    return result;
                }
            }
            //q point to the one with different number
            if (q == p.next) { //no duplicates
                prev = p;
                p = q;
            } else {
                if (prev == null) { //from p --> .... q are duplicate, and p is the head
                    result = q;
                    p = q;
                } else {
                    prev.next = q;
                    p = q;
                }
            }
        }
        return result;
    }
