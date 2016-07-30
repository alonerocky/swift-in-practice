public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int i = 0;
        while (i < nums.length) {
            boolean biggerThanLeft = i == 0 ? true: nums[i] > nums[i-1];
            boolean biggerThanRight = i == nums.length - 1 ? true : nums[i] > nums[i+1];
            if (biggerThanLeft && biggerThanRight) {
                return i;
            }
            i++;
        }
        return -1;
    }


public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return findPeakElement(nums, 0, nums.length-1,nums.length);
    }
    public int findPeakElement(int[] nums, int low, int high, int n) {
        
           int middle = (low+high)/2;
            if( (middle == 0 || nums[middle-1] < nums[middle]) && (middle == n-1 || nums[middle] > nums[middle+1])) {
                return middle;
            } else if (middle > 0 && nums[middle-1] > nums[middle]) {
                return findPeakElement(nums, low, middle-1,n);
            }  else {
                return findPeakElement(nums, middle+1, high, n);
            }
    }



public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int middle = (low + high)/2;
            if ((middle == 0 || nums[middle-1] < nums[middle]) && (middle == nums.length - 1 || nums[middle] > nums[middle+1])) {
                return middle;
            } else if (middle > 0 && nums[middle-1] > nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
