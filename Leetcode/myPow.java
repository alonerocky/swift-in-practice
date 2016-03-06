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
            long m = n;
            boolean isNeg = m < 0;
            if (m < 0) {
                m = -m;
            }
            double half = myPow(x, (int)(m/2));
            double result = 0.0;
            if (m % 2 == 0) {
                result = half * half;
            } else {
                result = half * half * x;
            }
            if (isNeg) {
                result = 1.0/result;
            }
            return result;
        }
    }
