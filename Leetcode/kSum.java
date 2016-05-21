 //http://buttercola.blogspot.com/2014/11/lintcode-k-sum.html
    public int kSum(int A[], int k, int target) {
        // write your code here
        if (A == null || target < 0) {
            return 0;
        }
        if (target == 0) {
            if (k == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int m = A.length;
        int[][][] dp = new int[m+1][k+1][target+1];
        for (int i = 0; i < m; i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    
                    dp[i][j][t] = dp[i-1][j][t] ;
                    if (A[i-1] <= t) {
                        dp[i][j][t] += dp[i-1][j-1][t - A[i-1]];
                    }
                    
                }
            }
        }
        return dp[m][k][target];
        
    }
