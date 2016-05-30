public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        int lens  = s.length();
        int lent = t.length();
        int[][] dp = new int[lens+1][lent+1];
        for (int i = 0; i <= lens; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= lens;i++) {
            char ch = s.charAt(i-1);
            for (int j = 1; j <= lent; j++) {
                char c = t.charAt(j-1);
                if (ch == c) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[lens][lent];
    }
