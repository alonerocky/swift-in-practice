private List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        tryNextQueue(queens, n, 0, result);
        return result;
    }
    
    private void tryNextQueue(int[] queens, int n, int column, List<List<String>> result) {
        if (column == n) {
            ArrayList<String> oneResult = printQueens(queens, n);
            result.add(oneResult);
            return;
        } else if (queens[column] == -1) {
            for (int i = 0; i < n; i++) {
                if (isValid(queens, column, i)) {
                    queens[column] = i;
                    tryNextQueue(queens, n, column + 1, result);
                    queens[column] = -1;
                }
            }
        }
    }
    
    private ArrayList<String> printQueens(int[] queens, int n) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(j == queens[i] ? 'Q' : '.');
            }
            result.add(sb.toString());
        }
        return result;
    }
    //determin if it is valid at column
    private boolean isValid(int[] queens, int column, int queen) {
        for (int i = 0; i < column; i++) {
            if (queens[i] == queen ||
                queens[i] - queen == i - column ||
                queens[i] - queen == column - i) {
                    return false;
                }
        }
        return true;
    }
