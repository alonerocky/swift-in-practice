public int shortestWordDistance(String[] words, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> dict = new HashMap<String, ArrayList<Integer>>();
        int min = Integer.MAX_VALUE;
        if (words != null && words.length > 0) {
            for (int i =0;i < words.length; i++) {
                String word = words[i];
                if (dict.containsKey(word)) {
                    dict.get(word).add(i);
                } else {
                    ArrayList<Integer> indicies = new ArrayList<Integer>();
                    indicies.add(i);
                    dict.put(word, indicies);
                }
            }
             
            if (word1.equals(word2)) {
                ArrayList<Integer> indicies = dict.get(word1);
                for (int i = 1; i < indicies.size(); i++)
                {
                    int distance = indicies.get(i) - indicies.get(i-1);
                    min = Math.min(min, distance);
                }
            } else {
                 
                ArrayList<Integer> indicies1 = dict.get(word1);
                ArrayList<Integer> indicies2 = dict.get(word2);
                int i = 0;
                int j = 0;
                while (i < indicies1.size() && j < indicies2.size()) {
                    int index1 = indicies1.get(i);
                    int index2 = indicies2.get(j);
                    min = Math.min(min, Math.abs(index1 - index2));
                    if (index1 < index2) {
                        i++;
                    } else if (index1 > index2) {
                        j++;
                    }
                }
            }
        }
        return min;
    }
