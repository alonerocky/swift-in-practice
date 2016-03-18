public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n >1) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }
        return n == 1;
    }
    public boolean isPowerOfThreeII(int n) {
       if (n <= 0) {
           return false;
       }
       if (n == 1) {
           return true;
       }
       return n % 3 == 0 && isPowerOfThree(n/3);
    }
    
    public boolean isPowerOfThreeIII(int n) {
        //pow(3, x) = n
        //x * log3 = log n
        //x = logn / log3
        //check if pow(3, logn / log 3) == n
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
