public static boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map1 = new HashMap<Character, String>();
        HashMap<String, Character> map2 = new HashMap<String, Character>();
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        
        for (int i =0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (!map1.containsKey(ch) && !map2.containsKey(word)) {
                map1.put(ch, word);
                map2.put(word, ch);
            } else if (map1.containsKey(ch) && 
                    map2.containsKey(word) && 
                    map1.get(ch).equals(word) &&
                    map2.get(word) == ch){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
