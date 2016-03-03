func postorderTraversal(root: TreeNode?) -> [Int] {
        var result: [Int] = []
        var stack: [TreeNode] = []
        if root == nil {
            return result
        }
        stack.append(root!)
        var prev: TreeNode?
        var current: TreeNode!
        while !stack.isEmpty {
            current = stack.last!
            if prev == nil || prev!.left === current || prev!.right === current {
                if current.left != nil {
                    stack.append(current.left!)
                } else if current.right != nil {
                    stack.append(current.right!)
                } else {
                    result.append(current.val)
                    stack.popLast()
                }
            } else if (current.left === prev) {
                if current.right != nil {
                    stack.append(current.right!)
                } else {
                    result.append(current.val)
                    stack.popLast()
                }
            } else if prev === current.right {
                result.append(current.val)
                stack.popLast()
            }
            prev = current
        }
        return result
    }

