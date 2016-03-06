public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException();
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long a = dividend;
        long b = divisor;
        boolean isNeg = false;
        if (a < 0) {
            a = -a;
            isNeg = true;
        }
        if (b < 0) {
            b = -b;
            isNeg = !isNeg;
        }
        
        int d =0;
        //find the most significant bit
        while (b<<d <= a) {
            d++;
        }
        long result = 0;
        for (int i = d; i >= 0; i--) {
            if (b<<i <= a) {
                result |= 1 << i;
                a -= b << i;
            }
             
        }
        return (int)(isNeg? -result : result);
    }
