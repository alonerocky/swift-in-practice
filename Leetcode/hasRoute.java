public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        
        //key is the label
        //value is 0 - unvisited, 1 - visiting, 2 - visited
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        return dfs(s, t, visited);
    }
    
    public boolean dfs(DirectedGraphNode s, DirectedGraphNode t, HashMap<Integer, Integer> visited) {
        visited.put(s.label, 1);
        if (s == t) {
            return true;
        }
        if (s.neighbors.size() > 0) {
            for (int i = 0; i < s.neighbors.size();i++) {
                DirectedGraphNode v = s.neighbors.get(i);
                if (!visited.containsKey(v.label)) {
                    if (dfs(v, t, visited)) {
                        return true;
                    }
                }
            }
        }
        visited.put(s.label, 2);
        return false;
    }
