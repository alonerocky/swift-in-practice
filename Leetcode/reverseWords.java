public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String str = s.trim();
        String[] words = str.split(" ");
        StringBuffer sb = new StringBuffer();
        
        for (int i = words.length - 1; i>= 0; i--) {
            if (words[i].length() > 0) {
                sb.append(words[i]);
                if (i > 0) {
                    sb.append(" ");
                }
            }
            
        }
        return sb.toString();
    }
