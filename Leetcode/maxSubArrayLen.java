public int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length ; i++) {
            int result = nums[i];
            if (result == k) {
                max = Math.max(max, 1);
            }
            for (int j = i+ 1; j < nums.length; j++) {
                result += nums[j];
                if (result == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
