def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        else:
            left = self.maxDepth(root.left)
            right = self.maxDepth(root.right)
            return max(left, right) + 1
