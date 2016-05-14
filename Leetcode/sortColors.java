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


public void sortColors(int[] nums) {
           if (nums == null || nums.length == 0) {
               return;
           }
           int[] counts = new int[3]; //0, 1, 2
           for (int i = 0; i < nums.length; i++) {
               counts[nums[i]]++;
           }
           if (counts[0] > 0) {
               Arrays.fill(nums, 0, counts[0], 0);
           }
           if (counts[1] > 0) {
               Arrays.fill(nums, counts[0], counts[0]+counts[1], 1);
           }
           if (counts[2] > 0) {
               Arrays.fill(nums, counts[0]+counts[1], counts[0]+counts[1]+counts[2], 2);
           }
          
    }
