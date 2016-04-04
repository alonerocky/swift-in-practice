private char[][] matrix;
    public void solveSudoku(char[][] board) {
        matrix = new char[9][9];
        tryNext(board,0,0);
        for(int i =0;i< 9;i++)
        {
            for(int j = 0;j < 9;j++)
            {
                board[i][j] = matrix[i][j];
            }
        }
    }

    public void tryNext(char[][] board, int row, int column ) {
        if (row >= 9) {
            for(int i =0;i< 9;i++)
            {
                for(int j = 0;j < 9;j++)
                {
                    matrix[i][j] = board[i][j];
                }
            }
            return;
        } else if (board[row][column] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                board[row][column] = c;
                if (isValid(board)) {

                    //try next one
                    if (column == 8) {
                        tryNext(board, row + 1, 0);
                    } else {
                        tryNext(board, row, column + 1);
                    }

                }
                board[row][column] = '.';
            }
        } else {
            if (column == 8) {
                tryNext(board, row + 1, 0);
            } else {
                tryNext(board, row, column + 1);
            }

        }
    }

    public boolean isValid(char[][] board) {
        return isRowValid(board) && isColumnValid(board) && isBlockValid(board);
    }

    public boolean isRowValid(char[][] board) {

        for (int i = 0; i < 9; i++) {
            int[] nums = new int[9]; //0-9  //check ith row
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c >= '0' && c <= '9') {
                    nums[c-'1']++;
                    if (nums[c-'1'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isColumnValid(char[][] board) {

        for (int j = 0; j < 9; j++) {
            int[] nums = new int[9]; //0-9
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c >= '0' && c <= '9') {
                    nums[c-'1']++;
                    if (nums[c-'1'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isBlockValid(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = 3*i;
                int column = 3*j;
                int[] nums = new int[9]; //0-9
                for (int m = 0; m < 3; m++) {
                    for( int n = 0; n < 3; n++) {
                        char c = board[row + m][column+n];
                        if (c >= '1' && c <= '9') {
                            nums[c-'1'] ++;
                            if (nums[c-'1'] > 1) {
                                return false;
                            }
                        }

                    }
                }
            }
        }
        return true;
    }
