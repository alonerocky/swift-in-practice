public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] reached = new int[m][n]; //reach[i][j] means how many house can reach it
        int[][] dist = new int[m][n]; //dist[i][j] means the total distance

        int buildingNum = 0;
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    buildingNum++;
                    boolean[][] visited = new boolean[m][n];
                    bfs(grid, i, j, visited, dist, reached);
                }
            }
        }


        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++ ) {
                if (grid[i][j] == 0 && reached[i][j] == buildingNum) {
                    minDist = Math.min(minDist, dist[i][j]);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;

    }

    public void bfs(int[][] grid, int row, int column, boolean[][] visited, int[][] dist, int[][] reached) {
        visited[row][column] = true;

        Deque<Integer> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        queue.addLast(row * n + column);
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int level = 0;
        while (!queue.isEmpty()) {
            //handle this level
            int size = queue.size();
            for (int i = 0; i < size;i++) {
                int cur = queue.pollFirst();
                int r = cur / n;
                int c = cur % n;
                for (int j = 0; j < dirs.length;j++) {
                    int nextR = r + dirs[j][0];
                    int nextC = c + dirs[j][1];
                    if (nextR >= 0 && nextR < m &&
                            nextC >= 0 && nextC < n &&
                            grid[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        reached[nextR][nextC]++;
                        dist[nextR][nextC] += level + 1;
                        queue.addLast(nextR * n + nextC);
                    }
                }
            }
            level++;
        }

    }
