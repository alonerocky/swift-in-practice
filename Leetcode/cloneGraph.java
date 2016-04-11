public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
         HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
         if (node == null) {
             return null;
         }
         return bfs(node);
    }
    
    public UndirectedGraphNode bfs(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Deque<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        map.put(node, result);
        queue.addLast(node);
        //node in queue is already cloned but it's neighbors are not
        while(!queue.isEmpty()) {
            UndirectedGraphNode one = queue.pollFirst();
            UndirectedGraphNode cloned = map.get(one);
            for (int i = 0; i < one.neighbors.size();i++) {
                UndirectedGraphNode neighbor = one.neighbors.get(i);
                if (map.containsKey(neighbor)) {
                    cloned.neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode c = new UndirectedGraphNode(neighbor.label);
                    cloned.neighbors.add(c);
                    map.put(neighbor, c);
                    queue.addLast(neighbor);
                }
            }
        }
        return result;
    }
    
    public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(node, cloned);
        for (int i = 0; i < node.neighbors.size(); i++) {
            cloned.neighbors.add(dfs(node.neighbors.get(i), map));
        }
        return cloned;
    }
