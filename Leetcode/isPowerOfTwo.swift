func isPowerOfTwo(n: Int) -> Bool {
        if n <= 0 {
            return false
        }
        var num: Int = n
        var numOfBitOne = 0
        while num != 0 {
            var lastBit = num & 1
            if lastBit == 1 {
                numOfBitOne++
                if numOfBitOne > 1 {
                    return false
                }
            }
            num >>= 1
        }
        return true
    }
