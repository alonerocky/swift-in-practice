//
//  Item.swift
//  Homepwner
//
//  Created by shoulong li on 5/24/15.
//  Copyright (c) 2015 shoulong li. All rights reserved.
//

import UIKit

class Item: NSObject {
    var name: String = ""
    var valueInDollars:Int = 0
    var serialNumber:String = ""
    var dateCreated: NSDate = NSDate()
    
    init(name: String, serialNumber: String, valueInDollars: Int) {
        self.name = name
        self.serialNumber = serialNumber
        self.valueInDollars = valueInDollars
        
        super.init()
    }
    
    convenience init(random: Bool) {
        
        if random {
            let adjectives = ["Fluffy", "Rusty", "Shiny"]
            let nounts = ["Bear", "Spork", "Mac"]
            
            var idx = arc4random_uniform(UInt32(adjectives.count))
            let randomAdjective = adjectives[Int(idx)]
            
            idx = arc4random_uniform(UInt32(nounts.count))
            let randomNoun = nounts[Int(idx)]
            
            let randomName = "\(randomAdjective) \(randomNoun)"
            let randomValue = Int(arc4random_uniform(100))
            let randomSerialNumber = NSUUID().UUIDString
            self.init(name: randomName, serialNumber: randomSerialNumber, valueInDollars: randomValue)
        } else {
            self.init(name: "Item", serialNumber: "", valueInDollars: 0)
        }
    }
    
    
}
