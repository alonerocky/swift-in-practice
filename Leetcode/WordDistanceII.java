public class WordDistance {
    private HashMap<String, ArrayList<Integer>> dict;
    public WordDistance(String[] words) {
        dict = new HashMap<String, ArrayList<Integer>>();
        if (words != null && words.length > 0) {
            for (int i =0;i < words.length; i++) {
                String word = words[i];
                if (dict.containsKey(word)) {
                    dict.get(word).add(i);
                } else {
                    ArrayList<Integer> indices = new ArrayList<Integer>();
                    indices.add(i);
                    dict.put(word, indices);
                }
            }
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> indices1 = dict.get(word1);
        ArrayList<Integer> indices2 = dict.get(word2);
        int i = 0; 
        int j = 0;
        int min = Integer.MAX_VALUE;
        while (i < indices1.size() && j < indices2.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j);
            min = Math.min(min, Math.abs(index1 - index2));
            if (index1 < index2) {
                i++;
            } else if (index1 > index2) {
                j++;
            }
        }
        return min;
    }
}
