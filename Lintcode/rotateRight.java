public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null || k == 0) {
            return head;
        }
         
        int i = 1;
        ListNode p = head;
        while(p.next != null ) {
            p = p.next;
            i++;
        }
        ListNode tail = p;
        k = k % i;
        if (k == 0) {
            return head;
        }
        
        int nth = i - k;
         
        i = 1;
        p = head;
        while(p != null && i < nth) {
            i++;
            p = p.next;
        }
        ListNode q = p.next;
        p.next = null;
        tail.next = head;
        return q;
     } 
     
    public ListNode rotateRightI(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null || k == 0) {
            return head;
        }
         
        int i = 1;
        ListNode p = head; 
        while(p.next != null ) {
            p = p.next;
            i++;
        } 
        k = k % i;
        if (k == 0) {
            return head;
        }
        
        ListNode reversed = reverse(head);
        
        i = 1;
        p = reversed;
        while(p != null && i < k) {
            p = p.next;
            i++;
        }
        
        //p point to end of first half
        ListNode q = p.next;
        p.next = null;
        reverse(reversed);
        reversed.next = reverse(q);
         
        return p; 
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
