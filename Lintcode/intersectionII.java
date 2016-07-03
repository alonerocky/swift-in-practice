public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i < nums2.length;i++) {
            if (map.containsKey(nums2[i])) {
                map.put(nums2[i], map.get(nums2[i]) + 1);
            } else {
                map.put(nums2[i], 1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length;i++) {
             if (map.containsKey(nums1[i]) && map.get(nums1[i]) > 0 ) {
                 list.add(nums1[i]);
                 map.put(nums1[i], map.get(nums1[i]) - 1);
             }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size();i++) {
            result[i] = list.get(i);
        }
        return result;
     }
