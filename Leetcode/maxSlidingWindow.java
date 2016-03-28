public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n-k+1];
        //[0,i-k]
        //]k-1, i-1]
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int index = 0;
        for (int i = 0;i <  n; i++) {
            
            //[i+1-k, i]
            while (!deque.isEmpty() && deque.peekFirst() < i + 1 -k ) {
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k -1) {
                result[index++] = nums[deque.peekFirst()];
            }
            
        }
        return result;
    }
