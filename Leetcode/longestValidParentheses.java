public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i =0;i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left ++;
            } else if (c == ')') {
                right ++;
            }
            if (right == left) {
                max = Math.max(max, left + right);
            } else if (right > left) {
                left = 0; 
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int j = s.length() -1 ; j >= 0; j--) {
            char c = s.charAt(j);
            if (c == ')') {
                right ++;
            } else if (c == '(') {
                left ++;
            }
            if (left == right) {
                max = Math.max(max, left + right);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
        
    }
