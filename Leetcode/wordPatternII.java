public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        return tryMatch(str, 0, pattern, new ArrayList<String>());
    }

    public boolean tryMatch(String str, int index, String pattern, ArrayList<String> words) {
        if (index == str.length()) {
            return words.size() == pattern.length() && isValid(words, pattern);
        } else if (index < str.length() && words.size() < pattern.length()) {
            if (isValid(words, pattern)) {

                //split the words
                for (int i = index+1; i <= str.length();i++) {
                    String w = str.substring(index, i);
                    words.add(w);
                    if (words.size() <= pattern.length() && isValid(words, pattern)) {
                        if (tryMatch(str, i, pattern, words)) {
                            return true;
                        }
                    }
                    words.remove(words.size() -1);
                }
            }
        }
        return false;
    }

    public boolean isValid(ArrayList<String> words, String pattern) {

        if (words.size() > pattern.length()) {
            return false;
        }
        HashMap<Character, String> mapChar = new HashMap<Character, String>();
        HashMap<String, Character> mapWord = new HashMap<String, Character>();
        for (int i = 0; i < words.size(); i++) {
            char ch = pattern.charAt(i);
            String word = words.get(i);
            if (!mapChar.containsKey(ch)) {
                mapChar.put(ch, word);
            }
            if (!mapWord.containsKey(word)) {
                mapWord.put(word, ch);
            }

            if (ch != mapWord.get(word)) {
                return false;
            }
            if (!word.equals(mapChar.get(ch))) {
                return false;
            }

        }
        return true;
    }
