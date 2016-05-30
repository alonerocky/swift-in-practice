public class NumMatrix {
    private int[][] sum;
    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (!isEmpty()) {
            int rows = matrix.length;
            int columns = matrix[0].length;
            sum = new int[rows][columns];
            //initialize the sum array
            sum[0][0] = matrix[0][0];
            //calculate the first column
            for (int i = 1; i < rows; i++) {
                sum[i][0] = sum[i-1][0] +  matrix[i][0];
            }
            //calculate the first row
            for (int j =1 ;j < columns; j++) {
                sum[0][j] = sum[0][j-1] + matrix[0][j];
            }
            //calculate the rest of the sum array
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < columns; j++) {
                    //sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j]
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (isEmpty()) {
            return 0;
        }
        //sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1]
        if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        } else if (col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2] ;
        } else if (row1 == 0) {
            return sum[row2][col2]  - sum[row2][col1 - 1] ;
        } else {
            return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 -1 ] + sum[row1 - 1][col1 - 1];
        }
    }
    private boolean isEmpty() {
        if (this.matrix == null || this.matrix.length == 0 || this.matrix[0].length == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] argv) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(1,2,2,4));
    }
}