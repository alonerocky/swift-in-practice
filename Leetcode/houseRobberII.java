public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        //rob the first , not the last one
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        dp[n] = dp[n-1]; //because we not rob the last one
        
        //no rob the first one,  
        int[] dp2 = new int[n+1];
        dp2[0] = 0;
        dp2[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i-1]);
        }
        return Math.max(dp[n], dp2[n]);
    }
