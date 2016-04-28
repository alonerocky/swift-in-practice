public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                continue;
            }
            map.put(num,1);
            
            if (map.containsKey(num-1)) {
                max = Math.max(max, merge(map, num-1, num));
            }
            if (map.containsKey(num+1)) {
                max = Math.max(max, merge(map, num, num+1));
            }
        }
        return max;
    }
    
    public int merge(HashMap<Integer, Integer> map, int left, int right) {
        //upper - right + 1 = map.get(right) 
        //left - lower + 1 = map.get(left)
        int upper = right + map.get(right)  - 1;
        int lower = left + 1 - map.get(left);
        int len = upper - lower + 1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }
