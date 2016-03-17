public ListNode reverseBetween(ListNode head, int m, int n) {
     
        if (head == null || head.next == null) {
            return head;
        }
        if (m == n) {
            return head;
        }
        int i = 1;
        ListNode p = head;
        ListNode beforeM = null;
        ListNode mNode = null;
        ListNode nNode = null;
        ListNode afterN = null;
        while (p != null && i < m) {
            beforeM = p;
            p = p.next;
            i++;
        }
        //now p point to mth element
        if (beforeM != null) {
            beforeM.next = null;
        }
        mNode = p;
        ListNode reversed = null;
        while (p != null && i <= n) {
            ListNode one = p;
            p = p.next;
            afterN = p;
            one.next = reversed;
            reversed = one;
            i++;
        }
        
        //now p point to afterN
        afterN = p;
        if (beforeM == null) {
            mNode.next = afterN;
            return reversed;
        } else {
            mNode.next = afterN;
            beforeM.next = reversed;
            return head;
        }
        
        
    }
