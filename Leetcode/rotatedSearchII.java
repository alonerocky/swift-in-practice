 public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j ) /2;
            int median = nums[middle];
            if (median == target) {
                return true;
            } else if (nums[i] < median) {
                if (nums[i] <= target && target < median) {
                    j = middle - 1;
                } else {
                    i = middle + 1;
                }
            } else if (nums[i] > median) {
                if (median < target && target <= nums[j]) {
                    i = middle + 1;
                } else {
                    j = middle - 1;
                }
            } else {
                i++;
            }
        } 
        return false;
    }
