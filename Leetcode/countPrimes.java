public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        //[0. n-1]
        int count = 0;
        for (int i = 2; i   < n ; i++) {
            if (isPrime[i]) {
                count++;
                //m *i will not be prime
                for (int m =2; m * i < n; m++) {
                    isPrime[m * i] = false;
                }
            }
            
        }
        return count;
    }
