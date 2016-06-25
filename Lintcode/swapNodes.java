public ListNode swapNodesII(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = null;
        ListNode prev1 = null;
        ListNode p2 = null;
        ListNode prev2 = null;
        ListNode p = head;
        ListNode prev = null;
        while(p != null) {
            if (p.val == v1) {
                p1 = p;
                prev1 = prev;
            } else if (p.val == v2) {
                p2 = p;
                prev2 = prev;
            } 
            prev = p;
            p = p.next;
        }
        if (p1 == null || p2 == null || p1 == p2) {
            return head;
        }
        
        //handle the case p1 and p2 and adjacent
        if (p1.next == p2) {
            p1.next = p2.next;
            p2.next = p1;
            if (prev1 == null) {
                return p2;
            } else {
                prev1.next = p2;
                return head;
            }
        } else if (p2.next == p1) {
            p2.next = p1.next;
            p1.next = p2;
            if (prev2 == null) {
                return p1;
            } else {
                prev2.next = p1;
                return head;
            }
        }
        
        if (prev1 == null) {
            prev2.next = p2.next;
            p2.next = p1.next;
            
            p1.next = prev2.next;
            prev2.next = p1;
            return p2;
        } else if (prev2 == null) {
            prev1.next = p1.next;
            p1.next = p2.next;
            
            p2.next = prev1.next;
            prev1.next = p2;
            return p1;
        } else {
            prev2.next = p2.next;
            p2.next = p1.next;
            prev1.next = p2;
            
            p1.next = prev2.next;
            prev2.next = p1;
            return head;
        }
    }
    
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = null;
        ListNode prev1 = null;
        ListNode p2 = null;
        ListNode prev2 = null;
         
         
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p = head;
        while(p != null) {
            if (p.val == v1) {
                p1 = p;
                prev1 = prev;
            } else if (p.val == v2) {
                p2 = p;
                prev2 = prev;
            } 
            prev = p;
            p = p.next;
        }
        if (p1 == null || p2 == null || p1 == p2) {
            return head;
        }
        
        //handle the case p1 and p2 and adjacent
        if (p1.next == p2) {
            p1.next = p2.next;
            p2.next = p1;
            prev1.next = p2;
            
        } else if (p2.next == p1) {
            p2.next = p1.next;
            p1.next = p2;
            prev2.next = p1;
            
        } else {
            prev2.next = p2.next;
            p2.next = p1.next;
            prev1.next = p2;
            
            p1.next = prev2.next;
            prev2.next = p1;
        }
        
        return dummy.next;
    }
