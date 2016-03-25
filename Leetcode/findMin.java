public int findMin(int[] nums) {
        int min = nums[0];
        int i =0;
        int j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) /2;
            int median = nums[middle];
            if (median < nums[j]) { //right side is sorted
                min = Math.min(min, median);
                j = middle - 1;
            } else { //nums[i] <= median
                min = Math.min(min, nums[i]);
                i = middle + 1;
            }
        }
        return min;
    }
