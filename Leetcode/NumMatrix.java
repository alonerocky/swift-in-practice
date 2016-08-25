public class NumMatrix {
    private FenwickTree2D tree ;
    public NumMatrix(int[][] matrix) {
        tree = new FenwickTree2D(matrix);
    }

    public void update(int row, int col, int val) {
        tree.update(row, col, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return tree.sumRegion(row1, col1, row2, col2);
    }
}

class FenwickTree2D {
    private int[][] matrix;
    private int[][] tree;
    private int m;
    private int n;
    public FenwickTree2D(int[][] matrix) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            this.matrix = matrix;
            this.m = matrix.length ;
            this.n = matrix[0].length ;
            this.tree = new int[m+1][n+1];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    add(i, j, matrix[i][j]);
                }
            }
        }
    }

    public int lowBit(int x) {
        return x & -x;
    }
    //add value to matrix[row][column] , need update the tree
    public void add(int row, int column, int value) {
        for(int i = row +1; i <= m; i += lowBit(i)) {
            for(int j = column + 1; j <= n; j += lowBit(j)) {
                tree[i][j] += value;
            }
        }
    }

    public void update(int row, int column, int value) {
        if (matrix[row][column] == value) {
            return ;
        }
        add(row, column, value - matrix[row][column]);
        matrix[row][column] = value;
    }

    public int sum(int row, int column) {
        int result = 0;
        for(int i = row ; i > 0 ; i -= lowBit(i)) {
            for(int j = column ; j > 0 ; j -= lowBit(j)) {
                result += tree[i][j];
            }
        }
        return result;
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        return sum(r2+1, c2+1) - sum(r2+1, c1) - sum(r1, c2+1) + sum(r1,c1);
    }
}


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


class FenwickTree2D {
        private int[][] matrix;
        private int[][] sums;
        private int m; 
        private int n;
        public FenwickTree2D(int[][] matrix) {
            if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
                this.matrix = matrix;
                m = matrix.length;
                n = matrix[0].length;
                this.sums = new int[m+1][n+1];
                for(int i = 1; i <= m; i++) {
                    for(int j = 1; j <= n; j++) {
                        add(i,j,matrix[i-1][j-1]);
                    }
                }
            }
        }
        public int sum(int row, int column) {
            int total = 0;
            for(int i = row; i > 0; i-= lowBit(i)) {
                for(int j = column; j > 0 ; j-= lowBit(j)) {
                    total += sums[i][j];
                }
            }
            return total;
        }
        public int sumRegin(int row1, int col1, int row2, int col2) {
            return sum(row2, col2) - sum(row2, col1-1) - sum(row1-1, col2) + sum(row1-1, col1-1);
        }
        public void add(int row, int column, int value) {
           
            for(int i = row; i <= m; i += lowBit(i)) {
                for(int j = column; j <= n; j+= lowBit(j)) {
                    sums[i][j] += value;
                }
            }
        }
        public void update(int row, int column, int value) {
            int delta = value - matrix[row-1][column-1];
            if (delta == 0) {
                return;
            }
            matrix[row-1][column-1] = value;
            add(row, column, delta);
        }
        
        private int lowBit(int x) {
            return x & -x;
        }
            
    }
