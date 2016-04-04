public String minWindow(String s, String t) {
        if (t == null || s == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        int[] needToFind = new int[256];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needToFind[c]++;
        }
        int[] found = new int[256];
        
        int minLen = Integer.MAX_VALUE;
        boolean exist = false;
        int start = 0;
        int minStart = 0;
        int minEnd = 0;
        int i = 0; 
        int len = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            found[c]++;
            if (found[c] <= needToFind[c]) {
                len++;
            }
            if (len == t.length()) {
                exist = true;
                while ( needToFind[s.charAt(start)] == 0  || 
                        found[s.charAt(start)] > needToFind[s.charAt(start)]) {
                    if (found[s.charAt(start)] > needToFind[s.charAt(start)]) {
                        found[s.charAt(start)]--;
                    }
                    start++;
                }
                //[start , i] 
                if (i - start + 1  < minLen) {
                    minLen = i - start + 1;
                    minStart = start ;
                    minEnd = i;
                }
            }
            i++;
        }
        if (!exist) {
            return "";
        } else {
            return s.substring(minStart, minEnd+1);
        }
    }
