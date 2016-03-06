/*
func invertTree(root: TreeNode?) -> TreeNode? {
if root == nil {
return nil
}
var temp = root!.left
root!.left = invertTree(root!.right)
root!.right = invertTree(temp)
return root
}
*/
func invertTree(root: TreeNode?) -> TreeNode? {
    if root == nil {
        return nil
    }
    
    var queue: [TreeNode] = []
    queue.append(root!)
    while !queue.isEmpty {
        var node: TreeNode = queue.removeFirst()
        var left = node.left
        node.left = node.right
        node.right = left
        
        if node.right != nil {
            queue.append(node.right!)
        }
        if node.left != nil {
            queue.append(node.left!)
        }
    }
    return root
}
