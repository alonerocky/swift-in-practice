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


//method II
public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n-k+1]; // the last window [n-k, n-1],  i is in [0, n-k]
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int i = 0;
        while (i < n) {
            int num = nums[i];
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) { //the window is [i-k+1, i] 
                deque.pollFirst();
            } else if (!deque.isEmpty() && nums[deque.peekLast()] < num) {
                deque.pollLast();
            } else { //empty or we need add nums[i]
                deque.offer(i);
                if (i >= k-1) {
                    result[index++] = nums[deque.peekFirst()];
                }
                i++;
            }
        }
        return result;
    }
