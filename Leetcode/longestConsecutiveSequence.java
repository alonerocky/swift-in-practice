public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                continue;
            }
            map.put(num,1);
            
            if (map.containsKey(num-1)) {
                max = Math.max(max, merge(map, num-1, num));
            }
            if (map.containsKey(num+1)) {
                max = Math.max(max, merge(map, num, num+1));
            }
        }
        return max;
    }
    
    public int merge(HashMap<Integer, Integer> map, int left, int right) {
        //upper - right + 1 = map.get(right) 
        //left - lower + 1 = map.get(left)
        int upper = right + map.get(right)  - 1;
        int lower = left + 1 - map.get(left);
        int len = upper - lower + 1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }


//Union Find
class UnionFind {
        private HashMap<Integer, Integer> parent;
        private HashMap<Integer, Integer> rank;
        private HashMap<Integer, Integer> size;
        public UnionFind() {
            parent = new HashMap<Integer, Integer>();
            rank = new HashMap<Integer, Integer>();
            size = new HashMap<Integer, Integer>();
        }
        public boolean contains(int x) {
            return parent.containsKey(x);
        }
        public int find(int x) {
            if (parent.get(x) == x) {
                return x;
            }
            return find(parent.get(x));
        }
        public int union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return size.get(x);
            }
            int rankX = rank.get(x);
            int rankY = rank.get(y);
            if (rankX < rankY) {
                parent.put(x, y);
                size.put(y, size.get(x) + size.get(y));
                return size.get(y);
            } else if (rankX > rankY) {
                parent.put(y, x);
                size.put(x, size.get(x) + size.get(y));
                return size.get(x);
            } else {
                parent.put(x, y);
                rank.put(y, rankY + 1);
                size.put(y, size.get(x) + size.get(y));
                return size.get(y);
            }
        }
        public void add(int x) {
            if (parent.containsKey(x)) {
                return;
            }
            parent.put(x, x);
            rank.put(x, 1);
            size.put(x, 1);
        }
    }
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind();
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (uf.contains(num)) {
                continue;
            }
            uf.add(num);
            if (uf.contains(num-1)) {
                max = Math.max(max, uf.union(num-1,num));
            }
            if (uf.contains(num+1)) {
                max = Math.max(max, uf.union(num, num+1));
            }
        }
        return max;
       
        
    }
