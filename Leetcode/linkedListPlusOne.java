public ListNode plusOne(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }
        ListNode reversed = reverse(head);
        ListNode p = reversed;
        ListNode result = null;
        boolean least = true;
        int carray = 0;
        while(p != null) {
            int r = p.val + carray + (least ? 1 : 0);
            if (least) {
                least = false;
            }
            ListNode one = p;
            p = p.next;
            one.next = null;
            one.val = r % 10;
            carray = r / 10;
            one.next = result;
            result = one;
        }
        if (carray != 0) {
            ListNode one = new ListNode(1);
            one.next = result;
            result = one;
        }
        return result;
        
         
    }
    //create new linked list
    public ListNode plusOneI(ListNode head) {
        if (head == null) {
            return new ListNode(1);
        }
        ListNode reversed = reverse(head);
        ListNode p = reversed;
        ListNode result = null;
        boolean least = true;
        int carray = 0;
        while(p != null) {
            int r = p.val + carray + (least ? 1 : 0);
            if (least) {
                least = false;
            }
            ListNode one = new ListNode(r % 10);
            carray = r/10;
            one.next = result;
            result = one;
            
            
            p = p.next;
        }
        if (carray != 0) {
            ListNode one = new ListNode(1);
            one.next = result;
            result = one;
        }
        return result;
        
         
    }
    public ListNode plusOneII(ListNode head) {
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
