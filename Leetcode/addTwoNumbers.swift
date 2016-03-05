func addTwoNumbers(l1: ListNode?, _ l2: ListNode?) -> ListNode? {
    if l1 == nil {
        return l2
    } else if l2 == nil {
        return l1
    } else {
        var result: ListNode?
        var tail: ListNode?
        var p1: ListNode? = l1!
        var p2: ListNode? = l2!
        var carry: Int = 0
        while p1 != nil && p2 != nil {
            var temp: Int = p1!.val + p2!.val + carry
            var node = ListNode(temp % 10)
            carry = temp / 10
            if result == nil {
                result = node
                tail = node
            } else {
                tail!.next = node
                tail = node
            }
            p1 = p1!.next
            p2 = p2!.next
        }
        
        while p1 != nil {
            var temp: Int = p1!.val + carry
            var node = ListNode(temp % 10)
            carry = temp / 10
            tail!.next = node
            tail = node
            p1 = p1!.next
        }
        
        while p2 != nil {
            var temp: Int = p2!.val + carry
            var node = ListNode(temp % 10)
            carry = temp / 10
            tail!.next = node
            tail = node
            p2 = p2!.next
        }
	if carry > 0 {
            var node = ListNode(carry)
            tail!.next = node
        }
        return result
    }
}
