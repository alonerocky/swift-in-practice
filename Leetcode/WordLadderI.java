public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        long before = System.currentTimeMillis();
        dict.add(start);
        dict.add(end);

        Deque<WordLadder> queue = new ArrayDeque<WordLadder>();
        WordLadder first = new WordLadder(start, 1, null);
        queue.addLast(first);
        int len = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            WordLadder front = queue.pollFirst();
            if (front.len <= len && front.word.equals(end)) {
                len = front.len;
                return len;
            } else if(front.len < len ){
                ArrayList<String> next = getNextWords(front.word, dict);
                for(int i = 0; i < next.size();i++) {
                    String one = next.get(i);
                    boolean used = false;
                    WordLadder p = front;
                    while(p != null) {
                        if (p.word.equals(one)) {
                            used = true;
                            break;
                        }
                        p = p.prev;
                    }
                    if (!used) {
                        if (one.equals(end)) {
                            return front.len + 1;
                        } else {
                            WordLadder nextLadder = new WordLadder(one, front.len + 1, front);
                            queue.add(nextLadder);
                        }
                    }
                }
            }
        }
        return 0;
    }
     public int ladderLengthII(String start, String end, Set<String> dict) {
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
    
    public int ladderLengthIII(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        dict.add(start);
        dict.add(end);
        Deque<String> queue = new ArrayDeque<>();
        queue.add(start);
        int level = 1;
        int currentLevel = 1;
        int nextLevel = 0;
        HashSet<String> used = new HashSet<>();
        used.add(start);
        while(!queue.isEmpty()) {
            String front = queue.pollFirst();

            currentLevel--;

            ArrayList<String> neighbors = getNextWords(front, dict);
            for (int i = 0; i < neighbors.size();i++) {
                String next = neighbors.get(i);
                if (next.equals(end)) {
                    return level + 1;
                }
                if (!used.contains(next)) {
                    used.add(next);
                    queue.add(next);
                    nextLevel++;
                }
            }
            if (currentLevel == 0) {
                level++;
                currentLevel = nextLevel;
                nextLevel = 0;
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
