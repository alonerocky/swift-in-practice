public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        int j = 0;
        while (true) {
            if (j >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(j);
            int i = 0;
            for( ;i < strs.length; i++) {
                String str = strs[i];
                if (j >= str.length() || str.charAt(j) != c) {
                    break;
                }
            }
            if (i == strs.length) {
                sb.append(c);
                j++;
            } else {
                break;
            }
        }
        return sb.toString();
    }
