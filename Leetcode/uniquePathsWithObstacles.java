public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1] == 1 ? 0: 1;
        
        for (int i = m-2; i >= 0; i--) {
            dp[i][n-1] = grid[i][n-1] == 1 ? 0: dp[i+1][n-1];
        }
        for (int i = n-2; i >=0 ;i--) {
            dp[m-1][i] = grid[m-1][i] == 1 ? 0: dp[m-1][i+1];
        }
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                
                dp[i][j] = grid[i][j] == 1 ? 0 : dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
