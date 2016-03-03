    func reverseList(head: ListNode?) -> ListNode? {
        if head == nil {
            return nil
        }
        var result : ListNode? 
        var p = head
        while let current = p {
            p = p!.next
            current.next = result
            result = current
        }
        return result
    }
