func myPowI(x: Double, _ n: Int) -> Double {
    
    if n == 0 {
        return 1.0
    } else if x == 0.0 {
        return 0.0
    } else if x == 1.0 {
        return 1.0
    } else if n == 1 {
        return x
    } else {
        if n < 0 {
            return 1.0 / myPowI(x, -n)
        }
        var half: Double = myPowI(x, n / 2)
        if n % 2 == 0 {
            return half * half
        } else {
            return half * half * x
        }
    }

}

func myPowII(x: Double, _ n: Int) -> Double {
    if n == 0 {
        return 1.0
    } else if x == 0.0 {
        return 0.0
    } else if x == 1.0 {
        return 1.0
    } else if n == 1 {
        return x
    } else {
        var isNeg: Bool = n < 0
        var m: Int = n
        if n < 0 {
            m = -m
        }
        var p: Double = x
        var result: Double = 1.0
        while m > 0 {
            if (m & 1) != 0 {
                result *= p
            }
            p *= p
            m = m >> 1
        }
        return isNeg ? 1.0 / result : result
        
    }
}
