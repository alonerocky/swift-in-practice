var cache: [Int: Int] = [:]
    func numTrees(n: Int) -> Int {
        if let num = cache[n] {
            return num
        }
        if n == 0 || n == 1 {
            cache[0] = 1
            cache[1] = 1
            return 1
        } else {
            var total: Int = 0
            for var i in 1 ... n {
                //left 1 ... i -1  i-1
                //right i+1 ... n  n-i 
                total += numTrees(i-1) * numTrees(n-i)
            }
            cache[n] = total
            return total
        }
    }
