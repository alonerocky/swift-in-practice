public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int i = 0; 
        int j = columns - 1;
        while (i < rows && j >= 0) {
            int element = matrix[i][j];
            if (element == target) {
                return true;
            } else if (element < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
