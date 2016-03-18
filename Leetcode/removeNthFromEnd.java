public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        //get the number of nodes;
        ListNode p = head;
        int num = 0;
        while (p != null) {
            num++;
            p = p.next;
        }
        
        //num is the 
        //calculate which node is the 
        
        //validate n
        if (n > num) {
            return head;
        }
        ListNode previous = null;
        //num + 1 - n  will be the index (start from 1) from the beginning
        int i = 1;
        p = head;
        while (p != null && i < num + 1 - n) {
            previous = p;
            p = p.next;
            i++;
        }
        //p now point to num + 1 - n
        if (previous == null) {
            //remove the first one;
            ListNode q = p;
            p = p.next;
            q.next = null;
            return p;
        } else {
            previous.next = p.next;
            p.next = null;
            return head;
        }
    }
