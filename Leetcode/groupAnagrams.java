public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i =0 ;i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                ArrayList<String> words = new ArrayList<String>();
                words.add(str);
                map.put(sorted, words);
            }
        }

        Iterator<ArrayList<String>> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            ArrayList<String> list = iterator.next();
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
