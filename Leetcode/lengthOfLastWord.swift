func lengthOfLastWord(s: String) -> Int {
    let s1 = s.stringByTrimmingCharactersInSet(NSCharacterSet.whitespaceCharacterSet())
    var words = s1.componentsSeparatedByString(" ")
    return words[words.count - 1].characters.count
}}
