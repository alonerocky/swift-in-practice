public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> result = new HashSet<Integer>();
        if (len1 < len2) {
            for (int i = 0; i < len2;i++) {
                set.add(nums2[i]);
            }
            for (int i = 0; i < len1;i++) {
                if (set.contains(nums1[i])) {
                    result.add(nums1[i]);
                }
            }
        } else {
            for (int i = 0; i < len1;i++) {
                set.add(nums1[i]);
            }
            for (int i = 0; i < len2;i++) {
                if (set.contains(nums2[i])) {
                    result.add(nums2[i]);
                }
            }
        }
        int[] insections = new int[result.size()];
        int i = 0;
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()) {
            insections[i++] = iterator.next();
        }
        return insections;
        
    }
    public int[] intersectionI(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        Iterator<Integer> iterator = set.iterator();
        int[] result = new int[set.size()];
         i = 0;
        while(iterator.hasNext()) {
            result[i++] = iterator.next();
        }
        return result;
    }
