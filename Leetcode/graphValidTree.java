public boolean validTree(int n, int[][] edges) {
        if (n < 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        HashMap<Integer, ArrayList<Integer>> adjacent = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (adjacent.containsKey(edge[0])) {
                adjacent.get(edge[0]).add(edge[1]);
            } else {
                ArrayList<Integer> neighbors = new ArrayList<Integer>();
                neighbors.add(edge[1]);
                adjacent.put(edge[0], neighbors);
            }
            
            if (adjacent.containsKey(edge[1])) {
                adjacent.get(edge[1]).add(edge[0]);
            } else {
                ArrayList<Integer> neighbors = new ArrayList<Integer>();
                neighbors.add(edge[0]);
                adjacent.put(edge[1], neighbors);
            }
        }
        //DFS
        if (hasCycle(0, -1, adjacent, visited)) {
            return false;
        }
        
        for (int i = 0;i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
        
    }
    private boolean hasCycle(int vertex, int parent, HashMap<Integer, ArrayList<Integer>> adjacent, boolean[] visited) {
        visited[vertex] = true;
        ArrayList<Integer> neighbors = adjacent.get(vertex);
        if (neighbors == null) {
            return false;
        }
        for (int i = 0; i < neighbors.size(); i++) {
            int neighbor = neighbors.get(i);
            if (visited[neighbor] && neighbor != parent) {
                return true;
            } else if (!visited[neighbor])  {
                if (hasCycle(neighbor, vertex, adjacent, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
