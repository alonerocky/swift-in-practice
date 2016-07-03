public ListNode plusOne(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }
        ListNode reversed = reverse(head);
        int carray = 0;
        ListNode p = reversed;
        boolean least = true;
        ListNode prev = null;
        while(p != null) {
            int r = p.val + carray + (least ? 1 : 0);
            if (least) {
                least = false;
            }
            p.val = r % 10;
            carray = r / 10;
            prev = p;
            p = p.next;
        }
        
        if (carray != 0) {
            prev.next = new ListNode(1);
        }
        
        return reverse(reversed);
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversed = null;
        ListNode p = head;
        while(p != null) {
            ListNode one = p;
            p = p.next;
            one.next = reversed;
            reversed = one;
        }
        return reversed;
    }
