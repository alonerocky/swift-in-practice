private HashMap<String, HashSet<String>> dict = new HashMap<String, HashSet<String>>();
    public ValidWordAbbr(String[] dictionary) {
        if (dictionary != null && dictionary.length > 0) {
            for (int i = 0; i < dictionary.length; i++) {
            String word = dictionary[i];
            int len = word.length();
            if (len > 1) {
                String key = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(len-1);
                if (dict.containsKey(key)) {
                    dict.get(key).add(word);
                } else {
                    HashSet<String> words = new HashSet<String>();
                    words.add(word);
                    dict.put(key, words);
                }
            } else {
                HashSet<String> words = new HashSet<String>();
                words.add(word);
                dict.put(word, words);
            }
            }
        }
    }

    public boolean isUnique(String word) {
        String key = word;
        int len = word.length();
        if (len > 1) {
            key = word.charAt(0) + Integer.toString(len - 2) + word.charAt(len-1);
        }
        if( !dict.containsKey(key)) {
            return true;
        } else {
            HashSet<String> set = dict.get(key);
            if (set.size() == 1 && set.contains(word)) {
                return true;
            } else {
                return false;
            }
        }
    }
