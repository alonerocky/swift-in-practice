public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target == 0) {
            List<Integer> empty = new ArrayList<Integer>();
            result.add(empty);
            return result;
        } else if (target < 0 || candidates == null || candidates.length == 0) {
            return result;
        } else {
            return combinationSum(candidates, target, 0, candidates.length - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] nums, int target, int start, int end) {
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
            
            for (int count = 0; first * count <= target ; count++) {
                List<List<Integer>> res = combinationSum(nums, target - first * count, start + 1, end);
                for (int j =0; j < res.size();j++) {
                    ArrayList<Integer> oneResult = (ArrayList<Integer>)res.get(j);
                    for(int k =0; k < count; k++) {
                        oneResult.add(0, first);
                    }
                    if (set.add(oneResult)) {
                        result.add(oneResult);
                    }
                }
            }
            return result;
        }
    }
