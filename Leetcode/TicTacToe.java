http://buttercola.blogspot.com/2016/06/leetcode-348-design-tic-tac-toe.html
public class TicTacToe {
    private int[][] rows;
    private int[][] cols;
    private int[] diag;
    private int[] xdiag;
    private int n;
 
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[2][n];
        cols = new int[2][n];
        diag = new int[2];
        xdiag = new int[2];
    }
     
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int p = player == 1 ? 0 : 1;
         
        rows[p][row]++;
        cols[p][col]++;
         
        if (row == col) {
            diag[p]++;
        }
             
        // X-diagonal
        if (row + col == n - 1) {
            xdiag[p]++;
        }
             
        // If any of them equals to n, return 1
        if (rows[p][row] == n || cols[p][col] == n || 
            diag[p] == n || xdiag[p] == n) {
            return p + 1;
        }
         
        return 0;
    }
}
 
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diag;
    private int xdiag;
    private int n;
 
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        xdiag = 0;
    }
     
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int count = player == 1 ? 1 : -1;
         
        rows[row] += count;
        cols[col] += count;
         
        if (row == col) {
            diag += count;
        }
             
        // X-diagonal
        if (row + col == n - 1) {
            xdiag += count;
        }
             
        // If any of them equals to n, return 1
        if (Math.abs(rows[row]) == n || 
            Math.abs(cols[col]) == n || 
            Math.abs(diag) == n || 
            Math.abs(xdiag) == n) {
            return count > 0 ? 1 : 2;
        }
         
        return 0;
    }
}
 
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

