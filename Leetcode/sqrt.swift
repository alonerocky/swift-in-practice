   func mySqrtI(x: Int) -> Int {
        if x == 0 || x == 1 {
            return x
        }
        var low: Int = 1
        var high: Int = x
        while low <= high {
            var middle: Int = (low + high) / 2
            var product: Int = middle * middle
            if product == x {
                return middle
            } else if product < x {
                low = middle + 1
            } else {
                high = middle - 1 
            }
        }
        return high
    }
    func mySqrt(x: Int) -> Int {
    if x == 0 || x == 1 {
        return x
    }
    var x0: Double = Double(x)
    var delta: Double = Double(x)
    repeat {
        var x1: Double = (x0 + Double(x) / x0) / 2.0
        delta = abs(x1 - x0)
        x0 = x1
    } while abs(delta) > 1e-6
    return Int(x0)
}
