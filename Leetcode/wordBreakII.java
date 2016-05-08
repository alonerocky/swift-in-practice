 public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        tryBreak(s, 0, wordDict, result, new ArrayList<String>());
        return result;
    }
    
    public void tryBreak(String s, int index, Set<String> dict, List<String> result, ArrayList<String> current) {
        if (index == s.length()) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < current.size();i++) {
                sb.append(current.get(i));
                if (i < current.size() - 1) {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
            return;
        } else if (index < s.length()) {
            for (int i = s.length() - index; i >= 1; i--) {
                String str = s.substring(index, index+i);
                if (dict.contains(str)) {
                    current.add(str);
                    tryBreak(s, index+i, dict, result, current);
                    current.remove(current.size()-1);
                }
            }
        }
    }



//dp
public List<String> wordBreakII(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        int len = s.length();
        Result[] dp = new Result[len+1];
        ArrayList<String> empty = new ArrayList<String>();
        empty.add("");
        dp[0] = new Result(true, empty);
        for (int i = 1; i <= len; i++) {

            dp[i] = new Result(false, new ArrayList<String>());
            for (int j = i-1; j >= 0; j--) {
                String str = s.substring(j, i);
                if (dp[j].canBreak && wordDict.contains(str) ) {
                    dp[i].canBreak = true;
                    for(int k = 0; k < dp[j].result.size(); k++) {
                        String oneResult = dp[j].result.get(k);
                        StringBuffer sb = new StringBuffer(oneResult);
                        if (sb.length() > 0) {
                            sb.append(" ");
                        }
                        sb.append(str);
                        dp[i].result.add(sb.toString());

                    }
                }
            }
        }
        return dp[len].result;
    }
    
    class Result {
        boolean canBreak;
        ArrayList<String> result ;
        public Result() {
            canBreak = false;
            
        }
        public Result(boolean canBreak, ArrayList<String> result) {
            this.canBreak = canBreak;
            this.result = result;
        }
    }


//dfs
public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return dfs(s, wordDict, map);
         
    }
    public ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int len = s.length();
        ArrayList<String> result = new ArrayList<String>();
        if (len <= 0) {
            return result;
        }
        for (int i = 1; i <= len; i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                if (i == len) {
                    result.add(prefix);
                } else {
                    String postfix = s.substring(i);
                    ArrayList<String> n_1 = dfs(postfix, dict, map);
                    for (int j = 0; j < n_1.size(); j++) {
                        result.add(prefix + " " + n_1.get(j));
                    }
                }
            }
             
        }
        map.put(s, result);
        return result;
    }
