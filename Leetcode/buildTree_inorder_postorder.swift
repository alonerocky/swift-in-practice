func buildTree(inorder: [Int], _ postorder: [Int]) -> TreeNode? {
        if inorder.count == 0 || postorder.count == 0 || inorder.count != postorder.count {
            return nil
        }
        return buildTree(inorder, 0, inorder.count - 1, postorder, 0, postorder.count - 1)
    }
    
    func buildTree(inorder: [Int], _ istart: Int, _ iend: Int, _ postorder: [Int], _ pstart: Int, _ pend: Int) -> TreeNode? {
        if istart > iend || pstart > pend {
            return nil
        }
        if (iend - istart) != (pend - pstart) {
            return nil
        }
        if istart == iend {
            return TreeNode(inorder[istart])
        }
        else {
            var rootValue = postorder[pend]
            var root = TreeNode(rootValue)
            //pstart ... pend - 1
            var iroot = findIndex(inorder, istart, iend, rootValue)
            //istart ... iroot -1    iroot + 1 ... iend
            //pstart ...  xxx        xxx + 1 ... pend -1 
            var index = pstart + iroot - 1 - istart// pend - 1 + iroot - iend 
            root.left = buildTree(inorder, istart, iroot - 1, postorder, pstart, index)
            root.right = buildTree(inorder, iroot + 1, iend, postorder, index + 1, pend - 1)
            return root
        }
    }
    
    func findIndex(nums: [Int], _ start: Int, _ end: Int, _ target: Int) -> Int{
        for var i in start ... end {
            if nums[i] == target {
                return i
            }
        }
        return -1
    }
