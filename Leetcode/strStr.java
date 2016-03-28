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
