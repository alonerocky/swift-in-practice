func isAnagram(s: String, _ t: String) -> Bool {
        if s.characters.count != t.characters.count {
            return false
        }
        var dict: [Character : Int] = [:]
        for var ch in s.characters {
            if let value = dict[ch] {
                dict[ch] = value + 1
            } else {
                dict[ch] = 1
            }
        }
        for var ch in t.characters {
            if let value = dict[ch] {
                if value == 0 {
                    return false
                }
                dict[ch] = value - 1
            } else {
                return false
            }
        }
        return true
    }
