private int total;
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = s.length();   
        int[] dp = new int[len+1];
        dp[len] = 1;
        dp[len-1] = isValid(s.substring(len-1)) ? 1: 0;
        for(int i = len-2; i >= 0; i--)
        {
            if(isValid(s.substring(i,i+2)))
                    dp[i] += dp[i+2];
 
            if(isValid(s.substring(i,i+1)))
                    dp[i] += dp[i+1];
 
        }
        return dp[0];
    }
    public int numDecodingsI(String s) {
         if (s == null || s.length() == 0) {
             return 0;
         }
         total = 0;
          tryDecode(s, 0);
          return total;
         
    }
    public void tryDecode(String s, int index) {
        if (index == s.length()) {
            total ++;
        } else if (index < s.length()){
            String s1 = s.substring(index, index + 1);
            if (isValid(s1)) {
                tryDecode(s, index+1);
            }
            if (index + 2 <= s.length()) {
                String s2 = s.substring(index, index + 2);
                if (isValid(s2)) {
                    tryDecode(s, index + 2);
                }
            }
        }
    }
    
    public boolean isValid(String s) {
        if (s.length() == 1) {
            char c = s.charAt(0);
            return c >= '1' && c <= '9';
        } else if (s.length() == 2) {
            char c = s.charAt(0);
            char c2 = s.charAt(1);
            return (c == '1' && c2 >= '0' && c2 <= '9' ||
                   c == '2' && c2 >= '0' && c2 <= '6');
        } else {
            return false;
        }
    }
