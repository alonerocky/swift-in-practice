public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneGraph(node, map);
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(node, cloned);
        ArrayList<UndirectedGraphNode> neighbors = (ArrayList<UndirectedGraphNode>)node.neighbors;
        for (int i = 0;i < neighbors.size(); i++) {
            cloned.neighbors.add(cloneGraph(neighbors.get(i), map));
        }
        return cloned;
    }
