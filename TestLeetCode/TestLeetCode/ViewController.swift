//
//  ViewController.swift
//  TestLeetCode
//
//  Created by shoulong li on 2/28/16.
//  Copyright © 2016 shoulong li. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        countAndSayIII(2)
        /*
        
        var treeNode1 = TreeNode(1)
        var treeNode2 = TreeNode(2)
        var treeNode3 = TreeNode(3)
        var treeNode4 = TreeNode(4)
        var treeNode5 = TreeNode(5)
        var treeNode6 = TreeNode(6)
        var treeNode7 = TreeNode(7)
        treeNode2.left = treeNode1
        treeNode2.right = treeNode3
        
        treeNode6.left = treeNode5
        treeNode6.right = treeNode7
        treeNode4.left = treeNode2
        treeNode4.right = treeNode6
        inorderTraversal(treeNode4)
        */
        compareVersion("01", "1")
        var node1 = ListNode(1)
        var node3 = ListNode(3)
        node1.next = node3
        sortedListToBST(node1)
    }
    
    func sortedListToBST(head: ListNode?) -> TreeNode? {
        if head == nil {
            return nil
        } else if (head!.next == nil) {
            return TreeNode(head!.val)
        } else {
            var doubleSteps: ListNode? = head
            var singleStep: ListNode? = head
            var previous: ListNode?
            while doubleSteps != nil && doubleSteps!.next != nil {
                doubleSteps = doubleSteps!.next!.next
                previous = singleStep
                singleStep = singleStep!.next
            }
            
            //singleStep now point to the start of second half
            previous!.next = nil
            var result: TreeNode = TreeNode(singleStep!.val)
            result.left = sortedListToBST(head)
            result.right = sortedListToBST(singleStep!.next)
            return result
        }
    }
    
    func compareVersion(version1: String, _ version2: String) -> Int {
        var v1 = version1.componentsSeparatedByString(".")
        var v2 = version2.componentsSeparatedByString(".")
        var v1_majority = Int(v1[0])
        var v1_minor = v1.count == 2 ? Int(v1[1]) : 0
        var v2_majority = Int(v2[0])
        var v2_minor = v2.count == 2 ? Int(v2[1]) : 0
        if v1_majority < v2_majority {
            return -1
        } else if v1_majority > v2_majority  {
            return 1
        } else {
            if v1_minor == v2_minor {
                return 0
            } else if v1_minor < v2_minor {
                return -1
            } else {
                return 1
            }
        }
    }
    
    func inorderTraversal(root: TreeNode?) -> [Int] {
        var result: [Int] = []
        if root == nil {
            return result
        }
        
        var stack: [TreeNode] = []
        pushLeft(root!, stack: &stack)
        while !stack.isEmpty {
            let current: TreeNode = stack.popLast()!
            result.append(current.val)
            pushLeft(current.right, stack: &stack)
        }
        
        return result
    }
    func pushLeft(root: TreeNode?, inout stack: [TreeNode]) {
        var current = root
        while let node = current {
            stack.append(node)
            current = current?.left
        }
    }
    
    
    func countAndSayIII(n: Int) -> String {
        var current: String = "1"
        for var i = 1; i < n; i++ {
            let previous: String = current
            current = ""
            var counter = 0
            var c: Character = previous[previous.startIndex]
            let length = previous.characters.count
            var j: Int = 0
            while j < length {
                if c == previous[previous.startIndex.advancedBy(j)] {
                    counter++
                    j++
                } else {
                    //output
                    current = "\(current)\(counter)\(c)"
                    c = previous[previous.startIndex.advancedBy(j)]
                    counter = 0
                    j++
                }
            }
            current = "\(current)\(counter)\(c)"
        }
        return current
    }


    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

