public String countAndSay(int n) {
        String current = "1";
        //from current ,calculate next one
        for (int i = 1; i < n; i++) {
            current = count(current);
        }
        return current;
    }
    
    public String count(String s) {
        int i = 0; 
        StringBuffer sb = new StringBuffer();
        while (i < s.length()) {
            int start = i;
            while (start < s.length() && s.charAt(start) == s.charAt(i)) {
                start++;
            }
            sb.append(start-i); //number of s[i]
            sb.append(s.charAt(i));
            i = start;
            
        }
        return sb.toString();
    }
