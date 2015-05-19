//
//  HypnosisterView.swift
//  Hypnosister
//
//  Created by shoulong li on 5/11/15.
//  Copyright (c) 2015 shoulong li. All rights reserved.
//

import UIKit

class HypnosisterView: UIView {

    required init(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        backgroundColor = UIColor.clearColor()
    }
    
    // Only override drawRect: if you perform custom drawing.
    // An empty implementation adversely affects performance during animation.
    override func drawRect(rect: CGRect) {
        let bounds = self.bounds
        let origin = bounds.origin
        let centerX = origin.x +  bounds.width / 2.0
        let centerY = origin.y +  bounds.height / 2.0
        let center = CGPoint(x: centerX, y: centerY)
        let w = bounds.width
        let h = bounds.height
        
        let maxRadius = sqrt(w * w + h * h)
        
        for var r:CGFloat = 0.0; r <= maxRadius; r += 20 {
            
            let path = UIBezierPath()
            path.addArcWithCenter(center, radius: r, startAngle: 0, endAngle: CGFloat(M_PI * 2.0), clockwise: true)
            
            path.lineWidth = 10
            
            UIColor.purpleColor().setStroke()
            
            path.stroke()
        }
    }


}
