//http://blog.welkinlan.com/2015/11/05/longest-increasing-subsequence-leetcode-java/
//http://www.geeksforgeeks.org/construction-of-longest-monotonically-increasing-subsequence-n-log-n/
    
public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> tail = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            
            int num = nums[i];
            if (tail.size() == 0 || num > tail.get(tail.size() - 1)) {
                tail.add(num);
            } else {
                updateLIS(tail, num);
            }
            
        }
        return tail.size();
    }
    private void updateLIS(ArrayList<Integer> tail, int key) {
        int l = 0;
        int r = tail.size() - 1;
        while(l < r) {
            int m = (l + r)/2;
            if (tail.get(m) < key) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        tail.set(l, key);
    }
    public int lengthOfLIS_I(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int len = nums.length;
        
        int[] dp = new int[len];
        dp[len-1] = 1;
        for (int i = len-2; i >= 0; i--) {
            int m = 0;
            for (int j = i+1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    m = Math.max(m, dp[j]);
                }
            }
            dp[i] = 1 + m;
            max = Math.max(max, dp[i]);
        }
       return max;
    }
