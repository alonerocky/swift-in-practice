var cache: [Int : Int] = [:]
    func climbStairs(n: Int) -> Int {
        if let value = cache[n] {
            return value
        }
        if (n == 0 ) {
            cache[0] = 1
            return 1
        }
        if n == 1 {
            cache[1] = 1
            return 1
        }
        var oneStep = climbStairs(n-1)
        cache[n-1] = oneStep
        var twoSteps = climbStairs(n-2)
        cache[n-2] = twoSteps
        return oneStep + twoSteps
    }
