func addBinary(a: String, _ b: String) -> String {
    var result: String = ""
    let len1 = a.characters.count
    let len2 = b.characters.count
    var carray: Int = 0
    var i = len1 - 1
    var j = len2 - 1
    while i >= 0 && j >= 0 {
        let va = a[a.startIndex.advancedBy(i)]
        let vb = b[b.startIndex.advancedBy(j)]
        let plus: Int = Int("\(va)")! + Int("\(vb)")! + carray
        result = "\(plus % 2)\(result)"
        carray = plus / 2
        i--
        j--
    }
    
    while i >= 0 {
        let va = a[a.startIndex.advancedBy(i)]
        let plus: Int = Int("\(va)")! + carray
        result = "\(plus % 2)\(result)"
        carray = plus / 2
        i--
    }
    
    while j >= 0 {
        let vb = b[b.startIndex.advancedBy(j)]
        let plus: Int = Int("\(vb)")! + carray
        result = "\(plus % 2)\(result)"
        carray = plus / 2
        j--
    }
    if carray > 0 {
        result = "\(carray)\(result)"
    }
    return result
}
