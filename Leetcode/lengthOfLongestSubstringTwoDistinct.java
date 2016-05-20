public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean found = false;
        int i =0;
        int j =0;
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 0;
        int len = s.length();
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(i < len) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
                count++;
                while(j < i && count > 2) {
                    char ch = s.charAt(j);
                    if (map.get(ch) == 1) {
                        map.remove(ch);
                    } else {
                        map.put(ch, map.get(ch) - 1);
                    }
                    if (!map.containsKey(ch)) {
                        count--;
                    }
                    j++;
                }
            } else {
                map.put(c, map.get(c) + 1);
            }
            maxLen = Math.max(maxLen, i-j+1);

            i++;
        }
        return maxLen;
    }
