public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < s.length();  i++) {
            char c = s.charAt(i);
            int digit = c - 'A' + 1;
            result = result * 26 + digit;
        }
        return result;
    }
