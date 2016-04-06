public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges == null ) {
            return 0;
        }
        
        HashMap<Integer, ArrayList<Integer>> neighbors = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            //[edge[0], edge[1]] or [edge[1], edge[0]];
            if (neighbors.containsKey(edge[0])) {
                neighbors.get(edge[0]).add(edge[1]);
            } else {
                ArrayList<Integer> neighbor = new ArrayList<Integer>();
                neighbor.add(edge[1]);
                neighbors.put(edge[0], neighbor);
            }
            
            if (neighbors.containsKey(edge[1])) {
                neighbors.get(edge[1]).add(edge[0]);
            } else {
                ArrayList<Integer> neighbor = new ArrayList<Integer>();
                neighbor.add(edge[0]);
                neighbors.put(edge[1], neighbor);
            }
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, neighbors, visited);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int vertex, HashMap<Integer, ArrayList<Integer>> neighbors, boolean[] visited) {
        visited[vertex] = true;
        if (!neighbors.containsKey(vertex)) {
            return;
        }
        ArrayList<Integer> neighbor = neighbors.get(vertex);
        for (int i = 0; i < neighbor.size(); i++) {
            int n = neighbor.get(i);
            if (!visited[n]) {
                dfs(n, neighbors, visited);
            }
        }
    }
