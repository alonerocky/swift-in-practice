public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int len = nums.length;
        int i = len-2;
        while(i >= 0 && nums[i] >= nums[i+1] ) {
            i--;
        }
        if (i < 0) {
            //like 8765
            reverse(nums, 0, len-1);
            return nums;
        }
        //8465  i point to 4
        int j = i + 1;
        while(j < len && nums[j] > nums[i]) {
            j++;
        }
        //j-1 point to the smallest num which is greater than nums[i]
        swap(nums, i, j-1);
        reverse(nums, i+1, len-1);
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    public void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        while(i < j) {
            swap(nums, i++, j--);
        }
    }
