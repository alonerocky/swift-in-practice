public boolean validTree(int n, int[][] edges) {
        if (n <= 0) {
            return false;
        }
        if (edges == null || edges.length == 0) {
            return n == 1;
        }
        
        if (edges.length != n-1) {
            return false;
        }
        
        HashMap<Integer, ArrayList<Integer>> adjacents = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!adjacents.containsKey(edge[0])) {
                adjacents.put(edge[0], new ArrayList<Integer>());
            }
            adjacents.get(edge[0]).add(edge[1]);
            
            if(!adjacents.containsKey(edge[1])) {
                adjacents.put(edge[1], new ArrayList<Integer>());
            }
            adjacents.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                //dfs(i, adjacents, visited);
                bfs(i, adjacents, visited);
                count++;
            }
        }
        return count == 1;
    }
    
    public void dfs(int vertex, HashMap<Integer, ArrayList<Integer>> adjacents, boolean[] visited) {
        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        if (!adjacents.containsKey(vertex)) {
            return;
        }
        Iterator<Integer> neighbors = adjacents.get(vertex).iterator();
        while (neighbors.hasNext()) {
            int neighbor = neighbors.next();
            if (!visited[neighbor]) {
                dfs(neighbor, adjacents, visited);
            }
        }
    }
    
    public void bfs(int vertex, HashMap<Integer, ArrayList<Integer>> adjacents, boolean[] visited) {
        if (visited[vertex]) {
            return ;
        }
        visited[vertex] = true;
        if (!adjacents.containsKey(vertex)) {
            return;
        }
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.addLast(vertex);
        while (!queue.isEmpty()) {
            
            int v = queue.pollFirst();
            visited[v] = true;
            Iterator<Integer> neighbors = adjacents.get(v).iterator();
            while (neighbors.hasNext()) {
                int neighbor = neighbors.next();
                if (!visited[neighbor]) {
                    queue.addLast(neighbor);
                    //visited[neighbor] = true;
                }
            }
        }
    }


class UnionFind {
        private HashMap<Integer, Integer> parent;
        private HashMap<Integer, Integer> rank;
        private int count;
        public UnionFind(int n) {
            parent = new HashMap<Integer, Integer>();
            rank = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                parent.put(i, i);
                rank.put(i, 1);
            }
            count = n;
        }
        public int getCount() {
            return count;
        }
        private boolean contains(int v) {
            return parent.containsKey(v);
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
    public boolean validTree(int n, int[][] edges) {
          if (n <= 0) {
              return false;
          }
          if (edges.length != n-1) {
              return false;
          }
          UnionFind uf = new UnionFind(n);
          for (int i = 0; i < edges.length;i++) {
              int[] edge = edges[i];
              uf.union(edge[0], edge[1]);
          }
          return uf.getCount() == 1;
          
    }
