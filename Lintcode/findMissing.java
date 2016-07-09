public int findMissing(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        
        for(int i = 0; i < len; i++) {
            
            int n = Math.abs(nums[i]);
            if (n >= 0 && n < len && nums[n] > 0) {
                nums[n] = -nums[n];
            }
        }
        int i = 0;
        for(; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
        }
        return i;
    }
