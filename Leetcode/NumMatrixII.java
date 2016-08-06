public class NumMatrix {
    // private FenwickTree2D tree;
    private int[][] sums ;
    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
          //tree = new FenwickTree2D(matrix);
          if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
              this.matrix = matrix;
          int m = matrix.length;
          int n = matrix[0].length;
          sums = new int[m+1][n+1];
          for(int i = 1; i <= m; i++) {
              for(int j = 1; j <= n; j++) {
                  sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + matrix[i-1][j-1];
              }
          }
          }
    }
     
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrix == null ) {
            return 0;
        }
        //return tree.sumRegin(row1 + 1, col1 + 1, row2 + 1, col2+1);
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
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
     
} 
