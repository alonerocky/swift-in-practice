public int numSquares(int n) {
        // Write your code here
        if (n == 0) {
            return 0;
        }
         
        int[] dp = new int[n+1];
        Arrays.fill(dp, 4);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            //i = a + j * j;
            for(int j = 1; j *j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
