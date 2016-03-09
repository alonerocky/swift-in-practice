public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode sorted = null;
        ListNode p1 = null;
        ListNode p = head;
        while (p != null) {
            ListNode node = p;
            p = p.next;
            node.next = null;
            
            //now insert the node to the sorted list
            if (p1 == null) {
                p1 = sorted = node;
            } else { //find the position to insert
                ListNode q = sorted;
                ListNode prev = null;
                while (q != null && q.val <= node.val)  {
                    prev = q;
                    q = q.next;
                }
                if (q == null) { //insert to the end
                    p1.next = node;
                    p1 = p1.next;
                } else if (prev == null) { //insert to the head
                    node.next = sorted;
                    sorted = node;
                } else { //in the middle
                    node.next = q;
                    prev.next = node;
                }
            }
        }
        return sorted;
    }
