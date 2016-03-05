func plusOne(digits: [Int]) -> [Int] {
        if digits.count == 0 {
            return []
        }
        var result: [Int] = [Int](count: digits.count, repeatedValue: 0)
        var carray: Int = 0
        for var i = digits.count - 1 ; i >= 0; i-- {
            let temp = digits[i] + (i == 0 ? 1 : 0) + carray
            result[i] = temp % 10
            carray = temp / 10
        }
        if carray > 0 {
            result.insert(carray, atIndex: 0)
        }
        return result
    }
