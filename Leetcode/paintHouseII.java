public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int k = costs[0].length;
        int[] dp = new int[k];
        
        for (int i =0 ;i < k; i++) {
            dp[i] = costs[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            int min_1 = Integer.MAX_VALUE;
            int min_2 = Integer.MAX_VALUE;
            int min_index_1 = -1;
            int min_index_2 = -1;
            for (int j = 0; j < k; j++) {
                
                if (dp[j] <= min_1) {
                    min_2 = min_1;
                    min_index_2 = min_index_1;
                    min_1 = dp[j];
                    min_index_1 = j;
                } else if (dp[j] < min_2) {
                    min_2 = dp[j];
                    min_index_2 = j;
                }
                
            }
            for (int j = 0; j < k; j++) {
                
                dp[j] = (j == min_index_1 ? min_2 : min_1) + costs[i][j];
                
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            result = Math.min(result, dp[i]);
        }
        return result;
    }
    public int minCostII_nk(int[][] costs) {
        
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        
        
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            
            int min_index_1 = -1; //the minimal 
            int min_index_2 = -1; //the secondary minimal
            
            int min_1 = Integer.MAX_VALUE;
            int min_2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (dp[i-1][j] <= min_1) {
                    //update min index
                    min_index_2 = min_index_1;
                    min_index_1 = j;
                    //update min value
                    min_2 = min_1;
                    min_1 = dp[i-1][j];
                } else if (dp[i-1][j] < min_2) {
                    min_index_2 = j;
                    min_2 = dp[i-1][j];
                }
            }
            //now update dp[i][k]
            for (int j = 0; j < k; j++) {
                
                dp[i][j] = (min_index_1 == j ? min_2 : min_1 ) + costs[i][j];
                
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            result = Math.min(result, dp[n-1][i]);
        }
        return result;
        
        
    }
    
    /*
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int k = costs[0].length;
        int[][] min = new int[n][k];
        for (int i = 0; i < k; i++) {
            min[0][i] = costs[0][i];
        }
        //min[i][j] 
        for (int i = 1; i < n; i++) {
            
            for (int curColor = 0; curColor < k; curColor++) {
                int min1 = Integer.MAX_VALUE;
                for (int j = 0; j < k; j++) {
                    if (j == curColor) {
                        continue;
                    }
                    min1 = Math.min(min1, min[i-1][j]);
                }
                min[i][curColor] = min1 + costs[i][curColor];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i =0; i < k; i++) {
            result = Math.min(result, min[n-1][i]);
        }
        return result;
    }
    
    */
