public boolean wordBreak(String s, Set<String> dict) {
        if (s == null ) {
            return false;
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            Iterator<String> iterator = dict.iterator();
            while (iterator.hasNext()) {
                String word = iterator.next();
                int len = word.length();
                if (i + len > s.length()) {
                    continue;
                }
                if (dp[i+len]) {
                    continue;
                }
                if (s.substring(i, i+len).equals(word) ) {
                    dp[i+len] = true;
                }
            }
        }
        return dp[s.length()];
    }


public boolean wordBreak(String s, Set<String> dict) {
         if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
             return false;
         }
         int len = s.length();
         boolean[] dp = new boolean[len+1];
         dp[0] = true;
         for(int i = 1; i <= len; i++) {
             
             for (int j = 0; j < i; j++) {
                 String str = s.substring(j, i);
                 if (dict.contains(str) && dp[j]) {
                     dp[i] = true;
                     break;
                 }
             }
         }
         return dp[len];
    }
