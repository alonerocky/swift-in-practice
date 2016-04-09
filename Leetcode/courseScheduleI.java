private enum State {UNVISITED, VISITING, VISITED}
    public boolean canFinish(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return true;
        }
        int[] indegrees = new int[n];
        HashMap<Integer, ArrayList<Integer>> adjacents = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            //edge[1] is start (prereq) edge[0] is end
            indegrees[edge[0]]++;
            if (!adjacents.containsKey(edge[1])) {
                adjacents.put(edge[1], new ArrayList<Integer>());
            }
            adjacents.get(edge[1]).add(edge[0]);
        }
        //equeue those nodes indgree is zero
        
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.addLast(i);
            }
        }
        ArrayList<Integer> topologicalOrder = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int u = queue.pollLast();
            topologicalOrder.add(0, u);
            if (adjacents.containsKey(u)) {
                ArrayList<Integer> neighbors = adjacents.get(u);
                for (int i = 0; i < neighbors.size();i++) {
                    int v = neighbors.get(i);
                    if (--indegrees[v] == 0) {
                        queue.addLast(v);
                    }
                    
                }
                
            }
        }
        return topologicalOrder.size() == n;
    }
    public boolean canFinish_dfs(int n, int[][] edges) {
         if (edges == null || edges.length == 0) {
             return true;
         }
         HashMap<Integer, ArrayList<Integer>> adjacents = new HashMap<Integer, ArrayList<Integer>>();
         for (int i = 0; i < edges.length; i++) {
             int[] edge = edges[i];
             //edge[1] is the prerequisites
             if (!adjacents.containsKey(edge[1])) {
                 adjacents.put(edge[1], new ArrayList<Integer>());
             }
             adjacents.get(edge[1]).add(edge[0]);
         }
         
         State[] state = new State[n];
         for (int i =0 ;i < n; i++) {
             state[i] = State.UNVISITED;
         }
         for (int i = 0; i < n; i++) {
             if (state[i] == State.UNVISITED) {
                 if (dfs(i, adjacents, state)) {
                     return false;
                 }
             }
         }
         return true;
    }
    /*
    true - there is one cycle
    */
    private boolean dfs(int vertex, HashMap<Integer, ArrayList<Integer>> adjacents, State[] state) {
        state[vertex] = State.VISITING;
        if (adjacents.containsKey(vertex)) {
            ArrayList<Integer> neighbors = adjacents.get(vertex);
            //visite it is adjacents of verte
            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                if (state[neighbor] == State.VISITING) {
                    return true;
                } else if (state[neighbor] == State.UNVISITED) {
                    if (dfs(neighbor, adjacents, state)) {
                        return true;
                    }
                }
            }
        }
        state[vertex] = State.VISITED;
        return false;
    }
