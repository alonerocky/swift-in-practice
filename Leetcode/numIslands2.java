class UnionFind {
        private HashMap<Integer, Integer> parent ;
        private HashSet<Integer> roots;
        private HashMap<Integer, Integer> rank;
        private int count = 0;
        public UnionFind() {
            parent = new HashMap<Integer, Integer>();
            roots = new HashSet<Integer>();
            rank = new HashMap<Integer, Integer>();
        }
        public int getRootSize() {
            return roots.size();
        }
        public int getCount() {
            return count;
        }
        public boolean contains(int num) {
            return parent.containsKey(num);
        }
        public void add(int num) {
            if (parent.containsKey(num)) {
                return;
            }
            parent.put(num, num);
            rank.put(num, 1);
            roots.add(num);
            count++;
        }
        public int find(int num) {
            if(parent.get(num) == num) {
                return num;
            }
            return find(parent.get(num));
        }
        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) {
                return;
            }
            int rankA = rank.get(a);
            int rankB = rank.get(b);
            if (rankA < rankB) {
                parent.put(a, b);
                roots.remove(a);
            } else if (rankB < rankA) {
                parent.put(b, a);
                roots.remove(b);
            } else {
                parent.put(a, b);
                rank.put(b, rank.get(b) + 1);
                roots.remove(a);
            }
            count--;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();
        if (m <= 0 || n <= 0 || positions == null || positions.length == 0 || positions[0].length == 0) {
            return result;
        }
        UnionFind uf = new UnionFind();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int len = positions.length;
        for (int i = 0; i < len; i++) {
            int[] position = positions[i];
            int index = position[0] * n + position[1];
            uf.add(index);
            for (int j = 0; j < dirs.length; j++) {
                int nextX = position[0] + dirs[j][0];
                int nextY = position[1] + dirs[j][1];
                int nextIndex = nextX * n + nextY;
                if (nextX >= 0 && nextX < m 
                     && nextY >= 0 && nextY < n && uf.contains(nextIndex)) {
                    uf.union(index, nextIndex);
                }
            }
            result.add(uf.getCount());
        }
        return result;
    }
