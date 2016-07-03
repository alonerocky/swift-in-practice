public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> result = new HashSet<Integer>();
        int i =0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] r = new int[result.size()];
         i=0;
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()) {
            r[i++] = iterator.next();
        }
        return r;
     }
    public int[] intersectionI(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        HashSet<Integer> result = new HashSet<Integer>();
        for(int i = 0; i < nums2.length;i++) {
            if (binarySearch(nums1, nums2[i])) {
                result.add(nums2[i]);
            }
        }
        
        
        int[] r = new int[result.size()];
        int i=0;
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()) {
            r[i++] = iterator.next();
        }
        return r;
    }
    private boolean binarySearch(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while(i <= j) {
            int middle = (i+j)/2;
            if (a[middle] == target) {
                return true;
            } else if (a[middle] < target) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return false;
    }
    public int[] intersectionII(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums1.length;i++) {
            set.add(nums1[i]);
        }
        HashSet<Integer> result = new HashSet<Integer>();
        for(int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        int[] r = new int[result.size()];
        int i=0;
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()) {
            r[i++] = iterator.next();
        }
        return r;
    }
