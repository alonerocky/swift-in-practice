//
//  MiniMapView.swift
//  Hypnosister
//
//  Created by shoulong li on 5/19/15.
//  Copyright (c) 2015 shoulong li. All rights reserved.
//

import UIKit

class MiniMapView: UIView {
    var relativeX:CGFloat = 0.0 {
        didSet {
            println("relativeX changed")
            setNeedsDisplay()
        }
    }
    
    var relativeY:CGFloat = 0.0 {
        didSet {
            println("relativeY changed")
            setNeedsDisplay()
        }
    }
    
    var relativeWidth:CGFloat = 0.0 {
        didSet {
            println("relativeWidth changed")
            setNeedsDisplay()
        }
    }
    
    var relativeHeight:CGFloat = 0.0 {
        didSet {
            println("relativeHeight changed")
            setNeedsDisplay()
        }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        backgroundColor = UIColor.lightGrayColor().colorWithAlphaComponent(0.7)
    }
    
    required init(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
    }

    
    // Only override drawRect: if you perform custom drawing.
    // An empty implementation adversely affects performance during animation.
    override func drawRect(rect: CGRect) {
        // Drawing code
        
        let bounds = self.bounds
        let x = bounds.width * relativeX
        let y = bounds.height * relativeY
        let width = bounds.width * relativeWidth
        let height = bounds.height * relativeHeight
        
        let path = UIBezierPath()
        path.moveToPoint(CGPoint(x: x, y: y))
        path.addLineToPoint(CGPoint(x: x+width, y: y))
        path.addLineToPoint(CGPoint(x: x+width, y: y+height))
        path.addLineToPoint(CGPoint(x: x, y: y+height))
        path.closePath()
        UIColor.grayColor().colorWithAlphaComponent(0.8).setFill()
        path.fill()
    }
    
    func updateWithScrollView(sv: UIScrollView) {
        relativeX = sv.contentOffset.x / sv.contentSize.width
        relativeY = sv.contentOffset.y / sv.contentSize.height
        relativeWidth = sv.bounds.width / sv.contentSize.width
        relativeHeight = sv.bounds.height / sv.contentSize.height
    }

}
