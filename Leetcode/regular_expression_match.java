public boolean isMatch(String s, String p) {
        if(p == null || s == null)
            return false;
        if (p.length() == 0) {
            return s.length() == 0;
        }
         
        char c = p.charAt(0);
        char next = p.length() > 1 ? p.charAt(1) : '\0';
        if(next == '*')
        {
            return isMatch(s,p.substring(2)) ||
                    s.length() > 0 && (c == '.' || c == s.charAt(0) ) && isMatch(s.substring(1),p) ;
        }
        else
        {
            return s.length() > 0 && (c == '.' || c == s.charAt(0)) && isMatch(s.substring(1),p.substring(1));
        }
    }
