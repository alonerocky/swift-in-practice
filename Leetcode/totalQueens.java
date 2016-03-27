private int count = 0;
    public int totalNQueens(int n) {
        
        count = 0;
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        tryNextQueen(queens, 0);
        return count;
    }
    private void tryNextQueen(int[] queens, int column) {
        if (column == queens.length) {
            count++;
            return;
        } else  {
            for (int i = 0; i < queens.length; i++) {
                 
                if (isValid(queens, column, i)) {
                    queens[column] = i;
                    tryNextQueen(queens, column + 1);
                    queens[column] = -1; 
                } 
            }
        }
    }
    /*
    determine if put queen at column is valid
    queens stored the row
    */
    public boolean isValid(int[] queens, int column, int queen ) {
        
        for (int i = 0; i < column; i++) {
            //i,      queens[i]
            //column, queen
            if (queens[i] == queen || 
               queens[i] - queen == i - column ||
               queens[i] - queen == column - i) {
                   return false;
               }
        }
        return true;
    }
