public int findMin(int[] nums) {
        int i =0;
        int j = nums.length - 1;
        if (nums[0] < nums[j]) {
            return nums[0];
        }
        
        while(i + 1 < j) {
            int middle = (i + j) / 2;
            if (nums[i] < nums[j]) {
                return nums[i];
            }
            if (nums[middle] > nums[i]) {
                i = middle ;
            } else {
                j = middle ;
            }
        }
        return Math.min(nums[i], nums[j]);
    }
