public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int sum = nums.get(0);
        int min = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            if (sum > 0) {
                sum = 0;
            }
            sum  +=  nums.get(i);
            min = Math.min(min, sum);
        }
        return min;
    }
