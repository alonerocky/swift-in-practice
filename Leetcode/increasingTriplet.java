public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < len ;i++) {
            int num = nums[i];
            if (num <= min) {
                min = num;
            } else if (num <= min2) { //min < num <= min2
                min2 = num;
            } else {
                return true;
            }
        }
        return false;
    }
