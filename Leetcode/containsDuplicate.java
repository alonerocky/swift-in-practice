public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i =0 ;i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() < nums.length;
    }
