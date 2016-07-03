public String reverseWords(String s) {
        // write your code
        if (s == null) {
            return s;
        }
        s = s.trim();
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                sb.append(words[i]);
            }
            if(i != 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
