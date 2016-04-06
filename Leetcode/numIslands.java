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
