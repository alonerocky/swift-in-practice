public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
        if (strings == null || strings.length == 0) {
            return result;
        }
        
        for (int i =0; i < strings.length; i++) {
            String str = strings[i];
            if (str == null) {
                continue;
            }
            String key = formulateKey(str);
            if (dict.containsKey(key)) {
                dict.get(key).add(str);
            } else {
                ArrayList<String> l = new ArrayList<String>();
                l.add(str);
                dict.put(key, l);
            }
        }
        Iterator<ArrayList<String>> iterator = dict.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<String> one = iterator.next();
            Collections.sort(one);
            result.add(one);
        }
        return result;
    }
    
    private String formulateKey(String str) {
        if (str.length() == 0) {
            return "";
        }
        char first = str.charAt(0);
        StringBuffer sb = new StringBuffer();
        int delta = first - 'a';
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = (char)(chars[i] - 'a' < delta ? chars[i] + 26 - delta : chars[i] - delta);
            sb.append(c);
        }
        return sb.toString();
    }
