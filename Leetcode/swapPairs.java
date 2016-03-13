public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode result = null;
        ListNode tail = null;
        while (p != null && p.next != null) {
            ListNode one = p;
            ListNode two = p.next;
            p = p.next.next;
            //swap
            one.next = null;
            two.next = one;
            if (result == null) {
                result = two;
                tail = one;
            } else {
                tail.next = two;
                tail = one;
            }
        }
        if (p != null) { //nodes number is odd
            tail.next = p;
        }
        return result;
    }


//recursive
public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = head.next;
        ListNode rest = swapPairs(two.next);
        two.next = one;
        one.next = rest;
        return two;
    }
