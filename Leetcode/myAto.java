public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        String s = str.trim();
        int len = s.length();
        int i = 0;
        long result = 0;
        char c = s.charAt(0);
        boolean isNeg = false;
        if (c == '-') {
            isNeg = true;
            i++;
        } else if (c == '+') {
            i++;
        }
        while (i < len) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                //-result * 10 - digit < Integer.MIN_VALUE
                // result * 10 + digit > Integer.MAX_VALUE
                if (isNeg) {
                    if (-result <  (Integer.MIN_VALUE + digit) / 10) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (result > (Integer.MAX_VALUE - digit ) / 10 ) {
                        return Integer.MAX_VALUE;
                    }
                }
                result = result * 10 + digit;
                
            } else {
                break;
            }
            i++; 
        }
        if (isNeg) {
            result = -result;
        }
        return (int)result;
    }
