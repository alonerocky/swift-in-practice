public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        //8461 --> 8614
        int i = nums.length - 2;
        
        //find the longest non-desc order from right to left
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        
        if (i < 0) {
            //this is the biggest one
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        //now i point 4 in this case
        int j = i+1;
        while (j < nums.length && nums[j] > nums[i]) j++;
        
        //j now point to 1
        //j - 1 .point to the 6
        swap(nums, i, j-1);
        reverse(nums,i+1, nums.length - 1);
        
        
    }
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    private void reverse(int[] nums, int start, int end) {
        if (nums == null || nums.length ==0 || start < 0 || end >= nums.length || start > end) {
            return;
        }
        
        int i = start;
        int j = end;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
