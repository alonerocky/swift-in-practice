public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int end = nums.length - 1;
        int start = 0;
        int size = nums.length;
        while (start <= end) {
            if (nums[start] != val) {
                start++;
            } else {
                //move [start + 1, end] to [start, end - 1]
                //num = end - start
                if (start < end) {
                    System.arraycopy(nums, start + 1, nums, start, end - start);
                }
                size--;
                end--;
            }
        }
        return size;
    }
