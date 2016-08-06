public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
            return 0;
        }
        int m = triangle.length;
        int n = triangle[m-1].length;
        int[] result = new int[n];
        for(int i = 0; i < n ; i++) {
            result[i] =triangle[m-1][i];
        }
        for(int i = m-2; i >= 0; i--) {
            for(int j = 0; j <=  i; j++) {
                result[j] = triangle[i][j] + Math.min(result[j], result[j+1]);
            }
        }
        return result[0];
    }
