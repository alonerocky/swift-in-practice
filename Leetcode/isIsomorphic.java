public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        int len = s.length();
        int i =0; 
        while (i < len) {
            char left = s.charAt(i);
            char right = t.charAt(i);
            if (!map1.containsKey(left) && !map2.containsKey(right)) {
                map1.put(left, right);
                map2.put(right, left);
                i++;
            } else if (map1.containsKey(left) && map2.containsKey(right)) {
                if(map1.get(left) != right || map2.get(right) != left) {
                    return false;
                }
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
