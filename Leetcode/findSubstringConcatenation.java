public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || 
            s.length() == 0 || 
            words == null || 
            words.length == 0) {
            return result;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        int size = words.length;
        int len = words[0].length();
        int total = size * len;
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        for (int i = 0; i + total <= s.length(); i++) {
            int j = 0;
            while (j < size) {
                String str = s.substring(i + j * len , i + j * len + len);
                if (!map.containsKey(str)) { //doesn't contain this word
                    break;
                }
                if (!found.containsKey(str)) {
                    found.put(str, 1);
                } else {
                    int count = found.get(str);
                    if (count == map.get(str)) {
                        break;
                    }
                    found.put(str, count + 1);
                }
                j++;
            }
            found.clear();
            if (j == size) {
                result.add(i);
            }
        }
        return result;
    }
