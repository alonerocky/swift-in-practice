func countAndSay(n: Int) -> String {
    if n == 1 {
        return "1"
    } else {
        var result: String = ""
        let n_1: String = countAndSay(n-1)
        var i : Int = 0
        let length: Int = n_1.characters.count
        while i < length {
            let c = n_1[n_1.startIndex.advancedBy(i)]
            var j: Int = i
            var num: Int = 0
            while j < length && n_1[n_1.startIndex.advancedBy(j)] == c {
                num++
                j++
            }
            i = j
            result.appendContentsOf("\(num)")
            result.appendContentsOf("\(c)")
        }
        return result
    }
}

func countAndSayII(n: Int) -> String {
    var current: String = "1"
    for var i = 1; i < n; i++ {
        let previous: String = current
        current = ""
        var counter = 1
        var c: Character = previous[previous.startIndex]
        let length = previous.characters.count
        for var j = 1; j < length; j++ {
            if c == previous[previous.startIndex.advancedBy(j)] {
                counter++
            } else {
                //output
                current = "\(current)\(counter)\(c)"
                c = previous[previous.startIndex.advancedBy(j)]
                counter = 1
            }
        }
        current = "\(current)\(counter)\(c)"
    }
    return current
}
