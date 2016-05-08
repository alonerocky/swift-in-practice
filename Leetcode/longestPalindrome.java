public String longestPalindrome(String s) {
        int max = 1;
        int left = 0;
        int right = 0;
        for (int i =0; i < s.length(); i++) {
            int[] oneResult = getLen(i,i, s);
            if (oneResult[1] - oneResult[0] + 1 > max) {
                max = oneResult[1] - oneResult[0] + 1;
                left = oneResult[0];
                right = oneResult[1];
            }
            if (i + 1 < s.length()) {
                oneResult = getLen(i,i+1, s);
                if (oneResult[1] - oneResult[0] + 1 > max) {
                    max = oneResult[1] - oneResult[0] + 1;
                    left = oneResult[0];
                    right = oneResult[1];
                }
            }
        }
        return s.substring(left, right+1);
    }
    
    private int[] getLen(int i, int j, String s) {
        while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j) ) {
            i--;
            j++;
        }
        //[i+1, j-1] are palindrome
        //len = j-1-i
        return new int[] {i+1, j-1};
    }



 public String longestPalindrome(String s) {
        if (s == null ) {
            return null;
        } else if (s.length() == 0) {
            return "";
        }
        
         int len = s.length();
         
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int max = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < len -1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if (dp[i][i+1]) {
                max = 2;
                maxStart = i;
                maxEnd = i+1;
            }
        }
         
        //dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)
        for (int i = len -3; i>=0; i--) {
            
            for (int j = i + 2; j < len; j++) {
                
                if ( dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        maxStart = i;
                        maxEnd = j;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
    
    public boolean[][] getIsPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len -1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }
        
        //dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)
        for (int i = len -3; i>=0; i--) {
            
            for (int j = i + 2; j < len; j++) {
                
                if ( dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
            }
        }
        return dp;
    }
