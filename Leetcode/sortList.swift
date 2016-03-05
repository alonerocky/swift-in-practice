func sortList(head: ListNode?) -> ListNode? {
        if head == nil || head!.next == nil {
            return head
        }
        
        //use merge sort idea, choose the first element 
        var slow: ListNode? = head
        var fast: ListNode? = head
        var previous: ListNode?
        while fast != nil && fast!.next != nil {
            previous = slow
            fast = fast!.next!.next
            slow = slow!.next
        }
        
        //slow now point of start of second half
        previous!.next = nil
        var p1 = sortList(head)
        var p2 = sortList(slow)
        return mergeSortedList(p1, p2)
        
    }
    
    func mergeSortedList(l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        if l1 == nil {
            return l2
        } else if l2 == nil {
            return l1
        } else {
            var l: ListNode?
            var tail: ListNode?
            var p1 = l1
            var p2 = l2
            while p1 != nil && p2 != nil {
                if p1!.val < p2!.val {
                    var node = p1!
                    p1 = p1!.next
                    node.next = nil
                    if l == nil {
                        l = node
                        tail = node
                    } else {
                        tail!.next = node
                        tail = node
                    }
                } else {
                    var node = p2!
                    p2 = p2!.next
                    node.next = nil
                    if l == nil {
                        l = node
                        tail = node
                    } else {
                        tail!.next = node
                        tail = node
                    }
                }
            }
            while p1 != nil {
                var node = p1!
                p1 = p1!.next
                node.next = nil
                tail!.next = node
                tail = node
            }
            while p2 != nil {
                var node = p2!
                p2 = p2!.next
                node.next = nil
                tail!.next = node
                tail = node
            }
            return l
        }
        
    }
