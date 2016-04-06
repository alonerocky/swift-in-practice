public int maximalSquareI(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    //expand
                    int limit = Math.min(m - i, n - j);
                    for (int k = 1; k <= limit; k++) {
                        if (validSquare(matrix, i, j, k)) {
                            max = Math.max(max, k);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return max * max;
    }
    private boolean validSquare(char[][] matrix, int row, int column, int len) {
        
        for (int i = row; i < row + len; i++) {
            for (int j = column; j < column + len; j++) {
                if (matrix[i][j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int maximalSquare(char[][] matrix) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
		return 0;
 
	int m = matrix.length;
	int n = matrix[0].length;
 
	int[][] t = new int[m][n];
 
    int max = 0;
	//top row
	for (int i = 0; i < m; i++) {
		t[i][0] = matrix[i][0] - '0';
		max = Math.max(max, t[i][0]);
	}
 
	//left column
	for (int j = 0; j < n; j++) {
		t[0][j] = matrix[0][j] - '0';
		max = Math.max(max, t[0][j]);
	}
    
	//cells inside
	for (int i = 1; i < m; i++) {
		for (int j = 1; j < n; j++) {
			if (matrix[i][j] == '1') {
				int min = Math.min(t[i - 1][j], t[i - 1][j - 1]);
				min = Math.min(min,t[i][j - 1]);
				t[i][j] = min + 1;
				max = Math.max(max, t[i][j]);
			} else {
				t[i][j] = 0;
			}
		}
	}
	return max * max;
}
