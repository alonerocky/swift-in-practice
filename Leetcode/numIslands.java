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
