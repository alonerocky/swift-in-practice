func compareVersion(version1: String, _ version2: String) -> Int {
    var v1 = version1.componentsSeparatedByString(".")
    var v2 = version2.componentsSeparatedByString(".")
    
    let len1 = v1.count
    let len2 = v2.count
    var i = 0
    while i < len1 && i < len2 {
        let v1Num = Int(v1[i])
        let v2Num = Int(v2[i])
        if v1Num < v2Num {
            return -1
        } else if v1Num > v2Num {
            return 1
        } else {
            i++
        }
    }
    
    while i < len1 {
        let v1Num = Int(v1[i])
        if v1Num == 0 {
            i++
        } else {
            return 1
        }
    }
    
    while i < len2 {
        let v2Num = Int(v2[i])
        if v2Num == 0 {
            i++
        } else {
            return -1
        }
    }
    return 0
}
