public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (x == 0.0) {
            return 0.0;
        } else if (n == 1) {
            return x;
        } else if (x == 1.0) {
            return 1.0;
        } else {
            double result = 1.0;
            long m = n;
            boolean isNeg = false;
            if (m < 0) {
                m = -m;
                isNeg = true;
            }
            while (m > 0) {
                if ((m & 1) != 0) {
                    result *= x;
                }
                m = m >> 1;
                x *= x;
            }
            if (isNeg) {
                result = 1.0/result;
            }
            return result;
        }
    }
