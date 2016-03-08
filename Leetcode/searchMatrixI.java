public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        if (target < matrix[0][0] || target > matrix[rows -1][columns - 1] ) {
            return false;
        }
        
        int i =0;
        int j = rows - 1;
        int column = columns - 1;
        //determin which row
        while (i <= j) {
            int middle = (i + j)/2;
            int element = matrix[middle][column];
            if (target == element) {
                return true;
            } else if (target < element) {
                j = middle - 1;
            } else {
                i = middle + 1;
            }
        }
        int row = i;
        i = 0;
        j = columns - 1;
        while (i <= j) {
            int middle = (i + j)/2;
            int element = matrix[row][middle];
            if (element == target) {
                return true;
            } else if (element < target) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return false;
    }
