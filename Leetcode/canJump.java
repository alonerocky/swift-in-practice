// http://fisherlei.blogspot.com/2012/12/leetcode-jump-game.html
    // Just one round DP. No need an array to track the status. Refactor the code.
    public boolean canJump(int A[]) { 
        int n = A.length, maxCover = 0;  
        for(int start = 0; start <= maxCover && start < n; start++) {  
            if(A[start]+start > maxCover)  
            maxCover = A[start]+start;  
            if(maxCover >= n-1) return true;  
        }  
        return false;  
    }

public boolean canJump(int[] A) 
    { 
        if(A == null || A.length == 0)
            return false;
             
        int len = A.length;
        boolean[] dp = new boolean[len];
        dp[len-1] = true;
         
        for(int i = len-2; i >= 0; i--)
        {
             
            boolean flag = false;
            int maxSteps = A[i];
            maxSteps = Math.min(maxSteps,  len-1 - i);
            for(int j = maxSteps; j >= 1; j-- )
            {
                if(dp[i+j])
                {
                    flag = true;
                    break;
                }
            }
            dp[i] = flag;
             
        }
        return dp[0]; 
    }
