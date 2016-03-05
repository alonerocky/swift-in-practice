 func sortedListToBST(head: ListNode?) -> TreeNode? {
        if head == nil {
            return nil
        } else if (head!.next == nil) {
            return TreeNode(head!.val)
        } else {
            var doubleSteps: ListNode? = head
            var singleStep: ListNode? = head
            var previous: ListNode?
            while doubleSteps != nil && doubleSteps!.next != nil {
                doubleSteps = doubleSteps!.next!.next
                previous = singleStep
                singleStep = singleStep!.next
            }
            
            //singleStep now point to the start of second half
            previous!.next = nil
            var result: TreeNode = TreeNode(singleStep!.val)
            result.left = sortedListToBST(head)
            result.right = sortedListToBST(singleStep!.next)
            return result
        }
    }
