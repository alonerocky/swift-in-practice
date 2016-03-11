ipublic List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        return permuteUnique(nums, 0, nums.length - 1);
    }
    public List<List<Integer>> permuteUnique(int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (start > end) {
            return result;
        } else if (start == end) {
            List<Integer> one = new ArrayList<Integer>();
            one.add(nums[start]);
            result.add(one);
            return result;
        } else {
            int first = nums[start];
            List<List<Integer>> result_n_1 = permuteUnique(nums, start + 1, end);
            HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
            for (int i =0; i < result_n_1.size(); i++) {
                ArrayList<Integer> node = (ArrayList<Integer>)result_n_1.get(i);
                for (int j = 0; j <= node.size(); j++) {
                    ArrayList<Integer> cloned = (ArrayList<Integer>)node.clone();
                    cloned.add(j, first);
                    if (set.add(cloned)) {
                        result.add(cloned);
                    }
                }
            }
            return result;
        }
    }
