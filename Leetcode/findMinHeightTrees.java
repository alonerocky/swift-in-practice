public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> leaves = new ArrayList<Integer>();
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }
	HashMap<Integer, HashSet<Integer>> adjacents = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!adjacents.containsKey(edge[0])) {
                adjacents.put(edge[0], new HashSet<>());
            }
            adjacents.get(edge[0]).add(edge[1]);
            if (!adjacents.containsKey(edge[1])) {
                adjacents.put(edge[1], new HashSet<>());
            }
            adjacents.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            if (adjacents.containsKey(i) && adjacents.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i = 0; i < leaves.size(); i++) {
                int leaf = leaves.get(i);
                //leaf now has only one neighbor
                int neighbor = adjacents.get(leaf).iterator().next();
                adjacents.get(neighbor).remove(leaf);
                if (adjacents.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;

        }
        return leaves;
    }
