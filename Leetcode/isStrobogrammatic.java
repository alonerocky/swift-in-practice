 public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        int i =0;
        int j = num.length() -1;
        while (i <= j) {
            char c = num.charAt(i);
            char ch = num.charAt(j);
            if (i == j) {
                return c == '0'|| c == '1' || c == '8';
            }
            if (  c == '0' && ch == '0' 
               || c == '1' && ch == '1' 
               || c == '6' && ch == '9'
               || c == '9' && ch == '6'
               || c == '8' && ch == '8') {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
