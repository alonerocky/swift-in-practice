public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() == 0) {
            return s2.length() == 0;
        } else if (s1.length() == 1) {
            return s2.length() == 1 && s1.charAt(0) == s2.charAt(0);
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        for(int i = 1; i < len; i++) {
            
            String a = s1.substring(0,i);
            String b = s1.substring(i);
            
            
            String e = s2.substring(0,i);
            String f = s2.substring(i);
            String g = s2.substring(0,len-i);
            String h = s2.substring(len-i);
            
            if ( isScramble(a,e) && isScramble(b,f) ||
                   isScramble(a,h) && isScramble(b,g) ){
                       return true;
                   }
            
        }
        return false;
    }
