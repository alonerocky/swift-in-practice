func buildTree(preorder: [Int], _ inorder: [Int]) -> TreeNode? {
        if preorder.count == 0 || inorder.count == 0 || preorder.count != inorder.count {
            return nil
        }
        return buildTree(preorder, 0, preorder.count - 1, inorder, 0, inorder.count - 1)
    }
    
    func buildTree(preorder: [Int], _ pstart: Int, _ pend: Int, _ inorder: [Int], _ istart: Int, _ iend: Int) -> TreeNode? {
        if pstart > pend || istart > iend || (iend - istart) != (pend - pstart) {
            return nil
        }
        if pstart == pend {
            return TreeNode(preorder[pstart])
        } else {
            var rootValue: Int = preorder[pstart]
            var root: TreeNode = TreeNode(rootValue)
            var iroot: Int = findIndex(inorder, istart, iend, rootValue)
            //pstart + 1, xxx,    xxx + 1, pend
            //istart , iroot - 1, iroot + 1, iend
            //xxx - pstart - 1 = iroot -1 - istart --> xxx = iroot - istart + pstart
            //iend - iroot -1 = pend - xxx - 1 --> xxx = pend - iend + iroot
            var index = pend - iend + iroot
            root.left =  buildTree(preorder, pstart + 1, index, inorder, istart, iroot - 1)
            root.right = buildTree(preorder, index + 1, pend, inorder, iroot + 1, iend)
            return root
        }
    }
    
    func findIndex(nums: [Int], _ start: Int, _ end: Int, _ target: Int) ->Int{
        for var i in start ... end {
            if nums[i] == target {
                return i
            }
        }
        return -1
    }
