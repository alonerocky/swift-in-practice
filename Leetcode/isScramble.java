public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (!Arrays.toString(array1).equals(Arrays.toString(array2))) {
            return false;
        }
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            
            int j = len - i;
            
            String a = s1.substring(0,i);
            String b = s1.substring(i);
            
            String e = s2.substring(0,i);
            String f = s2.substring(i);
            String g = s2.substring(0, len - i);
            String h = s2.substring(len -i); 
            
            if( isScramble(a,e) && isScramble(b,f) || 
                isScramble(a,h) && isScramble(b,g)) {
                return true;
            }
        }
        return false;
    }
