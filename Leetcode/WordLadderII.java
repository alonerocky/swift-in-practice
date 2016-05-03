public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        long before = System.currentTimeMillis();
        List<List<String>> result = new ArrayList<List<String>>();
        wordList.add(beginWord);
        wordList.add(endWord);
        Deque<ArrayList<String>> queue = new ArrayDeque<ArrayList<String>>();
        ArrayList<String> one = new ArrayList<String>();
        one.add(beginWord);
        queue.addLast(one);
        int len = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            ArrayList<String> front = queue.pollFirst();
            String top = front.get(front.size()-1);
            HashSet<String> used = new HashSet<String>(front);
            if (front.size() <= len && top.equals(endWord)) {
                len = front.size();
                result.add(front);
            } else {
                ArrayList<String> next = getNextWords(top, wordList);
                for (int i = 0; i < next.size(); i++) {
                    String word = next.get(i);
                    if (!used.contains(word)) {

                        if (front.size() + 1 <= len && word.equals(endWord)) {
                            len = front.size() + 1;
                            front.add(word);
                            result.add(front);
                        } else if (front.size() + 1 <= len) {
                            ArrayList<String> cloned = (ArrayList<String>)front.clone();
                            cloned.add(word);
                            queue.addLast(cloned);
                        }
                    }
                }
            }

        }
        System.out.println("time: "+ (System.currentTimeMillis() - before));
        return result;
    }

    public ArrayList<String> convertWordLadder(WordLadder ladder) {
        WordLadder p = ladder;
        ArrayList<String> result = new ArrayList<>();
        while( p != null) {
            result.add(0, p.word);
            p = p.prev;
        }
        return result;
    }
    public List<List<String>> findLaddersII(String beginWord, String endWord, Set<String> wordList) {
        long before = System.currentTimeMillis();
        List<List<String>> result = new ArrayList<List<String>>();
        wordList.add(beginWord);
        wordList.add(endWord);

        WordLadder first = new WordLadder(beginWord,1, null);
        Deque<WordLadder> queue = new ArrayDeque<>();
        queue.addLast(first);
        int len = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            WordLadder front = queue.pollFirst();
            if (front.len <= len && front.word.equals(endWord)) {
                len = front.len;
                result.add(convertWordLadder(front));
            } else {
                ArrayList<String> next = getNextWords(front.word, wordList);
                for (int i = 0; i < next.size();i++) {
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
                    if (!used && front.len +1 <= len) {
                        WordLadder nextLadder = new WordLadder(one, front.len + 1, front);
                        queue.addLast(nextLadder);
                    }
                }
            }
        }
        System.out.println("time: "+ (System.currentTimeMillis() - before));
        return result;
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
