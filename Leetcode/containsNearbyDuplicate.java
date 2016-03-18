public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashMap<Integer, ArrayList<Integer>> dict = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (dict.containsKey(num)) {
                ArrayList<Integer> indices = dict.get(num);
                int lastIndex = indices.get(indices.size() - 1);
                if (i - lastIndex <= k) {
                    return true;
                } else {
                    indices.add(i);
                }
            } else {
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                dict.put(num, indices);
            }
        }
        return false;
    }
