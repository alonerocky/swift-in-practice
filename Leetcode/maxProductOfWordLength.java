public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int len = words.length;
        int[] bitmap = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                bitmap[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++)  {
                if ( !hasCommonCharacter(words[i], words[j]) ) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
    
    public boolean hasCommonCharacter(String word1, String word2) {
        int bit1 = 0;
        int bit2 = 0; 
        for (int i = 0; i < word1.length(); i++) {
            bit1 |= 1 << (word1.charAt(i) - 'a');
        }
        for (int i = 0; i < word2.length(); i++) {
            bit2 |= 1 << (word2.charAt(i) - 'a');
        }
        return (bit1 & bit2) != 0;
    }
    
    public boolean hasCommonCharacterI(String word1, String word2) {
        if (word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0) {
            return true;
        }
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        for (int i =0; i < c1.length; i++) {
            set.add(c1[i]);
        }
        for (int i = 0; i < c2.length; i++) {
            set.add(c2[i]);
        }
        return set.size() < word1.length() + word2.length();
    }
