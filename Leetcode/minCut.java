//http://www.jiuzhang.com/solutions/palindrome-partitioning-ii/
    public int minCut(String s) {
       if (s == null || s.length() == 0) {
           return 0;
       }
       int len = s.length();
       int[] dp = new int[len+1];
       for (int i = 0; i <= len; i++) {
           dp[i] = i;
       }
       boolean[][] isPalindrome = getIsPalindrome(s);
       
       for (int i = 2; i <= len; i++) {
           
           for (int j = 0; j < i; j++) {
              if (isPalindrome[j][i-1]) {
                  dp[i] = Math.min(dp[i], dp[j] + 1);
              }
           }
       }
       
       return dp[len] - 1;
    } 
    public boolean[][] getIsPalindrome(String s) {
        //indicate [i,j] is valid
        int len = s.length();
        boolean[][] isValidPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isValidPalindrome[i][i] = true;
            if (i < len -1) {
                isValidPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
            }
        }
        //isValidPalindrome[i][j] = isValidPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j)
        for (int i = len -3; i >= 0; i--) {
            for (int j = i+2; j < len; j++) {
                isValidPalindrome[i][j] = isValidPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
        return isValidPalindrome;
    }
