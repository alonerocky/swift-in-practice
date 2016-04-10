public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        HashSet<Character> visited = new HashSet<Character>();
        StringBuffer sb = new StringBuffer();
        for (int i =0; i < s.length();i++) {
            char c = s.charAt(i);
            count[c-'a']--;
            if (visited.contains(c)) { //c is already in the stringbuffer
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c &&
                   count[sb.charAt(sb.length()-1) - 'a'] > 0) { //last char in sb is bigger than c and we will see it later
                       char lastChar = sb.charAt(sb.length()-1);
                       sb.deleteCharAt(sb.length()-1);
                       visited.remove(lastChar);
                   }
            sb.append(c);
            visited.add(c);
        }
        return sb.toString();
    }
