 //dfs
     public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n= board[0].length;
        //first & last row
        for(int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m-1][i] == 'O') {
                dfs(board, m-1, i);
            }
        }
        //left & right column
        for(int i = 1; i < m-1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
     }
     private void dfs(char[][] board, int row, int column) {
         int m = board.length;
         int n = board[0].length;
         board[row][column] = 'T';
         int[][] neighbors = {{-1,0},{1,0},{0,-1},{0,1}};
         for(int i = 0; i < neighbors.length;i++) {
                 int[] neighbor = neighbors[i];
                 int nextR = row + neighbor[0];
                 int nextC = column + neighbor[1];
                 if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && board[nextR][nextC] == 'O') {
                     dfs(board, nextR, nextC);
                 }
        }
     }
     
     public void surroundedRegions_bfs(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n= board[0].length;
        //first & last row
        for(int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i);
            }
            if (board[m-1][i] == 'O') {
                bfs(board, m-1, i);
            }
        }
        //left & right column
        for(int i = 1; i < m-1; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                bfs(board, i, n-1);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
     }
     private void bfs(char[][] board, int row, int column) {
         int m = board.length;
         int n = board[0].length;
         Deque<Integer> deque = new ArrayDeque<Integer>();
         deque.addLast(row * n + column);
         int[][] neighbors = {{-1,0},{1,0},{0,-1},{0,1}};
         while(!deque.isEmpty()) {
             
             int front = deque.pollFirst();
             int r = front/n;
             int c = front % n;
             board[r][c] = 'T';
             for(int i = 0; i < neighbors.length;i++) {
                 int[] neighbor = neighbors[i];
                 int nextR = r + neighbor[0];
                 int nextC = c + neighbor[1];
                 if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && board[nextR][nextC] == 'O') {
                     deque.addLast(nextR * n + nextC);
                 }
             }
             
             
         }
     }
     //union find
    public void surroundedRegionsI(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n= board[0].length;
        int len = m * n;
        UnionFind uf = new UnionFind(len + 1);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                        uf.union(i* n + j, len);
                    }
                    int[][] neighbors = {{-1,0},{1,0},{0,-1},{0,1}};
                    for(int t = 0; t < neighbors.length; t++) {
                        int[] neighbor = neighbors[t];
                        int r = i + neighbor[0];
                        int c = j + neighbor[1];
                        if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 'O') {
                            uf.union(i*n + j, r *n + c);
                        }
                    }
                }
            }
        }
        
        for(int i =0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.connected(i*n+j, len)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    class UnionFind {
        private HashMap<Integer, Integer> parent;
        private HashMap<Integer, Integer> rank;
        public UnionFind(int n) {
            parent = new HashMap<Integer, Integer>();
            rank = new HashMap<Integer, Integer>();
            for(int i = 0; i < n; i++) {
                parent.put(i, -1);
                rank.put(i, 1);
            }
        }
        
        public int find(int a) {
            if (parent.get(a) == -1) {
                return a;
            }
            return find(parent.get(a));
        }
        
        public boolean connected(int a, int b) {
            return find(a) == find(b);
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
                        rank.put(b, rankb+1);
                    }
                }
            
        }
    }
