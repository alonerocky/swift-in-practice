public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[len-1] = 0;
        for(int i = len-2; i >= 0; i--) {
            
            int n = A[i];
            int steps = Math.min(n, len-1-i);
            int min = Integer.MAX_VALUE - 1;
            for(int j = 1; j <= steps; j++) {
                min = Math.min(min, dp[i+j]);
            }
            if (min < Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }
