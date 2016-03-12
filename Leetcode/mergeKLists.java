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

//iterate
