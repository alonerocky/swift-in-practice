public boolean isPerfectSquare(int n) {
        if (n <=  4) {
            return n == 1 || n == 4;
        } else {
            // n/4 > 1   n*n/4 > n  --> n/2 > sqrt(n)
            long i = 2;
            long j = n/2;
            while(i <= j) {
                long middle = (i+j)/2;
                if (middle * middle == (long)n ) {
                    return true;
                } else if (middle * middle < (long)n ) {
                    i = middle + 1;
                } else {
                    j = middle - 1;
                }
            }
            return false;
        }
    }
