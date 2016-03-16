public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i =0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total == 0) {
                    ArrayList<Integer> oneResult = new ArrayList<Integer>();
                    oneResult.add(nums[i]);
                    oneResult.add(nums[j]);
                    oneResult.add(nums[k]);
                    if (set.add(oneResult)) {
                        result.add(oneResult);
                    }
                    j++;
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
