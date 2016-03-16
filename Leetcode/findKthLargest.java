public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k); //become k is the index in desc order sorted array
    }
    public int findKthLargest(int[] nums, int start, int end, int k) {
       
       int pivot = nums[start];
       int i = start;
       int j = end;
       //all the number that bigger than pivot appear on the left
       while (i <= j ) {
           if (nums[i] >= pivot) {
               i++;
           } else if (nums[j] <= pivot) {
               j--;
           } else {
               //i point to number <= pivot
               //j point to number > pivot
               swap(nums,i,j);
               i++;
               j--;
           }
       }
       swap(nums, start, j);
       if (j == k-1) {
           return nums[j];
       } else if (j < k - 1) {
           return findKthLargest(nums, j + 1, end, k);
       } else {
           return findKthLargest(nums, start, j - 1, k);
       }
       
        
    }
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
