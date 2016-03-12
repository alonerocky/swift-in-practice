public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int i = 0;
        while (i < nums.length) {
            boolean biggerThanLeft = i == 0 ? true: nums[i] > nums[i-1];
            boolean biggerThanRight = i == nums.length - 1 ? true : nums[i] > nums[i+1];
            if (biggerThanLeft && biggerThanRight) {
                return i;
            }
            i++;
        }
        return -1;
    }
