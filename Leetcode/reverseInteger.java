public int reverse(int x) {
        long n = x;
        boolean isNeg = false;
        if (n < 0) {
            n = -n;
            isNeg = true;
        }
        long result = 0;
        while (n > 0) {
            result = result * 10 + n % 10;
            n = n / 10;
        }
        if (isNeg && -result < Integer.MIN_VALUE || !isNeg && result > Integer.MAX_VALUE) {
            return 0;
        }
        if (isNeg) {
            result = -result;
        }
        return (int)result;
    }
