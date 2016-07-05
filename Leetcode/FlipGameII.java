public boolean canWin(String s) {
        return helper(s.toCharArray());
    }
    
    public boolean helper(char[] str) {
        int len = str.length;
        for(int i = 0; i < len - 1; i++) {
            if (str[i] == '+' && str[i+1] == '+') {
                
                str[i] = '-';
                str[i+1] = '-';
                boolean otherWin = helper(str);
                str[i] = '+';
                str[i+1] = '+';
                if (!otherWin) {
                    return true;
                }
            }
        }
        return false;
    }
