public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int i = start + 1;
            while (i <= end && nums[i] == nums[start]) i++;
            if (i > end) {
                return start + 1; //[start+1, end] all duplicate
            }
            //now i point the first one different with nums[start]
            //[start + 1,  i-1] are duplicate
            //we can move [i, end ] to [start + 1, end + 1 + start - i]
            // [start + 1, i -1]  = i - 1 - start
            if (i > start + 1) {
                System.arraycopy(nums, i, nums, start + 1, end - i + 1);
                end = end + 1 + start - i;
            }
            start = start + 1;
        }
        return end + 1;
    }
