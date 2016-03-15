public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
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
        tail.next = null;
        ListNode reversed = null;
        while (slow != null) {
            ListNode one = slow;
            slow = slow.next;
            one.next = reversed;
            reversed = one;
        }
        
        //now reversed point to reversed second part
        //compare them
        ListNode p = head;
        ListNode q = reversed;
        //p is either equal or one more elemnt than q
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
