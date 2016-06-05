public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (nums[0] < nums[len-1]) {
            return nums[0];
        }
        int i = 0;
        int j = len-1;
        while(i +1 < j) {
            if (nums[i] < nums[j]) {
                return nums[i];
            }
            int middle = (i+j)/2;
            if (nums[middle] > nums[j]) {
                i = middle;
            } else {
                j = middle;
            }
        }
        return Math.min(nums[i], nums[j]);
    }
