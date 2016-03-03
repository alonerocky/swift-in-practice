func levelOrderBottom(root: TreeNode?) -> [[Int]] {
    var result: [[Int]] = []
    if root == nil {
        return result
    }
    var currentLevel: [TreeNode] = []
    var nextLevel: [TreeNode] = []
    currentLevel.append(root!)
    var level: [Int] = []
    while !currentLevel.isEmpty {
        var node = currentLevel.removeFirst()
        level.append(node.val)
        if node.left != nil {
            nextLevel.append(node.left!)
        }
        if node.right != nil {
            nextLevel.append(node.right!)
        }
        if currentLevel.isEmpty {
            result.insert(level, atIndex: 0)
            level = []
            currentLevel = nextLevel
            nextLevel = []
        }
    }
    return result
}
