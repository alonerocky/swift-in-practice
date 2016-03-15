public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        
        //first, get the tail of a
        ListNode tailA = headA;
        while (tailA != null && tailA.next != null) {
            tailA = tailA.next;
        }
        //now tailA point to tail of A
        
        
        //second, link tailA to headB
        tailA.next = headB;
        
        //third, detect if there is one circle
        ListNode fast = headA;
        ListNode slow = headA;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //there must be a circle
                break;
            }
        }
        if (fast == null || fast.next == null) {
            //before we return, we restore the lists
            tailA.next = null;
            return null; //there is no circle
        }
        
        slow = headA;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        //now slow == fast
        
        //now slow and fast both point to the intersection
        
        tailA.next = null;
        
        return slow;
    }
