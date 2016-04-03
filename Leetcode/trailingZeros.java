//http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
    /*
    Trailing 0s in n! = Count of 5s in prime factors of n!
                  = floor(n/5) + floor(n/25) + floor(n/125) + ....
    */
    public int trailingZeroes(int n) {
        int count = 0;
        for (long i = 5; i <= n; i *= 5) {
            count += n/i
        }
        return count;
    }
