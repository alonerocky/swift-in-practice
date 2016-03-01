func isBalanced(root: TreeNode?) -> Bool {
    if root == nil {
        return true
    } else {
        let l = getHeight(root!.left)
        let r = getHeight(root!.right)
        return abs(l - r) <= 1 && isBalanced(root!.left) && isBalanced(root!.right)
    }
}
func getHeight(root: TreeNode?) -> Int {
    if root == nil {
        return 0
    } else {
        return 1 + max(getHeight(root!.left), getHeight(root!.right))
    }
}
