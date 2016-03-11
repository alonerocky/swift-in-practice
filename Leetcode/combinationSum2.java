public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target == 0) {
            List<Integer> empty = new ArrayList<Integer>();
            result.add(empty);
            return result;
        } else if (target < 0 || candidates == null || candidates.length == 0) {
            return result;
        } else {
            return combinationSum2(candidates, target, 0, candidates.length - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target, int start, int end) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target == 0) {
            List<Integer> empty = new ArrayList<Integer>();
            result.add(empty);
            return result;
        } else if (target < 0 || start > end) {
            return result;
        } else {
            Arrays.sort(nums);
            int first = nums[start];
            if (first > target) {
                return result;
            }
            HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
            List<List<Integer>> excludeFirst = combinationSum2(nums, target, start + 1, end);
            List<List<Integer>> includeFirst = combinationSum2(nums, target - first, start + 1, end);
            for (int i =0; i < excludeFirst.size(); i++) {
                ArrayList<Integer> oneResult = (ArrayList<Integer>)excludeFirst.get(i);
                set.add(oneResult);
                result.add(oneResult);
            }
            for (int i =0; i < includeFirst.size(); i++) {
                ArrayList<Integer> oneResult = (ArrayList<Integer>)includeFirst.get(i);
                oneResult.add(0, first);
                if (set.add(oneResult)) {
                    result.add(oneResult);
                }
            }
            return result;
        }
    }
