public ListNode reverseKGroupI(ListNode head, int k) {
        if (head == null || k <= 1 ) {
            return head;
        }
        
        ListNode p = head;
        int i = 1;
        while (i < k && p != null) {
            p = p.next;
            i++;
        }
        if (p == null) {
            return head;
        }
        
        //p now point to the kth 
        
        ListNode tail = reverseKGroup(p.next, k);
        p.next = null;
        ListNode reversed = null;
        ListNode q = head;
        while (q != null) {
            ListNode one = q;
            q = q.next;
            one.next = reversed;
            reversed = one;
        }
        head.next = tail;
        return reversed;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        
        ListNode p = head;
        ListNode result = null;
        ListNode tail = null;
        while (p != null) {
            int i = 1; 
            ListNode q = p;
            while (q != null && i < k) {
                i++;
                q = q.next;
            }
            
            //q either is null, or i == k
            if (q == null) {
                if (result == null) {
                    return head;
                } else {
                    tail.next = p;
                    return result;
                }
            }
            ListNode rest = q.next;
            q.next = null;
            
            
            ListNode h = p; //p is the head;
            ListNode reverted = revert(p);
            
            if (result == null) {
                result = reverted;
                tail = h;
            } else {
                tail.next = reverted;
                tail = h;
            }
            
            p = rest;
        }
        return result;
    }
    
    private ListNode revert(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverted = null;
        ListNode p = head;
        while (p != null) {
            ListNode one = p;
            p = p.next;
            one.next = reverted;
            reverted = one;
        }
        return reverted;
    }
