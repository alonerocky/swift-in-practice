func preorderTraversal(root: TreeNode?) -> [Int] {
    if root == nil {
        return []
    }
    var result: [Int] = []
    result.append(root!.val)
    result.appendContentsOf(preorderTraversal(root!.left))
    result.appendContentsOf(preorderTraversal(root!.right))
    return result
}

func preorderTraversal2(root: TreeNode?) -> [Int] {
    if root == nil {
        return []
    }
    var result: [Int] = []
    var stack: [TreeNode] = []
    stack.append(root!)
    while !stack.isEmpty {
        let top = stack.popLast()!
        result.append(top.val)
        if top.right != nil {
            stack.append(top.right!)
        }
        if top.left != nil {
            stack.append(top.left!)
        }
    }
    return result
}
