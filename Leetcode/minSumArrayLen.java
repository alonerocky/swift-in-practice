 public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0; 
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        boolean found = false;
        int curSum = 0;
        int start = 0;
        while (i < len) {
            
           curSum += nums[i];
           if (curSum >= s) {
               found = true;
               while(start <= i && curSum - nums[start] >= s) {
                   curSum -= nums[start];
                   start++;
               }
               //[start, i]
               min = Math.min(min, i - start + 1);
           }
           i++;
            
        }
        if (!found) {
            return 0;
        } else {
            return min;
        }
    }
