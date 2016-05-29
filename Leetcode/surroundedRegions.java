public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i,0);
            }
            if (board[i][n-1] == 'O') {
                bfs(board, i,n-1);
            }
        }
        for (int j = 1; j < n-1; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                bfs(board, m-1, j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void bfs(char[][] board, int row, int column) {
        
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int m = board.length;
        int n = board[0].length;
        queue.addLast(row * n + column);
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        board[row][column] = '#';
        while(!queue.isEmpty()) {
            
            int cur = queue.pollFirst();
            int r = cur / n;
            int c = cur % n;
            
            for (int i = 0; i < dirs.length; i++) {
                int nextR = r + dirs[i][0];
                int nextC = c + dirs[i][1];
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && board[nextR][nextC] == 'O') {
                    board[nextR][nextC] = '#';
                    queue.addLast(nextR * n + nextC);
                }
            }
        }
    }

public void dfs(char[][] board, int row, int column) {
        if (board[row][column] != 'O') {
            return;
        }
        board[row][column] = '#';
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < dirs.length; i++) {
            int r = row + dirs[i][0];
            int c = column + dirs[i][1];
            if (r >= 0 
               && r < board.length
               && c >= 0
               && c < board[0].length
               && board[r][c] == 'O') {
                   dfs(board, r, c);
               }
        }
    }


//union find
class UnionFind {
        private HashMap<Integer, Integer> parent;
        private HashMap<Integer, Integer> rank;
        private int count;
        public UnionFind(int n) {
            parent = new HashMap<Integer, Integer>();
            rank = new HashMap<Integer, Integer>();
            for (int i = 0 ; i < n; i++) {
                parent.put(i, i);
                rank.put(i, 1);
            }
        }
        public boolean connected(int a, int b) {
            a = find(a);
            b = find(b);
            return a == b;
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
            if (a == b) { //already in the same set
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
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        UnionFind uf = new UnionFind(m*n + 1);
        
        
        int[][] dirs = {{-1,0},{1,0}, {0,-1},{0,1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m- 1 || j == 0 || j == n -1) && board[i][j] == 'O') {
                    uf.union(m*n , i*n+j);
                } else if (board[i][j] == 'O') {
                    
                    for (int k = 0; k < dirs.length; k++) {
                        int nextX = i + dirs[k][0];
                        int nextY = j + dirs[k][1];
                        int index = nextX * n + nextY;
                        if (board[nextX][nextY] == 'O') {
                            uf.union(index, i*n+j);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.connected(m*n, i*n+j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
