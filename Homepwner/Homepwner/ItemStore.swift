//
//  ItemStore.swift
//  Homepwner
//
//  Created by shoulong li on 5/24/15.
//  Copyright (c) 2015 shoulong li. All rights reserved.
//

import UIKit

class ItemStore: NSObject {
    var allItems: [Item] = []
    
    func createItem() -> Item {
        let newItem = Item(random: true)
        
        allItems.append(newItem)
        
        return newItem
    }
   
}
