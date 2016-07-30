//
//  TreeNode.swift
//  TestLeetCode
//
//  Created by shoulong li on 3/2/16.
//  Copyright © 2016 shoulong li. All rights reserved.
//

import Foundation

public class TreeNode {
         public var val: Int
         public var left: TreeNode?
         public var right: TreeNode?
         public init(_ val: Int) {
                 self.val = val
                     self.left = nil
                     self.right = nil
             }
     }