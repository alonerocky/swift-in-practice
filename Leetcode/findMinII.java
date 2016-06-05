public int findMin(int[] nums) {
         if (nums == null || nums.length == 0) {
             return 0;
         }
         int i =0;
         int j = nums.length - 1;
         while(i + 1 < j) {
             int middle = (i+j)/2;
             if( nums[i] == nums[middle] ) {
                 i++;
                 continue;
             }
             if (nums[i] < nums[j]) {
                 return nums[i];
             } else if (nums[i] < nums[middle]) {
                 i = middle + 1;
             } else if (nums[middle] <= nums[j]){
                 j = middle;
             }
             
             
         }
         return Math.min(nums[i], nums[j]);
    }
