public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            addRange(lower, upper, result);
            return result;
        }
        int len = nums.length;
        if (lower < nums[0]) {
            addRange(lower, nums[0] - 1, result);
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i-1] > 1) {
                addRange(nums[i-1] + 1, nums[i] - 1, result);
            }
            
        }
        
        if (upper > nums[len-1]) {
            addRange(nums[len-1] + 1, upper, result);
        }
        return result;
    }
    
    public void addRange(int lower, int upper, List<String> result) {
        StringBuffer sb = new StringBuffer();
        if (lower == upper) {
            sb.append(lower);
            result.add(sb.toString());
        } else if (upper < lower) {
            //do nothing
        } else {
            sb.append(lower+"->"+upper);
            result.add(sb.toString());
        }
    }
