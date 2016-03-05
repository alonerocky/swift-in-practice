public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left=0;
        int right = nums.length;
        int i = 0; 
        //left point to start of 1
        //right point to start of 2
        while (i < right) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, i++,left++);
            } else{
                swap(nums, i, --right);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
