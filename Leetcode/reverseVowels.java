public String reverseVowelsI(String s) {
        if (s == null) {
            return null;
        } else if (s.length() == 0) {
            return s;
        }
        int i = 0;
        int j = s.length() - 1;
        StringBuffer sb = new StringBuffer(s);
        while (i < j) {
             
            if (!isVowel(sb.charAt(i))) {
                i++;
            } else if (!isVowel(sb.charAt(j))) {
                j--;
            } else {
                char c = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, c);
                i++;
                j--;
            }
        }
        return sb.toString();
    }
    
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        } else if (s.length() == 0) {
            return s;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {
             
            if (!isVowel(charArray[i])) {
                i++;
            } else if (!isVowel(charArray[j])) {
                j--;
            } else {
                char c = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = c;
                i++;
                j--;
            }
        }
        return new String(charArray);
    }
    
    public boolean isVowel(char c) {
        char ch = Character.toUpperCase(c);
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
