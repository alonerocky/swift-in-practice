public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> visited = new HashMap<Character, Integer>();
        int curLen = 0;
        int maxLen = 0;
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!visited.containsKey(c)) {
                curLen ++;
            } else if (visited.get(c) < i - curLen) {
                curLen ++;
            } else {
                //[lastIndex + 1 , i]
                //reset curLen, before we reset, we recalculate maxLen
                maxLen = Math.max(curLen, maxLen);
                curLen = i - visited.get(c);
            }
            visited.put(c, i);
        }
        maxLen = Math.max(curLen, maxLen);
        return maxLen;
    }
