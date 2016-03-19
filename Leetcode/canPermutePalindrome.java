public boolean canPermutePalindrome(String s) {
        //each character appear twice . or one character appear only once, all others appear twice
        if (s == null || s.length() == 0) {
            return false;
        }
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.put(c, 1);
            }
        }
        int odd = 0;
        Iterator<Character> iterator = dict.keySet().iterator();
        while (iterator.hasNext()) {
            char c = iterator.next();
            if (dict.get(c) % 2 == 0) {
                continue;
            }
            else if (odd == 0) {
                odd++;
            } else {
                return false;
            }
        }
        return true;
    }
