public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        if (s == null || dict == null ) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        int maxLength = getMaxWordLength(dict);
        for(int i = 1; i <= len; i++) {
            
            boolean canBreak = false;
            int j = Math.max(i - maxLength, 0);
            for(; j < i; j++) {
                if (dp[j]) {
                    String str = s.substring(j, i);
                    if (dict.contains(str)) {
                        canBreak = true;
                        break;
                    }
                }
                 
                 
            }
            dp[i] = canBreak;
            
        }
        return dp[len];
        
    }
    
    public int getMaxWordLength(Set<String> dict) {
        int max = 0;
        Iterator<String> iterator = dict.iterator();
        while(iterator.hasNext()) {
            String one = iterator.next();
            max = Math.max(max, one.length());
        }
        return max;
    }
