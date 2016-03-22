public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i =0; 
        int len = nums.length;
        while (i < len) {
            
            int j = i+1;
            while (j < len && nums[j] == nums[i] ) {
                j++;
            }
            //j now point the end or the first element different with nums[i]
            int duplicate = j - i;
            if (duplicate > 2) {
                    //move [j, len -1] to [i+2, len - j + i + 1]
                if (j < len) {
                    System.arraycopy(nums, j, nums, i+2, len  - j);
                }
                len -= (duplicate - 2);
                i+= 2;
            } else {
                i = j;
            }
            
        }
        return len;
    }
