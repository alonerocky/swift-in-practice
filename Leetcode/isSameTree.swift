func isSameTree(p: TreeNode?, _ q: TreeNode?) -> Bool {
    if let l = p {
        if let r = q {
            return l.val == r.val && isSameTree(l.left, r.left) && isSameTree(l.right, r.right)
        } else {
            return false
        }
    } else  {
        if let _ = q {
            return false
        } else {
            return true
        }
    }
}
