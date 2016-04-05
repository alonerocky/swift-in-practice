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
