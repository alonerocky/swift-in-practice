http://buttercola.blogspot.com/2015/09/leetcode-ugly-number-ii.html
public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        int i = 0;//2
        int j = 0;//3
        int k = 0;//5
        while(nums.size() < n) {
            int m2 = nums.get(i) * 2;
            int m3 = nums.get(j) * 3;
            int m5 = nums.get(k) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            nums.add(min);
            
            if (m2 == min) {
                i++;
            }
            if (m3 == min) {
                j++;
            }
            if (m5 == min) {
                k++;
            }
            
        }
        return nums.get(n-1);
    }

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
