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
