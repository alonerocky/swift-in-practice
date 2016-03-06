func sortedArrayToBST(nums: [Int]) -> TreeNode? {
    if nums.count == 0 {
        return nil
    }
    return sortedArrayToBST(nums, 0, nums.count - 1)
}

func sortedArrayToBST(nums: [Int], _ start: Int, _ end: Int) -> TreeNode? {
    if start > end {
        return nil
    } else if (start == end) {
        return TreeNode(nums[start])
    } else {
        var middle: Int = (start + end) / 2
        var root: TreeNode = TreeNode(nums[middle])
        root.left = sortedArrayToBST(nums, start, middle - 1)
        root.right = sortedArrayToBST(nums, middle + 1, end)
        return root
    }
}
