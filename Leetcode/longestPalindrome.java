public String longestPalindrome(String s) {
        int max = 1;
        int left = 0;
        int right = 0;
        for (int i =0; i < s.length(); i++) {
            int[] oneResult = getLen(i,i, s);
            if (oneResult[1] - oneResult[0] + 1 > max) {
                max = oneResult[1] - oneResult[0] + 1;
                left = oneResult[0];
                right = oneResult[1];
            }
            if (i + 1 < s.length()) {
                oneResult = getLen(i,i+1, s);
                if (oneResult[1] - oneResult[0] + 1 > max) {
                    max = oneResult[1] - oneResult[0] + 1;
                    left = oneResult[0];
                    right = oneResult[1];
                }
            }
        }
        return s.substring(left, right+1);
    }
    
    private int[] getLen(int i, int j, String s) {
        while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j) ) {
            i--;
            j++;
        }
        //[i+1, j-1] are palindrome
        //len = j-1-i
        return new int[] {i+1, j-1};
    }
