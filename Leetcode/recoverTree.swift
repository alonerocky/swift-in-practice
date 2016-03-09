func recoverTree(root: TreeNode?) {
        var prev: TreeNode?
        var left: TreeNode?
        var right: TreeNode?
        recoverTree(root, &prev, &left, &right);
        if left != nil && right != nil {
            var temp = left!.val;
            left!.val = right!.val
            right!.val = temp
        }
    }
    func recoverTree(root: TreeNode?, inout _ prev: TreeNode?, inout _ left: TreeNode?, inout _ right: TreeNode?) {
        if root == nil {
            return
        }
        
        recoverTree(root!.left, &prev, &left,  &right)
        if (prev != nil && prev!.val > root!.val) {
            if left == nil {
                left = prev!
            }
            right = root!
        }
        prev = root!
        recoverTree(root!.right, &prev, &left, &right)
    }
