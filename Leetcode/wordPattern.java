public static boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map1 = new HashMap<Character, String>();
        HashMap<String, Character> map2 = new HashMap<String, Character>();

        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        int len = pattern.length();
        for (int i =0 ;i < len; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (!map1.containsKey(ch)) {
                map1.put(ch, word);
            }
            if (!map2.containsKey(word)) {
                map2.put(word, ch);
            }
            if (!map1.get(ch).equals(word) || map2.get(word) != ch) {
                return false;
            }
        }
        return true;
    }
