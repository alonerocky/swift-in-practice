public int maxKilledEnemiesI(char[][] grid) {
        int max = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int killed = getKilledEnemies(grid, i, j);
                    max = Math.max(max, killed);
                }
            }
        }
        return max;
    }
    
    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int killed = getEnimies(grid, i, j);
                    max = Math.max(max, killed);
                }
            }
        }
        return max;
    }
    private HashMap<Integer, Integer> rowCache = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> columnCache = new HashMap<Integer, Integer>();
    private void preprocess(char[][] grid) {
        //calculate 
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            int rowEnimies = 0;
            int j = 0;
            for(; j < n; j++) {
                if (grid[i][j] == 'E') {
                    rowEnimies++;
                } else if (grid[i][j] == 'W') {
                    break;
                }
            }
            if (j == n) {
                rowCache.put(i, rowEnimies);
            }
        }
        for(int j = 0; j < n; j++) {
            int columnEnimies = 0;
            int i = 0;
            for(;i < m; i++) {
                if (grid[i][j] == 'E') {
                    columnEnimies++;
                } else if (grid[i][j] == 'W') {
                    break;
                }
            }
            if (i == m) {
                columnCache.put(j, columnEnimies);
            }
        }
    }
    
    private int getRowEnimies(char[][] grid, int row, int column) {
        if (rowCache.containsKey(row)) {
            return rowCache.get(row);
        }
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int i = column;
        while(i < n && grid[row][i] != 'W') {
            if (grid[row][i] == 'E') {
                total++;
            }
            i++;
        }
        i = column;
        while(i >= 0 && grid[row][i] != 'W') {
            if (grid[row][i] == 'E') {
                total++;
            }
            i--;
        }
        return total;
    }
    private int getColumnEnimies(char[][] grid, int row, int column) {
        if (columnCache.containsKey(column)) {
            return columnCache.get(column);
        }
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int i = row;
        while(i < m && grid[i][column] != 'W') {
            if (grid[i][column] == 'E') {
                total++;
            }
            i++;
        }
        i = row;
        while(i >= 0 && grid[i][column] != 'W') {
            if (grid[i][column] == 'E') {
                total++;
            }
            i--;
        }
        return total;
    }
    
    private int getEnimies(char[][] grid, int row, int column) {
        return getRowEnimies(grid, row, column) + getColumnEnimies(grid, row, column);
    }
    
    
    
    public int getKilledEnemies(char[][] grid, int row, int column) {
        int killed = 0;
        int m = grid.length;
        int n = grid[0].length;
        //right
        int i = column;
        while(i < n && grid[row][i] != 'W') {
            if (grid[row][i] == 'E') {
                killed++;
            }
            i++;
        }
        //left
        i = column;
        while(i >= 0 && grid[row][i] != 'W') {
            if (grid[row][i] == 'E') {
                killed++;
            }
            i--;
        } 
        //up
        i = row;
        while(i < m && grid[i][column] != 'W') {
            if (grid[i][column] == 'E') {
                killed++;
            }
            i++;
        }
        //down
        i = row;
        while(i >= 0 && grid[i][column] != 'W') {
            if (grid[i][column] == 'E') {
                killed++;
            }
            i--;
        }
        return killed;
    }
