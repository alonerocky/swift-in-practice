public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return false;
        }
        
        int rows = board.length;
        int columns = board[0].length;
        for (int i =0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][columns];
                    if (tryNext(word, 0, i, j, board, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean tryNext(String word, int i, int row, int column, char[][] board, boolean[][] visited) {
        if (i == word.length() - 1 && board[row][column] == word.charAt(i)) {
            return true;
        }
        if (board[row][column] == word.charAt(i)) {
             
            //try up
            visited[row][column] = true;
            if (row -1 >= 0 && !visited[row-1][column] &&  tryNext(word, i+1, row -1, column, board, visited)) {
                return true;
            }
            //try down
            if (row + 1 < board.length && !visited[row+1][column] && tryNext(word, i+1, row + 1, column, board, visited)) {
                return true;
            }
            //try left
            if (column - 1 >= 0 && !visited[row][column-1] &&  tryNext(word, i+1, row, column -1, board, visited)) {
                return true;
            }
            //try right
            if (column + 1 < board[0].length && !visited[row][column+1] &&  tryNext(word, i+1, row, column + 1, board, visited)) {
                return true;
            }
            visited[row][column] = false;
        }
        return false;
    }




//lintCode
public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
         
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    if (tryNextChar(board, word, 0, i,j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean tryNextChar(char[][] board, String word, int index, int row, int column, boolean[][] visited) {
        if (index == word.length()-1 && board[row][column] == word.charAt(index)) {
            return true;
        } 
        if ( word.charAt(index) == board[row][column]) {
            visited[row][column] = true;
            int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
            for (int i = 0; i < dirs.length; i++) {
                int r = row + dirs[i][0];
                int c = column + dirs[i][1];
                if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && !visited[r][c] ) {
                    if (tryNextChar(board, word, index+1, r,c,visited)) {
                        return true;
                    }
                }
                 
            }
            visited[row][column] = false;
        }
        return false;
    }
