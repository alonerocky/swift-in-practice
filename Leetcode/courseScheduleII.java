private enum State {UNVISITED, VISITING, VISITED}
    public int[] findOrder(int n, int[][] edges) {

        if (n <= 0 || edges == null) {
            return new int[0];
        }
        int[] inDegree = new int[n];
        
        HashMap<Integer, ArrayList<Integer>> adjacents = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!adjacents.containsKey(edge[1])) {
                adjacents.put(edge[1], new ArrayList<Integer>());
            }
            inDegree[edge[0]]++;
            adjacents.get(edge[1]).add(edge[0]);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (!bfs(adjacents, inDegree, result)) {
            return new int[0];
        } else {
            int[] order = new int[n];
            for (int i =0;i < n; i++) {
                order[i] = result.get(i);
            }
            return order;
            
        }
    }
    public int[] findOrder_dfs(int n, int[][] edges) {

        if (n <= 0 || edges == null) {
            return new int[0];
        }

        State[] state = new State[n];
        for (int i = 0; i < n; i++) {
            state[i] = State.UNVISITED;
        }

        HashMap<Integer, ArrayList<Integer>> adjacents = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!adjacents.containsKey(edge[1])) {
                adjacents.put(edge[1], new ArrayList<Integer>());
            }
            adjacents.get(edge[1]).add(edge[0]);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (state[i] == State.UNVISITED) {
                if (!dfs(i, adjacents, state, result)) {
                    return new int[0];
                }
            }
        }
        int[] order = new int[n];
        for (int i =0;i < n; i++) {
            order[i] = result.get(i);
        }
        return order;
    }

    public boolean dfs(int vertex, HashMap<Integer, ArrayList<Integer>> adjacents, State[] state, ArrayList<Integer> result) {
        state[vertex] = State.VISITING;
        if (adjacents.containsKey(vertex)) {
            ArrayList<Integer> neighbors = adjacents.get(vertex);
            for (int i = 0; i < neighbors.size(); i++) {
                int v = neighbors.get(i);
                if (state[v] == State.VISITING) {
                    return false;
                } else if (state[v] == State.UNVISITED) {
                    if (!dfs(v, adjacents, state, result)) {
                        return false;
                    }
                }
            }
        }
        state[vertex] = State.VISITED;
        result.add(0, vertex);
        return true;
    }
    
    public boolean bfs(HashMap<Integer, ArrayList<Integer>> adjacents, int[] inDegree, ArrayList<Integer> result) {
        
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i =0;i< inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int u = queue.pollFirst();
            result.add(u);
            if (adjacents.containsKey(u)) {
                ArrayList<Integer> neighbors = adjacents.get(u);
                for (int i = 0; i < neighbors.size(); i++) {
                    int v = neighbors.get(i);
                    if (--inDegree[v] == 0) {
                        queue.addLast(v);
                    }
                }
            }
        }
        return result.size() == inDegree.length;
    }
