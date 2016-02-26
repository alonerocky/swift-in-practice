func minDepth(root: TreeNode?) -> Int {
        if root == nil {
            return 0
        } else if root!.left == nil {
            return minDepth(root!.right) + 1
        } else if root!.right == nil {
            return minDepth(root!.left) + 1
        } else {
            return min(minDepth(root!.left), minDepth(root!.right)) + 1
        }
        
    }
