func inorderTraversal(root: TreeNode?) -> [Int] {
        var result : [Int] = []
        var stack: [TreeNode] = []
        pushLeft(root, &stack)
        while !stack.isEmpty {
            var current = stack.popLast()!
            result.append(current.val)
            pushLeft(current.right, &stack)
        }
        return result
    }
    func pushLeft(root: TreeNode?, inout _ stack: [TreeNode]) {
        var current = root
        while let node = current {
            stack.append(node)
            current = current?.left
        }
    }
