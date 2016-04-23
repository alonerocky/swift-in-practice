public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> columns = new ArrayList<Integer>();
        
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        int middle = rows.get(rows.size()/2);
        int sum = 0;
        for (int i = 0; i < rows.size();i++) {
            sum += Math.abs(middle - rows.get(i));
        }
        Collections.sort(columns);
        middle = columns.get(columns.size()/2);
        for (int i =0; i < columns.size();i++) {
            sum+= Math.abs(middle - columns.get(i));
        }
        return sum;
    }
