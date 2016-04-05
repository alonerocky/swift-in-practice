public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 10) {
            return result;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int len = s.length();
        for (int i = 0; i + 10 <= len; i++) {
            String one = s.substring(i, i+10);
            if (map.containsKey(one)) {
                map.put(one, map.get(one) + 1);
            } else {
                map.put(one,1);
            }
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (map.get(key) > 1) {
                result.add(key);
            }
        }
        return result;
    }
