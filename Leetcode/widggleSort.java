public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            //i is even,  nums[i] <= nums[i+1]
            if (i %2 == 0 && nums[i] > nums[i+1] ||
                    i % 2 == 1 && nums[i] < nums[i+1]) {
                swap(nums, i, i+1);
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
