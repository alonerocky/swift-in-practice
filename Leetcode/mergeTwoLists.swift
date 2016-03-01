func mergeTwoLists(l1: ListNode?, _ l2: ListNode?) -> ListNode? {
    if l1 == nil && l2 == nil {
        return nil
    } else if l1 == nil {
        return l2
    } else if l2 == nil {
        return l1
    } else {
        var result: ListNode?
        var p = result
        var p1 = l1
        var p2 = l2
        while p1 != nil && p2 != nil {
            if p1!.val < p2!.val {
                //append p1
                var node = p1
                p1 = p1!.next
                node!.next = nil
                if p == nil {
                    p = node
                    result = p
                } else {
                    p!.next = node
                    p = p!.next
                }
            } else {
                //append p2
                var node = p2
                p2 = p2!.next
                node!.next = nil
                if p == nil {
                    p = node
                    result = p
                } else {
                    p!.next = node
                    p = p!.next
                }
            }
        }
        if p1 != nil {
            p!.next = p1
        } else if (p2 != nil) {
            p!.next = p2
        }
        return result
    }
}

