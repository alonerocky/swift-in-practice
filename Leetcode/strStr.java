public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0;  i + needle.length() <= haystack.length(); i++) {
            int j = 0;
             while( j < needle.length()) {
                 if (haystack.charAt(i+j) != needle.charAt(j)) {
                     break;
                 }
                 j++;
             }
             if (j == needle.length()) {
                 return i;
             }
        }
        return -1;
    }


//KMP
public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
                return 0;
        }
        int[] next = next(needle);
        
        int i = 0; 
        int j = 0;
        while ( i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - needle.length();
                }
            } else if (j > 0) {
                j = next[j];
            } else {
                i++;
                j = 0;
            }
        }
        return -1;
        
    }
    public int[] next(String p) {
        int[] result = new int[p.length()];
        result[0] = -1;
        //result[0] = -1;
        //result[i-1] = j;
        //calculate result[i]
        int j = -1;
        int i = 1;
        while (i < p.length()) {
            if (j == -1 || p.charAt(i-1) == p.charAt(j)) {
                result[i] = j+1; // = result[i-1] + 1;
                i++;
                j++;
            } else if (j > 0) {
               j = result[j]; 
            } else { //j == 0
                result[i] = 0;
                i++;
            }
        }
        return result;
    }
