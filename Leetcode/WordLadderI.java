public int ladderLength(String start, String end, Set<String> dict) {
       if (dict == null) {
            return 0;
        }
        long before = System.currentTimeMillis();
        dict.add(start);
        dict.add(end);
        HashSet<String> used = new HashSet<String>();
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(start);
        used.add(start);
        int level = 1;
        while(!queue.isEmpty()) {
            level++;
            //handle this level
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize;i++) {
                String one = queue.pollFirst();
                ArrayList<String> neighbors = getNextWords(one, dict);
                for (int j = 0; j < neighbors.size();j++) {
                    String next = neighbors.get(j);
                    if (next.equals(end)) {
                        System.out.println("time: " + (System.currentTimeMillis() - before));
                        return level;
                    }
                    if (!used.contains(next)) {
                        queue.addLast(next);
                        used.add(next);
                    }
                }
            }
        }
        return 0;
    }
    
    class WordLadder {
        String word;
        int len ;
        WordLadder prev;
        public WordLadder(String word, int len, WordLadder prev) {
            this.word = word;
            this.prev = prev;
            this.len = len;
        }
    } 

    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        char[] chars = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                //String nextWord = replace(word, i, c);

                char temp = chars[i];
                chars[i] = c;
                String nextWord = new String(chars);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
                chars[i] = temp;
            }
        }
        return nextWords;
    }
