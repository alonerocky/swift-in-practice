public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, cache);
                if (len > max) {
                    max = len;
                }
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] cache) {

        if (cache[row][column] > 0) {
            return cache[row][column];
        }
        int max = 1;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; //up, down, left, right
        for (int i = 0; i < dirs.length; i++) {
            int r = row + dirs[i][0];
            int c = column + dirs[i][1];
            if (r >= 0 &&
                    r < matrix.length &&
                    c >= 0 &&
                    c < matrix[0].length &&
                    matrix[r][c] > matrix[row][column] ) {
                int len = 1 + dfs(matrix, r, c, cache);
                if (len > max) {
                    max = len;
                }
            }
        }
        cache[row][column] = max;
        return max;
    }
