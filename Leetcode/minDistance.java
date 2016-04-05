public int minDistance(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= n; j++) {
                char a = s.charAt(i-1);
                char b = t.charAt(j-1);
                
                dp[i][j] = Math.min(Math.min(dp[i-1][j] , dp[i][j-1] ) + 1, dp[i-1][j-1] + (a == b ? 0 : 1) );
                
            }
        }
        return dp[m][n] ;
    }
