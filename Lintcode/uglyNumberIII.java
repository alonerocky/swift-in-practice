//http://buttercola.blogspot.com/2016/01/leetcode-super-ugly-number.html
public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || primes == null || primes.length == 0) {
            return -1;
        }
        int k = primes.length;
        int[] indices = new int[k];
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        while(nums.size() < n) {
            int next = Integer.MAX_VALUE;
            for(int i = 0; i < k; i++) {
                next = Math.min(next, nums.get(indices[i]) * primes[i]);
            }
            nums.add(next);
            if (nums.size() == n) {
                break;
            }
            
            //update indices
            for(int i = 0; i < k; i++) {
                if (next == nums.get(indices[i]) * primes[i]) {
                    indices[i]++;
                }
            }
        }
        return nums.get(n-1);
        
    }

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
