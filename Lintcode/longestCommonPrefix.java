public String longestCommonPrefix(String[] strs) {
        // write your code here
        StringBuffer sb = new StringBuffer();
        if (strs == null || strs.length == 0) {
            return "";
        }
        int index = 0;
        int size = strs.length;
        boolean canContinue = true;
        while(canContinue) {
            if (strs[0] == null || index >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(index);
            for(int i = 0; i < size; i++) {
                if (strs[i] == null || index >= strs[i].length() || strs[i].charAt(index) != c) {
                    canContinue = false;
                    break;
                }
            }
            if (canContinue) {
                sb.append(c);
                index++;
            }
        }
        return sb.toString();
         
    }
