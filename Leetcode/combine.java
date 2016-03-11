public List<List<Integer>> combine(int n, int k) {
        //c(n, k) = c(n-1, k) U c(n_1, k-1)
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < 0 || k > n) {
            return result;
        } else if (k == 0) {
            List<Integer> empty = new ArrayList<Integer>();
            result.add(empty);
            return result;
        } else {
            int[] nums = new int[n];
            for (int i =0; i < n; i++) {
                nums[i] = i+1;
            }
            return combine(n, k, nums, 0, n-1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k, int[] nums, int start, int end) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < 0 || k > n) {
            return result;
        } else if (k == 0) {
            List<Integer> empty = new ArrayList<Integer>();
            result.add(empty);
            return result;
        } else if (n == k) {
            List<Integer> complete = new ArrayList<Integer>();
            for (int i = start; i <= end; i++) {
                complete.add(nums[i]);
            }
            result.add(complete);
            return result;
        } else {
            int first = nums[start];
            List<List<Integer>> excludeFirst = combine(n-1, k, nums, start + 1, end);
            List<List<Integer>> includeFirst = combine(n-1, k-1, nums, start + 1, end);
            for (int i =0 ; i < excludeFirst.size(); i++) {
                ArrayList<Integer> oneResult = (ArrayList<Integer>)excludeFirst.get(i);
                result.add(oneResult);
            } 
            for (int i =0 ;i < includeFirst.size(); i++) {
                ArrayList<Integer> oneResult = (ArrayList<Integer>)includeFirst.get(i);
                oneResult.add(0, first);
                result.add(oneResult);
            }
            return result;
        }
    }
