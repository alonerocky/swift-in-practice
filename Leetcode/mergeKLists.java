public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null;
        ListNode tail = null;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        };
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, comparator);
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                minHeap.offer(node);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            if (result == null) {
                result = minNode;
                tail = minNode;
            } else {
                tail.next = minNode;
                tail = tail.next;
            }
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return result;
    }


//recursive
public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        
        ListNode first = lists[0];
        ListNode[] rest = Arrays.copyOfRange(lists, 1, lists.length - 1);
        return mergeTwoLists(first, mergeKLists(rest));
        
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = null;
        ListNode tail = null;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                ListNode one = p1;
                p1 = p1.next;
                one.next = null;
                if (result == null) {
                    result = tail = one;
                } else {
                    tail.next = one;
                    tail = one;
                }
            } else {
                ListNode one = p2;
                p2 = p2.next;
                one.next = null;
                if (result == null) {
                    result = tail = one;
                } else {
                    tail.next = one;
                    tail = one;
                }
            }
        }
        
        while (p1 != null) {
            ListNode one = p1;
            p1 = p1.next;
            one.next = null;
            tail.next = one;
            tail = one;
        }
        
        while (p2 != null) {
            ListNode one = p2;
            p2 = p2.next;
            one.next = null;
            tail.next = one;
            tail = one;
        }
        return result;
    }
//iterate
