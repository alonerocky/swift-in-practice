//bfs
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        HashMap<Character, ArrayList<Character>> adjacents = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        buildGraph(words, adjacents, indegree);
        StringBuffer result = new StringBuffer();
        if (topological_bfs(adjacents, indegree, result)) {
            return result.toString();
        } else {
            return "";
        }
    }


    private void buildGraph(String[] words, HashMap<Character, ArrayList<Character>> adjacents,
                            HashMap<Character, Integer> indegree) {
        //initialize all the characters to be zero
        for (int i = 0; i < words.length;i++) {
            String word = words[i];
            for (int j = 0; j < word.length();j++) {
                if (!indegree.containsKey(word.charAt(j))) {
                    indegree.put(word.charAt(j), 0);
                }
            }
        }
        for (int i =0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            //compare two words
            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) { //we got the order for c1 and c2 , c1 should befor c2 in dict
                    if (!adjacents.containsKey(c1)) {
                        adjacents.put(c1, new ArrayList<>());
                    }
                    adjacents.get(c1).add(c2);
                    // indegree must increse for c2, because there is one edge from c1 to c2
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;
                }
            }
        }
    }
    private boolean topological_bfs(HashMap<Character, ArrayList<Character>> adjacents, HashMap<Character, Integer> indegree, StringBuffer order) {

        Deque<Character> queue = new ArrayDeque<>();
        //enque all the nodes indegree is 0
        Iterator<Character> iterator = indegree.keySet().iterator();
        while (iterator.hasNext()) {
            char c = iterator.next();
            if (indegree.get(c) == 0) {
                queue.addLast(c);
            }
        }

        while(!queue.isEmpty()) {

            char u = queue.pollFirst();
            order.append(u);

            //get neighbors of u
            if (!adjacents.containsKey(u)) {
                continue;
            }
            ArrayList<Character> neighbors = adjacents.get(u);
            //decrease the indegree for c's neighbor
            for (int i = 0; i < neighbors.size(); i++) {
                char v = neighbors.get(i);
                indegree.put(v, indegree.get(v) - 1);
                if (indegree.get(v) == 0) {
                    queue.addLast(v);
                }
            }

        }
        if (order.length() == indegree.size()) {
            return true;  //exist one topological order
        } else {
            return false;
        }

    }

    
    //dfs
    private enum State {UNVISTED, VISITING, VISITED}
    public String alienOrder_dfs(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        HashMap<Character, ArrayList<Character>> adjacents = new HashMap<Character, ArrayList<Character>>();
        HashMap<Character, State> state = new HashMap<Character, State>();
        //build state and graph
        buildGraphAndState(words, adjacents, state);
        StringBuffer sb = new StringBuffer();
        Iterator<Character> iterator = state.keySet().iterator();
        while (iterator.hasNext()) {
            char c = iterator.next();
            if (state.get(c) == State.UNVISTED) {
                if (!topological_dfs(c, adjacents, state, sb)) {
                    return "";
                }
            }
        }
        return sb.toString();
    }
    private void buildGraphAndState(String[] words, HashMap<Character, ArrayList<Character>> adjacents, HashMap<Character, State> state) {
        //build the state table
        for (int i = 0; i < words.length;i++) {
            String word = words[i];
            for (int j = 0; j < word.length();j++) {
                if (!state.containsKey(word.charAt(j))) {
                    state.put(word.charAt(j), State.UNVISTED);
                }
            }
        }
        //build the graph
        for (int i = 0; i < words.length -1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            //check the order of
            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    // should be one edge from c1 to c2
                    if (!adjacents.containsKey(c1)) {
                        adjacents.put(c1, new ArrayList<>());
                    }
                    adjacents.get(c1).add(c2);
                    break;
                }
            }
        }
    }
    //true means there is one topological order
    //false means there is one cycle
    private boolean topological_dfs(char vertex, HashMap<Character, ArrayList<Character>> adjacents,
                                    HashMap<Character, State> state,
                                    StringBuffer order) {

        state.put(vertex, State.VISITING);
        if (adjacents.containsKey(vertex)) {
            ArrayList<Character> neighbors = adjacents.get(vertex);
            for (int i = 0; i < neighbors.size(); i++) {

                char v = neighbors.get(i);
                if (state.get(v) == State.VISITING) {
                    return false;
                } else if (state.get(v) == State.UNVISTED) {
                    if (!topological_dfs(v, adjacents, state, order)) {
                        return false;
                    }
                }
            }
        }
        //record order
        order.insert(0, vertex);
        state.put(vertex, State.VISITED);
        return true;
    }
