public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        //fist get the number of nodes
        ListNode p = head;
        ListNode tail = null;
        int n = 0;
        while(p != null) {
            n ++;
            tail = p;
            p = p.next;
        }
        if (k % n == 0) {
            return head;
        }
        
        k = k % n;
        
        //get the (n - k)th node 
        p = head;
        ListNode previous = null;
        int i = 0;
        while (i < n - k) {
            previous = p;
            p = p.next;
            i++;
        }
        //previous will be the new tail, p will be new head;
        previous.next = null;
        tail.next = head;
        return p;
    }
