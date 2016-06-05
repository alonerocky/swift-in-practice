public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int row, int column, boolean[][] visited) {
        visited[row][column] = true;
        //visite left
        if (isSafe(grid, row, column - 1, visited)) {
            dfs(grid, row,column - 1,visited);
        }
        
        //visite right
        if (isSafe(grid, row, column + 1, visited)) {
            dfs(grid, row,column + 1,visited);
        }
        
        //visite up
        if (isSafe(grid, row-1, column, visited)) {
            dfs(grid, row-1,column,visited);
        }
        
        //visite down
        if (isSafe(grid, row+1, column, visited)) {
            dfs(grid, row+1,column,visited);
        }
        
         
    }
    
    private boolean isSafe(char[][] grid, int row, int column, boolean[][] visited) {
        return (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == '1' && !visited[row][column]);
    }


public void bfs(char[][] grid, int row, int column, boolean[][] visited) {
        if (grid[row][column] == '0' || visited[row][column]) {
            return;
        }
        
        //use a queue
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.addLast(row);
        queue.addLast(column);
        visited[row][column] = true;
        while (!queue.isEmpty()) {
            int r = queue.pollFirst();
            int c = queue.pollFirst();
            //try to add left cell to queue
            if (c - 1 >= 0 && grid[r][c-1] == '1' && !visited[r][c-1]) {
                queue.addLast(r);
                queue.addLast(c-1);
                visited[r][c-1] = true;
            }
            //try to add right cell to queue
            if (c + 1 < grid[0].length && grid[r][c+1] == '1' && !visited[r][c+1]) {
                queue.addLast(r);
                queue.addLast(c+1);
                visited[r][c+1] = true;
            }
            
            //try to add up cell to queue
            if (r - 1 >= 0 && grid[r-1][c] == '1' && !visited[r-1][c]) {
                queue.addLast(r-1);
                queue.addLast(c);
                visited[r-1][c] = true;
            }
            
            //try to add down cell to queue
            if (r+1 < grid.length && grid[r+1][c] == '1' && !visited[r+1][c]) {
                queue.addLast(r+1);
                queue.addLast(c);
                visited[r+1][c] = true;
            }
            
            
        }
    }

//beter dfs & dfs
public void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        
        int m = grid.length;
        int n = grid[0].length;
        visited[r][c] = true;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < dirs.length; i++) {
            int nextR = r + dirs[i][0];
            int nextC = c + dirs[i][1];
            if (nextR >= 0 && 
            nextR < m && 
            nextC >= 0 && 
            nextC < n && 
            grid[nextR][nextC] == '1' &&
            !visited[nextR][nextC]) {
                dfs(nextR, nextC, grid, visited);
            }
        }
    }
    
    public void bfs(int r, int c, char[][] grid, boolean[][] visited) {
        visited[r][c] = true;
        int m = grid.length;
        int n = grid[0].length;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.addLast(r * n + c);
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int front = queue.pollFirst();
                int row = front / n;
                int col = front % n;
                for (int j = 0 ; j < dirs.length; j++) {
                    int nextR = row + dirs[j][0];
                    int nextC = col + dirs[j][1];
                    if (nextR >= 0 && 
                    nextR < m && 
                    nextC >= 0 && 
                    nextC < n && 
                    grid[nextR][nextC] == '1' && 
                    !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        queue.addLast(nextR * n + nextC);
                    }
                }
            }
        }
    }

//union find
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
        public boolean contains(int n) {
            return parent.containsKey(n);
        }
        public void add(int n) {
            if (contains(n)) {
                return;
            }
            parent.put(n, n);
            rank.put(n,1);
            count++;
        }
        public int find(int a) {
            if (parent.get(a) == a) {
                return a;
            }
            return find(parent.get(a));
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
            } else if (rankA > rankB) {
                parent.put(b, a);
            } else {
                parent.put(a, b);
                rank.put(b, rank.get(b) + 1);
            }
            count--;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind();
        int[][] dirs = {{-1,0},{0,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int index = i * n + j; 
                    uf.add(index);
                    for (int k = 0; k < dirs.length; k++) {
                        int nextX = i + dirs[k][0];
                        int nextY = j + dirs[k][1];
                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == '1') {
                            int nextIndex = nextX * n + nextY;
                           /* if (uf.contains(nextIndex)) {
                                uf.union(index, nextIndex);
                            } */
                            uf.union(index, nextIndex);
                        }
                    }
                }
                 
            }
        }
        return uf.getCount();
    }
