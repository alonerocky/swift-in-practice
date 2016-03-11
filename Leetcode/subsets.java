public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        return subsets(nums, 0, nums.length - 1);
    } 
    public List<List<Integer>> subsets(int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (start > end) {
            return result;
        } else if (start == end) {
            List<Integer> empty = new ArrayList<Integer>();
            result.add(empty);
            List<Integer> complete = new ArrayList<Integer>();
            complete.add(nums[start]);
            result.add(complete);
            return result;
        } else {
            Arrays.sort(nums);
            List<List<Integer>> result_n_1 = subsets(nums, start + 1, end);
            int first = nums[start];
            for (int i =0 ; i < result_n_1.size(); i++ )
            {
                ArrayList<Integer> excludeFirst = (ArrayList<Integer>)result_n_1.get(i);
                ArrayList<Integer> includeFirst = (ArrayList<Integer>)excludeFirst.clone();
                result.add(excludeFirst);
                includeFirst.add(0, first);
                result.add(includeFirst);
            }
            return result;
        }
    }
