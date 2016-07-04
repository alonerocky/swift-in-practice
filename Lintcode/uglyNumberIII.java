public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        if (n <= 0 || primes == null || primes.length == 0) {
            return 0;
        }
        long result = 1l;
        HashSet<Long> set = new HashSet<Long>();
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        minHeap.offer(1l);
        set.add(1l);
        for(int i = 0; i < n; i++) {
            result = minHeap.poll();
            if (i == n-1) {
                break;
            }
            for(int j = 0; j < primes.length; j++) {
                long m = primes[j] * result;
                if (set.add(m)) {
                    minHeap.offer(m);
                }
            }
        }
        return  (int)result;
    }
