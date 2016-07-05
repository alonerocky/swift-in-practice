public boolean canJumpI(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }
        int len = A.length;
        boolean[] dp = new boolean[len];
        dp[len-1] = true;
        for(int i = len-2; i >= 0; i--) {
            int n = A[i];
            boolean flag = false;
            int max = Math.min(n, len-1-i);
            for(int j = 1; j <= max; j++) {
                flag |= dp[i+j];
            }
            dp[i] = flag;
        }
        return dp[0];
    }
    
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }
        int len = A.length;
        int max = 0;
        int i = 0;
        while(i <= max ) {
            max = Math.max(i+A[i], max);
            if (max >= len-1) {
                return true;
            }
            i++;
        }
        return false;
    }
