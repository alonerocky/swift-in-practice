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

public void bfs(int u, HashMap<Integer, ArrayList<Integer>> adjacents, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.addLast(u);
        visited[u] = true;
        while(!queue.isEmpty()) {
            int front = queue.pollFirst();
            if(adjacents.containsKey(front)) {
                ArrayList<Integer> neighbors =  adjacents.get(front);
                for (int i = 0; i < neighbors.size(); i++) {
                    int v = neighbors.get(i);
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.addLast(v);
                    }
                }
            }
        }
    }


class UnionFind {
        private HashMap<Integer, Integer> parent;
        private HashMap<Integer, Integer> rank;
        private int count;
        public UnionFind() {
            parent = new HashMap<Integer, Integer>();
            rank = new HashMap<Integer, Integer>();
            count = 0;
        }
        public int getCount() {
            return count;
        }
        public boolean contains(int v) {
            return parent.containsKey(v);
        }
        public void add(int v) {
            if (contains(v)) {
                return;
            }
            parent.put(v, v);
            rank.put(v,1);
            count++;
        }
        public void addEdge(int a, int b) {
            add(a);
            add(b);
            union(a,b);
        }
        public void addEdge(int[] edge) {
            addEdge(edge[0], edge[1]);
        }
        public int find(int v) {
            if (parent.get(v) == v) {
                return v;
            }
            return find(parent.get(v));
        }
        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) {
                return;
            }
            int ranka = rank.get(a);
            int rankb = rank.get(b);
            if (ranka < rankb) {
                parent.put(a, b);
                
            } else {
                parent.put(b, a);
                if (ranka == rankb) {
                    rank.put(a, ranka + 1);
                }
            }
            count--;
        }
    }
    public int countComponents(int n, int[][] edges) {
         if (n <= 0) {
             return 0;
         }
         UnionFind uf = new UnionFind();
         for (int i = 0; i < n; i++) {
             uf.add(i);
         }
         for (int i = 0; i < edges.length; i++) {
             int[] edge = edges[i];
             uf.addEdge(edge);
         }
         return uf.getCount();
         
         
    }
