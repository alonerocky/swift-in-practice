//
//  LRUCache.swift
//  Social Photos
//
//  Created by shoulong li on 1/5/16.
//  Copyright © 2016 shoulong li. All rights reserved.
//

import Foundation

class LRUCache<K: Hashable, V> {
    var capacity: Int
    //header next point to the eldest
    //header prev point to the newest
    //it is a circle
    var header: DoubleLinkedListEntry<K, V>!
    var dictionary: Dictionary<K, DoubleLinkedListEntry<K, V>>
    
    init(capacity: Int) {
        self.capacity = capacity
        dictionary = Dictionary<K, DoubleLinkedListEntry<K, V>>(minimumCapacity: capacity)
        header = DoubleLinkedListEntry<K, V>()
        header.prev = header
        header.next = header
    }
    
    func count() -> Int {
        return dictionary.count
    }
    
    subscript(key: K) -> V? {
        get {
            if let entry = dictionary[key] {
                entry.remove()
                entry.addBefore(header)
                return entry.value
            } else {
                return nil
            }
        }
        
        set(value) {
            //remove the entry if exist
            if let entry = dictionary[key] {
                entry.remove()
                dictionary.removeValueForKey(entry.key!)
            }
            if value != nil {
                let newEntry = DoubleLinkedListEntry(key: key, value: value)
                dictionary[key] = newEntry
                newEntry.addBefore(header)
                if dictionary.count > self.capacity {
                    removeEldestEntry()
                }
            }
        }
    }
    
    
    func removeEldestEntry() {
        if header.next === header {
            //empty
        } else {
            dictionary.removeValueForKey(header.next!.key!)
            header.next?.remove()
        }
    }
}

class DoubleLinkedListEntry<K: Hashable, V> {
    var key: K? = nil
    var value: V? = nil
    var prev: DoubleLinkedListEntry<K, V>? = nil
    var next: DoubleLinkedListEntry<K, V>? = nil
    
    init() {
        
    }
    
    init(key: K, value: V?) {
        self.key = key
        self.value = value
    }
    
    //add self before the entry
    func addBefore(entry: DoubleLinkedListEntry) {
        prev = entry.prev
        next = entry
        prev?.next = self
        next?.prev = self
    }
    
    func addAfter(entry: DoubleLinkedListEntry) {
        prev = entry
        next = entry.next
        prev?.next = self
        next?.prev = self
    }
    
    func remove() {
        prev?.next = next
        next?.prev = prev
        prev = nil
        next = nil
    }
}
