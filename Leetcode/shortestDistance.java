public int shortestDistance(String[] words, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> dict = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (dict.containsKey(word) ) {
                dict.get(word).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                dict.put(word, indices);
            }
        }
        ArrayList<Integer> indices1 = dict.get(word1);
        ArrayList<Integer> indices2 = dict.get(word2);
        int i =0;
        int j =0;
        int min = Integer.MAX_VALUE;
        while (i < indices1.size() && j < indices2.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j);
            min = Math.min(min, Math.abs(index1 - index2));
            if (index1 < index2) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
