public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return null;
        }
        ListNode result = head;
        while(result != null && result.val == val) {
            result = result.next;
        }
        if (result == null) {
            return result;
        }
        ListNode p = result;
        while(p != null) {
            ListNode q = p.next;
            while(q != null && q.val == val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return result;
    }
