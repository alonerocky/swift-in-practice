func romanToInt(s: String) -> Int {
    let table: [Character: Int] = ["I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000]
    var result: Int = 0
    for var i = 0 ; i < s.characters.count; i++ {
        let index = s.startIndex.advancedBy(i)
        let ch: Character = toUpper(s[index])
        let value: Int = table[ch]!
        let nextValue = index < s.endIndex.advancedBy(-1) ? table[toUpper(s[index.successor()])] : 0
        if value < nextValue {
            result -= value
        } else {
            result += value
        }
    }
    return result
}

func toUpper(c: Character) -> Character {
    let str =  String(c).uppercaseString
    return str[str.startIndex]
}

