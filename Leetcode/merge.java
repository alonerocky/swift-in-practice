public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0 || n == 0) {
            return;
        }
        
        System.arraycopy(nums2, 0, nums1, m, n);
        int middle = m - 1;
        int i = 0;
        int j = m;
        int end = m+n-1;
        
        while (i <= middle && j <= end) {
            if (nums1[i] <= nums1[j]) {
                i++;
            } else {
                
                //i point to bigger one
                int temp = nums1[j];
                //move [i, j-1] to [i+1, j] , numbers of element is j - i
                System.arraycopy(nums1, i, nums1, i+1, j - i);
                nums1[i] = temp;
                i++;
                middle++;
                j++;
            }
        }
    }
