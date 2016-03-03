/*
    func flatten(root: TreeNode?) {
    if root == nil {
        return
    }
    var current: TreeNode? = nil
    var stack: [TreeNode] = []
    stack.append(root!)
    while !stack.isEmpty {
        let top: TreeNode! = stack.popLast()!
        if top.right != nil {
            stack.append(top.right!)
        }
        if top.left != nil {
            stack.append(top.left!)
        }
        top.left = nil
        top.right = nil
        if current == nil {
            current = top
        } else {
            current!.right = top
            current = current!.right!
        }
    }
}
*/
func flatten(root: TreeNode?) {
    if root == nil {
        return
    }
    flatten(root!.right)
    let right = root!.right
    if root!.left != nil {
        flatten(root!.left)
        let left = root!.left
        root!.left = nil
        var p = left!
        while p.right != nil {
            p = p.right!
        }
        p.right = right
        root!.right = left
    }
}
