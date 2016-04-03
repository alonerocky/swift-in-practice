/*
    The problem of asking how many ways to do something is usually very easy!
And it could always be solved through dynamic programming. You just need to carefully design the transitional function acoording to characteristics or certain restrictions. 

We know for each post, it could differ or same as its previous post's color.
Assume: 
differ_count: represents the current post with different color with its previous post(the painting ways)
same_count: represents the current post share the same color with its previous post(the painiting ways)

We could have following trasitinao function
differ_count(i) = differ_count(i-1) * (k-1) + same_count(i-1) * (k-1)
same_count(i) = differ_count(i-1) //cause the current post must have the same color with post i-1, thus we could only use the way that differ_count(i-1)

Base case:
2 is a perfect base case for use to start, since it has simple same_count and differ_count;
    */
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int[] dp = new int[n];
        //dp[i] means different paiting ways for fence i, fence is labled 0,1,...n-1
        dp[0] = k; //
        dp[1] = k * k; //could be same or different with fence 0
        //dp[i] = (k-1) * (dp[i-1] + dp[i-2), either different with i-1, or different with i-2, would not be the same as i-1 and i-2
        for (int i =2; i < n; i++) {
            dp[i] = (k-1) * (dp[i-1] + dp[i-2]);
            
        }
        return dp[n-1];
    }
    public int numWaysI(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int same_colors = 0;
        int diff_colors = k;
        for (int i = 1; i <n;i++) {
            int same = diff_colors;
            int diff = (k - 1) * (same_colors + diff_colors);
            same_colors = same;
            diff_colors = diff;
        }
        return same_colors + diff_colors;
    }
