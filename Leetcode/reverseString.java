public String reverseStringI(String s) {
        if (s == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0;i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length-1;
        while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        return new String(charArray);
    }
