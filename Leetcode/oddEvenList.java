public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = null;
        ListNode oddTail = null;
        ListNode even = null;
        ListNode evenTail = null;
        ListNode p = head;
        int i = 0;
        while (p != null) {
            ListNode node = p;
            i++;
            p = p.next;
            node.next = null;
            
            if (i % 2 == 0) { //even
                if (even == null) {
                    even = evenTail = node;
                } else {
                    evenTail.next = node;
                    evenTail = evenTail.next;
                }
            } else {
                if (odd == null) {
                    odd = oddTail = node;
                } else {
                    oddTail.next = node;
                    oddTail = oddTail.next;
                }
            }
        }
        if (odd == null) {
            return even;
        } else {
            oddTail.next = even;
            return odd;
        }
    }
