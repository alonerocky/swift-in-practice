//http://buttercola.blogspot.com/2016/01/leetcode-coin-change.html
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0 ) {
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                //get k coins[i-1]
                for (int k = 0; k * coins[i-1] <= j; k++) {
                    
                    if (dp[i-1][j-k*coins[i-1]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k*coins[i-1]] + k);
                    }
                }
            }
        }
        if ( dp[n][amount] == Integer.MAX_VALUE ) {
            return -1;
        } else {
            return dp[n][amount];
        }
    }
