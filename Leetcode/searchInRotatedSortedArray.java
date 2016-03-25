public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int i = 0; 
        int j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j)/2;
            int median = nums[middle];
            if (target == median) {
                return middle;
            } else if (nums[i] <=  median) { //left side sorted
                if (nums[i] <= target && target < median) {
                    j = middle-1;
                } else {
                    i = middle + 1;
                }
            } else if (median <  nums[j]) { //right side sorted
                if (median < target && target <= nums[j]) {
                    i = middle + 1;
                } else {
                    j = middle - 1;
                }
            }  
        }
        return -1;
    }
