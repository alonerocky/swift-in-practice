public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        int result;
        //initialize
        if (target >= 0) {
            result = Integer.MAX_VALUE;
        } else {
            result = Integer.MIN_VALUE;
        }
        for (int i =0; i + 2 < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (Math.abs(total - target) < Math.abs(result - target) ) {
                         result = total;
                }
                if (total == target) {
                    return target;
                } else if (total < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
