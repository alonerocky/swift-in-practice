public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 2;
            }
        }
        
        for (int i =0;i < nums.length; i++) {
            
            int value = Math.abs(nums[i]);
            
            if (value > 0 && value  <= nums.length && nums[value-1] > 0) {
                
                nums[value-1] = - nums[value-1];
            }
        }
        int i = 0;
        for (;i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
        }
        return i+1;
    }
