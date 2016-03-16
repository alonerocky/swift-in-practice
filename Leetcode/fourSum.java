public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i =0; i < nums.length - 3 ; i++) {
            for (int j = i+1; j < nums.length - 2; j++) {
                int k = j + 1;
                int t = nums.length -1;
                
                while (k < t) {
                    int total = nums[i] + nums[j] + nums[k] + nums[t];
                    if (total == target) {
                        ArrayList<Integer> oneResult = new ArrayList<Integer>();
                        oneResult.add(nums[i]);
                        oneResult.add(nums[j]);
                        oneResult.add(nums[k]);
                        oneResult.add(nums[t]);
                        if (set.add(oneResult)) {
                            result.add(oneResult);
                        }
                        k++;
                        t--;
                    } else if (total < target) {
                        k++;
                    } else {
                        t--;
                    }
                }
            }
        }
        return result;
    }
