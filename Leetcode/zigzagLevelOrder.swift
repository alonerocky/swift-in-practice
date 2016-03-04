func zigzagLevelOrder(root: TreeNode?) -> [[Int]] {
        var result: [[Int]] = []
        if root == nil {
            return result
        }
        var currentLevel: [TreeNode] = []
        var nextLevel: [TreeNode] = []
        var level: [Int] = []
        var leftToRight: Bool = true
        currentLevel.append(root!)
        while !currentLevel.isEmpty {
            let node = currentLevel.removeFirst()
            if node.left != nil {
                nextLevel.append(node.left!)
            }
            if node.right != nil {
                nextLevel.append(node.right!)
            }
            //append to level result
            if leftToRight {
                level.append(node.val)
            } else {
                level.insert(node.val, atIndex: 0)
            }
            if currentLevel.isEmpty {
                result.append(level)
                currentLevel = nextLevel
                nextLevel = []
                level = []
                leftToRight = !leftToRight
            }
        }
        return result
    }
