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



public ArrayList<DirectedGraphNode> topSort_bfs(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        HashMap<Integer, DirectedGraphNode> adjacents = new HashMap<Integer, DirectedGraphNode>();
        HashMap<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        buildAdjacentsAndIndegree(graph, adjacents, indegree);
        ArrayList<Integer> order = new ArrayList<Integer>();
        bfs(adjacents, indegree, order);
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        for (int i = 0; i < order.size(); i++) {
            result.add(adjacents.get(order.get(i)));
        }
        return result;
    }

    public void buildAdjacentsAndIndegree(ArrayList<DirectedGraphNode> graph, HashMap<Integer, DirectedGraphNode> adjacents, HashMap<Integer, Integer> indegree) {

        for (int i = 0; i < graph.size(); i++) {
            int u = graph.get(i).label;
            indegree.put(u, 0);
        }
        for (int i = 0; i < graph.size(); i++) {
            DirectedGraphNode u = graph.get(i);
            adjacents.put(u.label, u);
        }
        for (int i = 0; i < graph.size(); i++) {
            int u = graph.get(i).label;
            ArrayList<DirectedGraphNode> neighbors = graph.get(i).neighbors;
            for (int j = 0; j < neighbors.size(); j++) {
                int v = neighbors.get(j).label;
                indegree.put(v, indegree.get(v) + 1);
            }
        }
    }



    public boolean bfs(HashMap<Integer, DirectedGraphNode> adjacents, HashMap<Integer, Integer> indegree, ArrayList<Integer> order) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        Iterator<Integer> iterator = indegree.keySet().iterator();
        while (iterator.hasNext()) {
            int u = iterator.next();
            if (indegree.get(u) == 0) {
                queue.addLast(u);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            order.add(u);
            if (adjacents.containsKey(u)) {
                DirectedGraphNode g = adjacents.get(u);
                ArrayList<DirectedGraphNode> neighbors = g.neighbors;
                for (int i = 0; i < neighbors.size(); i++) {
                    int v = neighbors.get(i).label;
                    indegree.put(v, indegree.get(v) - 1);
                    if (indegree.get(v) == 0) {
                        queue.addLast(v);
                    }
                }
            }
        }
        return order.size() == indegree.size();
    }
