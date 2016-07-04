public int nthUglyNumber(int n) {
        // Write your code here
        HashSet<Long> set = new HashSet<Long>();
        set.add(1l);
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        minHeap.offer(1l);
        long result = 1l;
        for(int i = 0; i < n;i++) {
            result = minHeap.poll();
 	    if (i == n-1) {
                break;
            }	           
            //by 2
            long m = result * 2;
            if (set.add(m)) {
                minHeap.offer(m);
            }
            //by 3
            m = result * 3;
            if (set.add(m)) {
                minHeap.offer(m);
            }
            //by 5
            m = result * 5;
            if (set.add(m)) {
                minHeap.offer(m);
            }
        }
        return (int)result;
    }
