func isPalindrome(s: String) -> Bool {
    let lowerStr = s.lowercaseString
    let len = s.characters.count
    var i = 0
    var j = len - 1
    while i < j {
        //omit the non alphanumric character
        var ch = lowerStr[lowerStr.startIndex.advancedBy(i)]
        var c =  lowerStr[lowerStr.startIndex.advancedBy(j)]
        if !(ch >= "a" && ch <= "z" || ch >= "0" && ch <= "9") {
            i++
        } else if !(c >= "a" && c <= "z" || c >= "0" && c <= "9") {
            j--
        } else if ch == c {
            i++
            j--
        } else {
            return false
        }
    }
    return true
}
