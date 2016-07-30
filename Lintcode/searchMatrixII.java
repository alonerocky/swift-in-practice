public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        while(i < n && matrix[i][n-1] < target) i++;
        int j = m-1;
        while(j >= 0 && matrix[j][0] > target) j--;
        if (i > j) {
            return 0;
        }
        int cont = 0;
        for(int k = 0; k <= j; k++) {
            if (binarySearch(matrix, k, target)) {
                count++;
            }
        }
        return count;
    }
    
    public boolean binarySearch(int[][] matrix, int row, int target ) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (row < 0 || row >= m) {
            return false;
        }
        int i = 0; 
        int j = n - 1;
        while(i <= j) {
            int middle = (i + j)/2;
            if (matrix[row][middle] == target) {
                return true;
            } else if (matrix[row][middle] < target) {
                i=middle+1;
            } else {
                j=middle-1;
            }
        }
        return false;
    }
    public int searchMatrixI(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m-1;
        int j = 0;
        while(i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                count++;
                i--;
                j++;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
