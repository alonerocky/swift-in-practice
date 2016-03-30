public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums == null || nums.length < 2) {
            return result;
        }
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i =0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (dict.containsKey(delta)) {
                result[0] = dict.get(delta);
                result[1] = i;
                return result;
            }
            dict.put(nums[i], i);
        }
        return result;
    }
