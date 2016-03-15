public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length; //len is now >= 2
        if (k % len == 0) {
            return;
        }
        k = k % len;
        //k is [1, ... len -1]
        
        //move n-1-k , to n-1
        //every time, move 1 element
        /*
        for (int i = 0;i < k; i++) {
            int temp = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1 );
            nums[0] = temp;
        }
        */
        // 0 --> k
        // n- 1 - k --> n-1
        
        // 0 .... k ....n-1-k, n-k.... n-1
        //move [n-k, n-1] to [0, k-1]
        //move [0, n-1-k] to [k, n-1]
        //move [0, k] to [0, k]
        int[] temp = new int[k];
        System.arraycopy(nums, len-k, temp,0, k);
        System.arraycopy(nums, 0, nums, k, len - k);
        System.arraycopy(temp, 0, nums, 0, k);
        
    }
