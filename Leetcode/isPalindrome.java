public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        String str = s.trim().toLowerCase();
        int i =0; 
        int j = str.length() - 1;
        while(i <= j) {
            char c = str.charAt(i);
            char ch = str.charAt(j);
            if (!Character.isLetterOrDigit(c)) {
                i++;
            } else if (!Character.isLetterOrDigit(ch)) {
                j--;
            } else if (ch == c) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
