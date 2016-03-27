public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if (num1.length() == 1) {
            return multiplyOneChar(num2, num1.charAt(0));
        } else if( num2.length() == 1) {
            return multiplyOneChar(num1, num2.charAt(0));
        }
        String result = "";
        for (int i = num1.length() -1 ; i >= 0; i--){
            char c = num1.charAt(i);
            String oneResult = multiplyOneChar(num2, c);
            if (oneResult.length() == 1 && oneResult.charAt(0) == '0') {
                continue;
            }
            int rightZeros = num1.length() - 1 - i;
            char[] zeros = new char[rightZeros];
            Arrays.fill(zeros, '0');
            StringBuffer sb = new StringBuffer();
            sb.append(oneResult);
            sb.append(zeros);
            result = addTwoString(result, sb.toString());
        }
        return result;
        
    }
    
    private String multiplyOneChar(String num, char c) {
        if (c == '0') {
            return "0";
        } else if (c == '1') {
            return num;
        } else {
            StringBuffer sb = new StringBuffer();
            int carray = 0;
            int d = c - '0';
            for (int i = num.length() - 1; i >= 0; i--) {
                int digit = num.charAt(i) - '0';
                int result = digit * d + carray;
                sb.insert(0, result % 10);
                carray = result / 10;
            }
            if (carray > 0) {
                sb.insert(0, carray);
            }
            return sb.toString();
        }
    }
    
    private String addTwoString(String num1, String num2) {
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1 - 1;
        int j = len2 - 1;
        int carray = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 && j >= 0) {
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(j) - '0';
            int result = c1 + c2 + carray;
            sb.insert(0, result % 10);
            carray = result / 10;
            i--;
            j--;
        }
        
        while (i >= 0) {
            int c = num1.charAt(i) - '0';
            int result = c + carray;
            sb.insert(0, result % 10);
            carray = result / 10;
            i--;
        }
        
        while (j >= 0) {
            int c = num2.charAt(j) - '0';
            int result = c + carray;
            sb.insert(0, result % 10 );
            carray = result / 10;
            j--;
        }
        
        if (carray > 0) {
            sb.insert(0, carray);
        }
        return sb.toString();
    }
