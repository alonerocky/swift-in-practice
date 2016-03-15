public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tail = slow;
            slow = slow.next;
        }
        
        if (fast != null) {
            tail = slow;
            slow = slow.next;
        }
        //now slow  point to start of second , if total numbers is even
        tail.next = null;
        //reverse the second part
        ListNode p = slow;
        ListNode q = null;
        while (p != null) {
            ListNode one = p;
            p = p.next;
            one.next = q;
            q = one;
        }
        
        //q point the reversed second 
        p = head;
        while (q != null) {
            ListNode one = q;
            q = q.next;
            one.next = p.next;
            p.next = one;
            p = one.next;
        }
    }
