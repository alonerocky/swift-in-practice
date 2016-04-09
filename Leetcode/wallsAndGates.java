public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, visited, 0);
                }
            }
        }
    }
    
    public void dfs(int[][] rooms, int row, int column, boolean[][] visited, int distance) {
        if (rooms[row][column] == -1) {
            return;
        }
        if (visited[row][column]) {
            return;
        }
        if (rooms[row][column] < distance) {
            return;
        }
        visited[row][column] = true;
        if (distance < rooms[row][column]) {
            rooms[row][column] = distance;
        }
        
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}}; //up, down, right, left
        for (int i = 0; i < dirs.length; i++) {
            int r = row + dirs[i][0];
            int c = column + dirs[i][1];
            if (r < 0 || c < 0 || r >= rooms.length || c >= rooms[0].length ) {
                continue;
            }
            dfs(rooms, r, c, visited, distance+1);
        }
        visited[row][column] = false;
        
    }
    
    
    public void wallsAndGates_bfs(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (rooms[i][j] == 0) {
                    int index = i * n + j;
                    queue.addLast(index);
                }
            }
        }
        bfs(queue, rooms);
        
    }
    private void bfs(Deque<Integer> queue, int[][] rooms) {
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()) {
            
            int index = queue.pollFirst();
            int row = index / rooms[0].length;
            int column = index % rooms[0].length;
            
            for (int i = 0; i < dirs.length; i++) {
                int r = row + dirs[i][0];
                int c = column +dirs[i][1];
                if (r < 0 || 
                    c < 0 || 
                    r >= rooms.length || 
                    c >= rooms[0].length ||
                    rooms[r][c] <= rooms[row][column] + 1) {
                        continue;
                    }
                    rooms[r][c] = rooms[row][column] + 1;
                    queue.addLast(r * rooms[0].length + c);
            }
        }
    }
