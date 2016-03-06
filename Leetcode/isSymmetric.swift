func isSymmetric(root: TreeNode?) -> Bool {
        if root == nil {
            return true
        } else {
            return isSymmetric(root!.left, root!.right)
        }
    }
    func isSymmetric(left: TreeNode?, _ right: TreeNode?) -> Bool {
        if left == nil && right == nil {
            return true
        } else if left != nil && right != nil {
            return left!.val == right!.val && isSymmetric(left!.left, right!.right) && isSymmetric(left!.right, right!.left)
        }
        return false
    }
