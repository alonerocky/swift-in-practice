public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            
            while (q != null && q.val == p.val) q = q.next;
            if (q == null) {
                p.next = null;
                return head;
            }
            //q point to the one with different val
            p.next = q;
            p = p.next;
        }
        return head;
    }
