public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][1], costs[i-1][0]);
        }
        return Math.min(Math.min(costs[n-1][0], costs[n-1][1]), costs[n-1][2] );
    }


public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int len = costs.length;
        int[][] min = new int[costs.length][3];
        min[0][0] = costs[0][0];
        min[0][1] = costs[0][1];
        min[0][2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            min[i][0] = Math.min(min[i-1][1], min[i-1][2]) + costs[i][0];
            min[i][1] = Math.min(min[i-1][0], min[i-1][2]) + costs[i][1];
            min[i][2] = Math.min(min[i-1][0], min[i-1][1]) + costs[i][2];
        }
        return Math.min(min[len-1][0], Math.min(min[len-1][1], min[len-1][2]));
    }
