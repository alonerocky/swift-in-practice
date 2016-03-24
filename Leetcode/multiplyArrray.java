public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || 
        A.length == 0 || 
        A[0].length == 0 || 
        B == null || 
        B.length == 0 || 
        B[0].length == 0) {
            return null;
        }
        
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;
        if (n != B.length) {
            return null;
        }
        
        int[][] result = new int[m][k];
        
        for (int i = 0; i < m; i++) {
            for (int t = 0; t < n; t++) {
                if (A[i][t] != 0) {
                    for (int j = 0; j < k; j++) {
                        result[i][j] += A[i][t] * B[t][j];
                    }
                }
            }
        }
        return result;
    }
