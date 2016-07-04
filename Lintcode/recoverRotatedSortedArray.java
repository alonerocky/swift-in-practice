public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() <= 1) {
            return;
        }
        int len = nums.size();
        int i = 0;
        while(i < len-1 && nums.get(i) <= nums.get(i+1)) {
            i++;
        }
        if (i == len-1) {
            return;
        }
        reverse(nums, 0, i);
        reverse(nums,i+1, len-1);
        reverse(nums, 0, len-1);
    }
    
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        int i = start;
        int j = end;
        while(i < j) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
            i++;
            j--;
        }
    }
