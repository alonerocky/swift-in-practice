func isSameTree(p: TreeNode?, _ q: TreeNode?) -> Bool {
    return p == nil && q == nil ||
        p != nil &&
        q != nil &&
        p!.val == q!.val &&
        isSameTree(p!.left, q!.left) &&
        isSameTree(p!.right, q!.right)
}
