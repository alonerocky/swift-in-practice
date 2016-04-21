/**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public enum State {UNVISITED, VISITING, VISITED};
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        HashMap<Integer, State> visited = new HashMap<Integer, State>();
        for (int i = 0; i < graph.size();i++) {
            DirectedGraphNode node = graph.get(i);
            if (!visited.containsKey(node.label)) {
                if (!dfs(node, visited, result)) {
                    return new ArrayList<DirectedGraphNode>();
                }
            }
        }
        return result;
    }
    
    //true means exist topological order
    public boolean dfs(DirectedGraphNode u, HashMap<Integer, State> visited, ArrayList<DirectedGraphNode> result) {
        
        visited.put(u.label, State.VISITING);
        
        ArrayList<DirectedGraphNode> neighbors = u.neighbors;
        for (int i = 0; i < neighbors.size();i++) {
            DirectedGraphNode v = neighbors.get(i);
            if (visited.containsKey(v.label)) {
                State s = visited.get(v.label);
                if (s == State.VISITING) {
                    return false;
                }
            } else {
                if (!dfs(v, visited, result)) {
                    return false;
                }
            }
            
        }
        result.add(0, u);
        visited.put(u.label, State.VISITED);
        return true;
    }
