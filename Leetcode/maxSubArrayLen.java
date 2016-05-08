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


//O(n)
 public int maxSubArrayLen(int[] nums, int k) 
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //map.put(0, 0);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            sum += nums[i];
            //[map.get(sum-k), i]
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum-k) + 1);
            }
        }
        return max;
    }
